package cn.txy.service.impl;

import cn.txy.dao.CrmDictMapper;
import cn.txy.pojo.CrmDict;
import cn.txy.pojo.CrmDictExample;
import cn.txy.service.DictService;
import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private CrmDictMapper mapper;

    @Autowired
    private Logger logger;

    @Value("${enableRedis}")
    private String enableRedis;

    @Value("${redisDB}")
    private String redisDB;

    @Autowired
    private JedisPool jedisPool;


    @Override
    public List<CrmDict> selectDictByTypeCode(String code) {
        List<CrmDict> crmDicts;
        String key = "crmDicts" + code;     //存入redis时的key

        if ("true".equals(enableRedis)) {
            Jedis jedis = jedisPool.getResource();
            jedis.select(Integer.parseInt(redisDB));    //选择redis数据库
            String crmDictsJson = jedis.get(key);       //从redis取数据
            if (StringUtils.isNotEmpty(crmDictsJson)) {
                // redis命中, 则不再需要redis连接, 将其归还
                jedis.close();
                crmDicts = (List<CrmDict>) JSON.parse(crmDictsJson);
                logger.info("启用了redis, redis命中code为" + code + "的dict集合");
            } else {
                // redis未命中, 则从mysql取数据, 由新开线程负责缓存数据并归还连接
                crmDicts = queryFromMysql(code);
                logger.info("启用了redis但redis中无数据, 从mysql查询code为" + code + "的dict集合");
                new Thread(() -> {
                    jedis.setex(key, 60, JSON.toJSONString(crmDicts));  //过期时间一分钟, 方便查看效果
                    jedis.close();
                }).start();
            }
        } else {
            crmDicts = queryFromMysql(code);    //不启用redis则直接查mysql
        }

        return crmDicts;
    }

    private List<CrmDict> queryFromMysql(String code) {
        CrmDictExample crmDictExample = new CrmDictExample();
        crmDictExample.createCriteria().andDictTypeCodeEqualTo(code);
        return mapper.selectByExample(crmDictExample);
    }
}