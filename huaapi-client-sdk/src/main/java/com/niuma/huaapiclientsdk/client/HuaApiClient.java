package com.niuma.huaapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.niuma.huaapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.niuma.huaapiclientsdk.util.SignUtil.genSign;

/**
 * 调用第三方接口的客户端
 */
public class HuaApiClient {

    private String accessKey;
    private String secretKey;
    private static final String GATEWAY_HOST ="http://localhost:8002";

    public HuaApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getHeaderMap(String body) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
//        hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public String getUserByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        String result2 = HttpRequest.post(GATEWAY_HOST +"/api/interface/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute().body();
        return result2;
    }

    public String renjian() {
        String result2 = HttpRequest.get(GATEWAY_HOST +"/api/interface/renjian")
                .addHeaders(getHeaderMap(""))
                .execute().body();
        return result2;
    }

    //随机返回诗句
    public String getPoem() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/poem")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

    //随机情话接口
    public String getLoveWordsGet() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/lovewords")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

    //随机返回神回复
    public String getGodReplyGet() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/godreply")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

    //随机返回舔狗语录
    public String getLickDog() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/lickDog")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

    //随机返回毒鸡汤
    public String getBadSayingGet() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/badsaying")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

    //人生倒计时
    public String getTimeUsed() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/interface/time")
                .addHeaders(getHeaderMap(""))
                .body("")
                .execute();
        String result = httpResponse.body();
        return result;
    }

}
