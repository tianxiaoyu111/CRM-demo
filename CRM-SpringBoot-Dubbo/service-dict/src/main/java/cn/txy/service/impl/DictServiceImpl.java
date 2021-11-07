package cn.txy.service.impl;

import cn.txy.dao.CrmDictMapper;
import cn.txy.pojo.CrmDict;
import cn.txy.pojo.CrmDictExample;
import cn.txy.service.DictService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private CrmDictMapper mapper;

    @Value("${enableRedis}")
    private String enableRedis;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public List<CrmDict> selectDictByTypeCode(String code) {
        List<CrmDict> crmDicts;
        String key = "crmDicts" + code;     //存入redis时的key
        Logger logger = LoggerFactory.getLogger(getClass());

        if ("true".equals(enableRedis)) {
            String crmDictsJson = stringRedisTemplate.opsForValue().get(key);       //从redis取数据
            if (StringUtils.isNotEmpty(crmDictsJson)) {
                crmDicts = (List<CrmDict>) JSON.parse(crmDictsJson);
                logger.info("启用了redis, redis命中code为" + code + "的dict集合");
            } else {
                // redis未命中, 则从mysql取数据, 由新开线程负责缓存数据
                crmDicts = queryFromMysql(code);
                logger.info("启用了redis但redis中无数据, 从mysql查询code为" + code + "的dict集合");
                new Thread(() -> {
                    stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(crmDicts), 60, TimeUnit.SECONDS);  //过期时间一分钟, 方便查看效果
                }).start();
            }
        } else {
            logger.info("未启用redis, 从mysql查询code为" + code + "的dict集合");
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