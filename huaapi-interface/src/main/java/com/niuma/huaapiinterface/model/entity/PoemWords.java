package com.niuma.huaapiinterface.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 诗词
 * @TableName poem_words
 */
@TableName(value ="poem_words")
@Data
public class PoemWords implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 诗词
     */
    private String poemWord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}