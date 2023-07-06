package com.niuma.huaapiinterface.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niuma.huaapiinterface.model.entity.GodWords;

/**
* @author 33116
* @description 针对表【god_words(神回复)】的数据库操作Mapper
* @createDate 2023-04-07 10:05:57
* @Entity com.hua.huaapiinterface.model.entity.GodWords
*/
public interface GodWordsMapper extends BaseMapper<GodWords> {
    String getRandomGodWords();
}




