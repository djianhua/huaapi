package com.niuma.huaapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niuma.huaapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;

/**
* @author niumazlb
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2022-10-30 16:12:43
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 上线接口
     * @param id
     * @return
     */
    Boolean onlineInterfaceInfo(long id);

    /**
     * 下线接口
     * @param id
     * @return
     */
    Boolean offlineInterfaceInfo(long id);

    /**
     * 搜索分页接口信息
     * @param interfaceInfoQueryRequest
     * @return
     */
    Page<InterfaceInfo> getInterfaceInfoPage(InterfaceInfoQueryRequest interfaceInfoQueryRequest);


}
