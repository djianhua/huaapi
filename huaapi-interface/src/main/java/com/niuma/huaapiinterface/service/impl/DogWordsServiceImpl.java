package com.niuma.huaapiinterface.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.huaapiinterface.mapper.DogWordsMapper;
import com.niuma.huaapiinterface.service.DogWordsService;
import org.springframework.stereotype.Service;

import com.niuma.huaapiinterface.model.entity.DogWords;

/**
* @author 33116
* @description 针对表【dog_words(舔狗日记)】的数据库操作Service实现
* @createDate 2023-04-07 10:18:16
*/
@Service
public class DogWordsServiceImpl extends ServiceImpl<DogWordsMapper, DogWords>
    implements DogWordsService {

}




