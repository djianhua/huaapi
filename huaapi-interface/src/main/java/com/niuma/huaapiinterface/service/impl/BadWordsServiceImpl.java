package com.niuma.huaapiinterface.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.huaapiinterface.mapper.BadWordsMapper;
import com.niuma.huaapiinterface.model.entity.BadWords;
import com.niuma.huaapiinterface.service.BadWordsService;
import org.springframework.stereotype.Service;

/**
* @author 33116
* @description 针对表【bad_words(毒鸡汤)】的数据库操作Service实现
* @createDate 2023-04-07 10:31:58
*/
@Service
public class BadWordsServiceImpl extends ServiceImpl<BadWordsMapper, BadWords>
    implements BadWordsService {

}




