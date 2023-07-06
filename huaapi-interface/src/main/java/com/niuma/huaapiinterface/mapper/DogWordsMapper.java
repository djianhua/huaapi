package com.niuma.huaapiinterface.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niuma.huaapiinterface.model.entity.DogWords;

/**
* @author 33116
* @description 针对表【dog_words(舔狗日记)】的数据库操作Mapper
* @createDate 2023-04-07 10:18:15
* @Entity com.hua.huaapiinterface.model.entity.DogWords
*/
public interface DogWordsMapper extends BaseMapper<DogWords> {
    String getRandomDogWords();
}




