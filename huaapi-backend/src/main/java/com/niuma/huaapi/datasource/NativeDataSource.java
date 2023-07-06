package com.niuma.huaapi.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huaapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.niuma.huaapi.service.InterfaceInfoService;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author niuma
 * @create 2023-05-28 14:16
 */
@Component
public class NativeDataSource implements InterfaceInfoDataSource<InterfaceInfo>{
    @Resource
    InterfaceInfoService interfaceInfoService;

    @Override
    public Page<InterfaceInfo> doSearch(String searchText, long pageNum, long pageSize) {
        InterfaceInfoQueryRequest interfaceInfoQueryRequest = new InterfaceInfoQueryRequest();
        interfaceInfoQueryRequest.setDescription(searchText);
        interfaceInfoQueryRequest.setName(searchText);
        interfaceInfoQueryRequest.setPageSize(pageSize);
        interfaceInfoQueryRequest.setCurrent(pageNum);
        return interfaceInfoService.getInterfaceInfoPage(interfaceInfoQueryRequest);
    }
}
