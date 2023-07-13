package com.niuma.huaapi.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author niuma
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userName;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

//    private String phoneNum;
    // 手机短信注册改为邮箱邮件注册
    private String emailNum;

    private String phoneCaptcha;

    private String captcha;
}
