package com.niuma.huaapiinterface.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niuma.huaapiinterface.model.entity.PoemWords;

/**
* @author 33116
* @description 针对表【poem_words(诗词)】的数据库操作Mapper
* @createDate 2023-04-07 09:06:59
* @Entity com.hua.huaapiinterface.model.entity.PoemWords
*/
public interface PoemWordsMapper extends BaseMapper<PoemWords> {
    String getRandomPoemWords();
}




