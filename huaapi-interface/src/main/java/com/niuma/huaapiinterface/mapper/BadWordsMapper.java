package com.niuma.huaapiinterface.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niuma.huaapiinterface.model.entity.BadWords;

/**
* @author 33116
* @description 针对表【bad_words(毒鸡汤)】的数据库操作Mapper
* @createDate 2023-04-07 10:31:57
* @Entity com.hua.huaapiinterface.model.entity.BadWords
*/
public interface BadWordsMapper extends BaseMapper<BadWords> {
    String getRandomBadWords();
}




