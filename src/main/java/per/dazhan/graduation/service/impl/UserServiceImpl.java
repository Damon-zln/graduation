package per.dazhan.graduation.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.dazhan.graduation.exception.TipException;
import per.dazhan.graduation.mapper.UserMapper;
import per.dazhan.graduation.model.User;
import per.dazhan.graduation.service.UserService;
import per.dazhan.graduation.utils.Utils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Damon-zln
 * @date 2019/3/2 17:10
 * @description UserServiceImpl
 * @update
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        String pwd = Utils.MD5encode(username + password);
        List<User> users = userMapper.selectByUser(username, pwd);
        if (users.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        return users.get(0);
    }

    @Override
    @Transactional
    public User register(String username, String password, String confirm) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirm)) {
            throw new TipException("用户名和密码不能为空");
        }
        if (!password.equals(confirm)) {
            throw new TipException("两次输入密码不一致");
        }
        List<User> users = userMapper.selectByName(username);
        if (users.size() != 0) {
            throw new TipException("该用户名已存在");
        }
        String encodePWD = Utils.MD5encode(username + password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePWD);
        userMapper.insertUser(user);
        List<User> userList = userMapper.selectByUser(username, encodePWD);
        return userList.get(0);
    }
}
