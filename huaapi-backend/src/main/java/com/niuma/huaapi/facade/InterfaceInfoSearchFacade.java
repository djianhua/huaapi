package com.niuma.huaapi.facade;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huaapi.datasource.DataSourceRegistry;
import com.niuma.huaapi.datasource.InterfaceInfoDataSource;
import com.niuma.huaapi.model.dto.interfaceinfo.InterfaceInfoSearchRequest;
import com.niuma.huaapi.model.enums.InterfaceInfoSearchEnum;
import com.niuma.huaapi.model.es.InterfaceInfoDoc;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author niuma
 * @create 2023-05-28 14:34
 */
@Component
public class InterfaceInfoSearchFacade {

    @Resource
    DataSourceRegistry dataSourceRegistry;

    public Page<InterfaceInfo> searchAll(InterfaceInfoSearchRequest interfaceInfoSearchRequest) throws IOException {
        String searchText = interfaceInfoSearchRequest.getSearchText();
        String type = interfaceInfoSearchRequest.getType();
        long current = interfaceInfoSearchRequest.getCurrent();
        long pageSize = interfaceInfoSearchRequest.getPageSize();

        if (StringUtils.isBlank(type)) {
            type = InterfaceInfoSearchEnum.NATIVE.getValue();
        }
        InterfaceInfoDataSource dataSourceByType = dataSourceRegistry.getDataSourceByType(type);
        return dataSourceByType.doSearch(searchText, current, pageSize);
    }
}
