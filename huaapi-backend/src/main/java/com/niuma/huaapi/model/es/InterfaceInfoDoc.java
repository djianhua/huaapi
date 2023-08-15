package com.niuma.huaapi.model.es;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.niuma.huaapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author hua
 * @Create 2023/7/31 15:03
 */
@Data
@NoArgsConstructor
public class InterfaceInfoDoc {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * SDK中的方法名
     */
    private String methodName;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 接口状态（0-关闭，1-开启）
     */
    private Integer status;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public InterfaceInfoDoc(InterfaceInfo interfaceInfo) {
        this.id = interfaceInfo.getId();
        this.name = interfaceInfo.getName();
        this.methodName = interfaceInfo.getMethodName();
        this.url = interfaceInfo.getUrl();
        this.description = interfaceInfo.getDescription();
        this.status = interfaceInfo.getStatus();
        this.method = interfaceInfo.getMethod();
        this.responseHeader = interfaceInfo.getResponseHeader();
        this.createTime = interfaceInfo.getCreateTime();
        this.updateTime = interfaceInfo.getUpdateTime();
        this.requestParams = interfaceInfo.getRequestParams();
        this.requestHeader = interfaceInfo.getRequestHeader();
        this.userId = interfaceInfo.getUserId();
    }
    public InterfaceInfo reverse(InterfaceInfoDoc interfaceInfoDoc) {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(interfaceInfoDoc.getId());
        interfaceInfo.setName(interfaceInfoDoc.getName());
        interfaceInfo.setMethodName(interfaceInfoDoc.getMethodName());
        interfaceInfo.setUrl(interfaceInfoDoc.getUrl());
        interfaceInfo.setDescription(interfaceInfoDoc.getDescription());
        interfaceInfo.setStatus(interfaceInfoDoc.getStatus());
        interfaceInfo.setMethod(interfaceInfoDoc.getMethod());
        interfaceInfo.setResponseHeader(interfaceInfoDoc.getResponseHeader());
        interfaceInfo.setCreateTime(interfaceInfoDoc.getCreateTime());
        interfaceInfo.setUpdateTime(interfaceInfoDoc.getUpdateTime());
        interfaceInfo.setRequestParams(interfaceInfoDoc.getRequestParams());
        interfaceInfo.setRequestHeader(interfaceInfoDoc.getRequestHeader());
        interfaceInfo.setUserId(interfaceInfoDoc.getUserId());
        return interfaceInfo;
    }
}
