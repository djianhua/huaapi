package com.niuma.huaapicommon.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * niuma
 */
public class AuthEmailNumberUtil {

    /**
     * 验证手机号是否符合要求
     * @param email
     * @return
     */
    public boolean isEmailNum(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
