package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 诗词
 * @TableName poem_words
 */
@TableName(value ="poem_words")
public class PoemWords implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 诗词
     */
    private String poemword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 诗词
     */
    public String getPoemword() {
        return poemword;
    }

    /**
     * 诗词
     */
    public void setPoemword(String poemword) {
        this.poemword = poemword;
    }
}