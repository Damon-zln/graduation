package per.dazhan.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import per.dazhan.graduation.constant.WebConst;
import per.dazhan.graduation.exception.TipException;
import per.dazhan.graduation.model.RestResponse;
import per.dazhan.graduation.model.User;
import per.dazhan.graduation.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Damon-zln
 * @date 2019/3/2 0:07
 * @description IndexController
 * @update
 */
@Controller
public class AuthController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/index")
    public String main(HttpSession session) {
        User user = (User) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
        if (user == null) {
            return "login";
        }
        return "index";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public RestResponse doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            User user = userService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        } catch (Exception e) {
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            }
            return RestResponse.fail(msg);
        }
        return RestResponse.ok();
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param confirm
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public RestResponse doRegister(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String confirm,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        try {
            User user = userService.register(username, password, confirm);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        } catch (Exception e) {
            String msg = "注册失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            }
            return RestResponse.fail(msg);
        }
        return RestResponse.ok();
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);// 立即销毁cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
