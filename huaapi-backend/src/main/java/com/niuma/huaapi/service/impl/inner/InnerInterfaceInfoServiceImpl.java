package com.niuma.huaapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niuma.huaapi.mapper.InterfaceInfoMapper;
import com.niuma.huaapicommon.common.ErrorCode;
import com.niuma.huaapicommon.exception.BusinessException;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import com.niuma.huaapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author niuma
 * @create 2023-02-27 16:13
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {
    @Resource
    InterfaceInfoMapper interfaceInfoMapper;
    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if(StringUtils.isAnyBlank(url,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url",url);
        queryWrapper.eq("method",method);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);

        return interfaceInfo;
    }

    @Override
    public InterfaceInfo getInterfaceInfoById(Long id) {

        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectById(id);
        return interfaceInfo;
    }
}
