package com.niuma.huaapi.service.impl.inner;


import com.niuma.huaapi.service.UserInterfaceInfoService;
import com.niuma.huaapicommon.model.dto.UpdateUserInterfaceInfoDTO;
import com.niuma.huaapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author niuma
 * @create 2023-02-27 15:47
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {

        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean updateUserInterfaceInfo(UpdateUserInterfaceInfoDTO updateUserInterfaceInfoDTO) {
        return userInterfaceInfoService.updateUserInterfaceInfo(updateUserInterfaceInfoDTO);
    }

    @Override
    public boolean checkUserInvokeAuth(Long userId, Long interfaceId) {
        return userInterfaceInfoService.checkUserInvokeAuth(userId, interfaceId);
    }


}
