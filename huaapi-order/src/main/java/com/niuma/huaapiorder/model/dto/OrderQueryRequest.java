package com.niuma.huaapiorder.model.dto;

import com.niuma.huaapicommon.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author niuma
 * @create 2023-05-07 20:30
 */
@Data
public class OrderQueryRequest extends PageRequest implements Serializable {
    private String type;
}
