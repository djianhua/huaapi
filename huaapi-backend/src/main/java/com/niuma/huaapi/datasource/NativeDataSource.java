package com.niuma.huaapi.datasource;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huaapi.model.es.InterfaceInfoDoc;
import com.niuma.huaapi.service.InterfaceInfoService;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author niuma
 * @create 2023-05-28 14:16
 */
@Component
public class NativeDataSource implements InterfaceInfoDataSource<InterfaceInfo>{
    @Resource
    InterfaceInfoService interfaceInfoService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public Page<InterfaceInfo> doSearch(String searchText, long pageNum, long pageSize) throws IOException {
//        InterfaceInfoQueryRequest interfaceInfoQueryRequest = new InterfaceInfoQueryRequest();
//        interfaceInfoQueryRequest.setDescription(searchText);
//        interfaceInfoQueryRequest.setName(searchText);
//        interfaceInfoQueryRequest.setPageSize(pageSize);
//        interfaceInfoQueryRequest.setCurrent(pageNum);
//        return interfaceInfoService.getInterfaceInfoPage(interfaceInfoQueryRequest);
        SearchRequest request = new SearchRequest("interface_info");
        if (searchText == null || searchText.length() == 0) {
            request.source().query(QueryBuilders.matchAllQuery());
        } else {
            request.source().query(QueryBuilders.matchQuery("all", searchText))
                    .from(Math.toIntExact((pageNum - 1) * pageSize))
                    .size(Math.toIntExact(pageSize));
        }
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits searchHits = response.getHits();
        List<InterfaceInfo> interfaceInfoList = new ArrayList<>();
        // 获取文档数组
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            // 4.4.获取source
            String json = hit.getSourceAsString();
            // 4.5.反序列化，非高亮的
            InterfaceInfoDoc interfaceInfoDoc = JSON.parseObject(json, InterfaceInfoDoc.class);
            // 4.6.处理高亮结果
            // 1)获取高亮map
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if (!CollectionUtils.isEmpty(highlightFields)) {
                // 2）根据字段名，获取高亮结果
                HighlightField highlightField = highlightFields.get("all");
                // 3）获取高亮结果字符串数组中的第1个元素
                String hName = highlightField.getFragments()[0].toString();
                // 4）把高亮结果放到HotelDoc中
                interfaceInfoDoc.setName(hName);
            }
            interfaceInfoList.add(interfaceInfoDoc.reverse(interfaceInfoDoc));
        }
        return new Page<InterfaceInfo>().setRecords(interfaceInfoList);
    }
}
