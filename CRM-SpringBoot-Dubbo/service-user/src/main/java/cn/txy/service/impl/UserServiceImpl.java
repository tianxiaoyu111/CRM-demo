package cn.txy.service.impl;

import cn.txy.dao.CrmUserMapper;
import cn.txy.dto.LoginResult;
import cn.txy.pojo.CrmUser;
import cn.txy.pojo.CrmUserExample;
import cn.txy.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CrmUserMapper userMapper;

    @Override
    public LoginResult login(String usercode, String password) {

        LoginResult result = new LoginResult();

        if (StringUtil.isEmpty(usercode) || StringUtil.isEmpty(password)) {
            result.setMsg("用户名或密码为空");
        } else {
            CrmUserExample crmUserExample = new CrmUserExample();
            crmUserExample.createCriteria().andUserCodeEqualTo(usercode);
            List<CrmUser> crmUsers = userMapper.selectByExample(crmUserExample);
            if (crmUsers.size() < 1) {
                result.setMsg("用户不存在");
            } else {
                if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(crmUsers.get(0).getUserPassword())) {
                    result.setUser(crmUsers.get(0));
                    result.setMsg("登录成功"); // 这句对于页面流程是没用的, 只是为了给日志用
                } else {
                    result.setMsg("密码错误");
                }
            }
        }

        LoggerFactory.getLogger(getClass()).info(usercode + "尝试登录, 登录信息: " + result.getMsg());
        return result;
    }
}
