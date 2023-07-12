package com.niuma.huaapicommon.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 短信服务传输对象(邮箱)
 * @author niuma
 * @create 2023-07-12 11:16
 */
@Data
@AllArgsConstructor
public class EmailDTO implements Serializable {

    private static final long serialVersionUID = 8504215015474691352L;
    String emailNum;
    String code;
}
