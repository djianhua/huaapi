package com.niuma.huaapicommon.service;

import com.niuma.huaapicommon.model.dto.UpdateUserInterfaceInfoDTO;

/**
 * @author niuma
 * @create 2023-02-27 15:40
 */
public interface InnerUserInterfaceInfoService  {

    /**
     * 接口调用次数+1
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId,long userId);

    /**
     * 更新用户接口信息
     * @param updateUserInterfaceInfoDTO
     * @return
     */
    boolean updateUserInterfaceInfo(UpdateUserInterfaceInfoDTO updateUserInterfaceInfoDTO);


    /**
     * 检验用户是否有调用次数
     * @param userId
     * @param interfaceId
     * @return
     */
    boolean checkUserInvokeAuth(Long userId,Long interfaceId);

}
