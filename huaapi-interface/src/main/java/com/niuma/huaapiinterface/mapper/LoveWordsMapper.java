package com.niuma.huaapiinterface.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niuma.huaapiinterface.model.entity.LoveWords;

/**
* @author MA_dou
* @description 针对表【love_words(情话)】的数据库操作Mapper
* @createDate 2023-03-20 20:43:36
* @Entity generator.domain.LoveWords
*/
public interface LoveWordsMapper extends BaseMapper<LoveWords> {

    String getRandomLoveWords();
}




