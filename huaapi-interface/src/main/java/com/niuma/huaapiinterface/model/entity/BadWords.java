package com.niuma.huaapiinterface.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 毒鸡汤
 * @TableName bad_words
 */
@TableName(value ="bad_words")
@Data
public class BadWords implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 毒鸡汤
     */
    private String badWord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}