package com.niuma.huaapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.niuma.huaapi.model.vo.InterfaceInfoVO;
import com.niuma.huaapi.model.vo.UserInterfaceInfoVO;
import com.niuma.huaapicommon.model.dto.UpdateUserInterfaceInfoDTO;
import com.niuma.huaapicommon.model.entity.UserInterfaceInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author niumazlb
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2022-11-21 14:33:34
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add 是否为创建校验
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用次数 + 1
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId) ;

    /**
     * 获取调用次数前limit的接口信息
     * @param limit
     * @return
     */
    List<InterfaceInfoVO> interfaceInvokeTopAnalysis(int limit);

    /**
     * 更新用户接口信息
     * @param updateUserInterfaceInfoDTO
     * @return
     */
    boolean updateUserInterfaceInfo(UpdateUserInterfaceInfoDTO updateUserInterfaceInfoDTO);

    /**
     * 检验用户是否有调用次数
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    boolean checkUserInvokeAuth(Long userId, Long interfaceInfoId);

    /**
     * 根据Id获取某个用户拥有的接口信息
     * @param userId
     * @param request
     * @return
     */
    List<UserInterfaceInfoVO> getInterfaceInfoByUserId(Long userId, HttpServletRequest request);
}
