package com.niuma.huaapiinterface.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.huaapiinterface.model.entity.GodWords;
import com.niuma.huaapiinterface.service.GodWordsService;
import com.niuma.huaapiinterface.mapper.GodWordsMapper;
import org.springframework.stereotype.Service;

/**
* @author 33116
* @description 针对表【god_words(神回复)】的数据库操作Service实现
* @createDate 2023-04-07 10:05:57
*/
@Service
public class GodWordsServiceImpl extends ServiceImpl<GodWordsMapper, GodWords>
    implements GodWordsService{

}




