package per.dazhan.graduation.service;

import per.dazhan.graduation.model.User;

/**
 * @author Damon-zln
 * @date 2019/3/2 17:07
 * @description UserService
 * @update
 */
public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 用户注册
     * @param username
     * @param password
     * @param confirm
     * @return
     */
    User register(String username, String password, String confirm);
}
