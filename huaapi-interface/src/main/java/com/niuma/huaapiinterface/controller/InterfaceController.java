package com.niuma.huaapiinterface.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.niuma.huaapiclientsdk.model.User;
import com.niuma.huaapiinterface.mapper.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author niuma
 * @create 2023-03-28 15:33
 */
@RestController
public class InterfaceController {

    @Resource
    private PoemWordsMapper poemWordsMapper;
    @Resource
    private LoveWordsMapper loveWordsMapper;
    @Resource
    private GodWordsMapper godWordsMapper;
    @Resource
    private DogWordsMapper dogWordsMapper;
    @Resource
    private BadWordsMapper badWordsMapper;

    @PostMapping("/user")
    public String getUserByPost(@RequestBody User user, HttpServletRequest request){
        return  "用户叫"+user.getUsername();
    }

    @GetMapping("/renjian")
    public String getRenjian(){
        return HttpRequest.get("https://v.api.aa1.cn/api/api-renjian/index.php?type=json").execute().body();
    }

    /**
     * 随机获取诗词
     * @return
     */
    @GetMapping("/poem")
    public String getPoem(){
        return poemWordsMapper.getRandomPoemWords();
    }

    /**
     * 随机返回土味情话
     * @return
     */
    @GetMapping("/lovewords")
    public String getLoveWordsGet(){
        return loveWordsMapper.getRandomLoveWords();
    }

    /**
     * 神回复
     * @return
     */
    @GetMapping("/godreply")
    public String getGodReply(){
        // 使用别人的接口
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-wenan-shenhuifu/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        // 为空查询本地数据库
        if (httpResponse.body() == null) {
            return godWordsMapper.getRandomGodWords();
        }
        return httpResponse.body();
    }

    /**
     * 舔狗语录
     * @return
     */
    @GetMapping("/lickDog")
    public String getLickDog(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/tiangou/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        // 为空查询本地数据库
        if (httpResponse.body() == null) {
            return godWordsMapper.getRandomGodWords();
        }
        return httpResponse.body();
    }

    /**
     * 毒鸡汤
     * @return
     */
    @GetMapping("/badsaying")
    public String getSaying(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-wenan-dujitang/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        if (httpResponse.body() == null) {
            return badWordsMapper.getRandomBadWords();
        }
        return httpResponse.body();
    }

    /**
     * 人生倒计时
     * @return
     */
    @GetMapping("/time")
    public String getTimeUsed(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/rsdjs/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        if (httpResponse.body() == null) {
            Calendar calendar = Calendar.getInstance();
            return "今年已过去"+ (calendar.get(Calendar.MONTH) + 1 )+ "个月\n" +
                    "这周已过去"+ (calendar.get(Calendar.DAY_OF_WEEK) - 1) + "个天\n" +
                    "这个月已过去"+ calendar.get(Calendar.DAY_OF_MONTH) + "个天\n" +
                    "今天已过去"+ calendar.get(Calendar.HOUR_OF_DAY) + "个小时\n";
        }
        return httpResponse.body();
    }
}
