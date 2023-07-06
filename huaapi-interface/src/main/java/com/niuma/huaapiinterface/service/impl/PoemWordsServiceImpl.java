package com.niuma.huaapiinterface.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niuma.huaapiinterface.model.entity.PoemWords;
import com.niuma.huaapiinterface.service.PoemWordsService;
import com.niuma.huaapiinterface.mapper.PoemWordsMapper;
import org.springframework.stereotype.Service;

/**
* @author 33116
* @description 针对表【poem_words(诗词)】的数据库操作Service实现
* @createDate 2023-04-07 09:06:59
*/
@Service
public class PoemWordsServiceImpl extends ServiceImpl<PoemWordsMapper, PoemWords>
    implements PoemWordsService{

}




