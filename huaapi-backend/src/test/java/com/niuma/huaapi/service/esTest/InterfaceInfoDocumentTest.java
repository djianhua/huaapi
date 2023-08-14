package com.niuma.huaapi.service.esTest;

import com.alibaba.fastjson.JSON;
import com.niuma.huaapi.model.es.InterfaceInfoDoc;
import com.niuma.huaapi.service.InterfaceInfoService;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class InterfaceInfoDocumentTest {

    private RestHighLevelClient client;

    @Autowired
    private InterfaceInfoService interfaceInfoService;

    // 插入文档
    @Test
    void testAddDocument() throws IOException {
        // 1.查询数据库hotel数据
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(44L);
        // 2.转换为HotelDoc
        InterfaceInfoDoc interfaceInfoDoc = new InterfaceInfoDoc(interfaceInfo);
        // 3.转JSON
        String json = JSON.toJSONString(interfaceInfoDoc);
        // 1.准备Request
        IndexRequest request = new IndexRequest("interface_info").id(interfaceInfoDoc.getId().toString());
        // 2.准备请求参数DSL，其实就是文档的JSON字符串
        request.source(json, XContentType.JSON);
        // 3.发送请求
        client.index(request, RequestOptions.DEFAULT);
    }
    // 查看文档
    @Test
    void testGetDocumentById() throws IOException {
        // 1.准备Request      // GET /hotel/_doc/{id}
        GetRequest request = new GetRequest("interface_info", "44");
        // 2.发送请求
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 3.解析响应结果
        String json = response.getSourceAsString();
        InterfaceInfoDoc interfaceInfoDoc = JSON.parseObject(json, InterfaceInfoDoc.class);
        System.out.println("interfaceInfoDoc = " + interfaceInfoDoc);
    }

    // 删除文档
    @Test
    void testDeleteDocumentById() throws IOException {
        // 1.准备Request      // DELETE /hotel/_doc/{id}
        DeleteRequest request = new DeleteRequest("interface_info", "44");
        // 2.发送请求
        client.delete(request, RequestOptions.DEFAULT);
    }

    // 更新文档
    @Test
    void testUpdateById() throws IOException {
        // 1.准备Request
        UpdateRequest request = new UpdateRequest("interface_info", "44");
        // 2.准备参数
        request.doc(
                "description", "随机输出诗词佳句，筛选自《诗经》、《名诗》等，诗句非常优美，非常有意境。"
        );
        // 3.发送请求
        client.update(request, RequestOptions.DEFAULT);
    }

    // 批量插入文档
    @Test
    void testBulkRequest() throws IOException {
        // 查询所有的酒店数据
        List<InterfaceInfo> list = interfaceInfoService.list();

        // 1.准备Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数
        for (InterfaceInfo interfaceInfo : list) {
            // 2.1.转为HotelDoc
            InterfaceInfoDoc interfaceInfoDoc = new InterfaceInfoDoc(interfaceInfo);
            // 2.2.转json
            String json = JSON.toJSONString(interfaceInfoDoc);
            // 2.3.添加请求
            request.add(new IndexRequest("interface_info").id(interfaceInfo.getId().toString()).source(json, XContentType.JSON));
        }

        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    @BeforeEach
    void setUp() {
        client = new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.88.136:9200")
        ));
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }



}
