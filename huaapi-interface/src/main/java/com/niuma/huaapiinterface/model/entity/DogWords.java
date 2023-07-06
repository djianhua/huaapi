package com.niuma.huaapiinterface.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 舔狗日记
 * @TableName dog_words
 */
@TableName(value ="dog_words")
@Data
public class DogWords implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 舔狗日记
     */
    private String dogWord;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}