package com.niuma.huaapithirdparty.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @Author hua
 * @Create 2023/7/12 9:07
 * @Description 用于发送邮箱验证码的工具类
 */
@Component
public class SendEmailUtils {
    // 把yml配置的邮箱赋值到from，发送方
    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.subject}")
    private String subject;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMsg(String to, String text) {
        // 发送简单邮件，不包括附件等
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(subject);
        message.setTo(to);
        message.setText(text);
        // 发送
        javaMailSender.send(message);
    }
}
