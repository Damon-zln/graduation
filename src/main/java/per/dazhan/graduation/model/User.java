package per.dazhan.graduation.model;

import java.io.Serializable;

/**
 * @author Damon-zln
 * @date 2019/3/2 16:30
 * @description User
 * @update
 */
public class User implements Serializable {

    /**
     * user表主键
     */
    private Integer uid;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 账号创建时间
     */
    private String create_time;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
