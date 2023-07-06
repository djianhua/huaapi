package com.niuma.huaapiinterface.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 神回复
 * @TableName god_words
 */
@TableName(value ="god_words")
@Data
public class GodWords implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 神回复
     */
    private String godWord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}