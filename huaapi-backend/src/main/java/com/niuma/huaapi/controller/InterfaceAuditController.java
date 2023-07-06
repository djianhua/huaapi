package com.niuma.huaapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huaapi.annotation.AuthCheck;
import com.niuma.huaapi.model.dto.interfaceAudit.InterfaceAuditQueryRequest;
import com.niuma.huaapi.model.dto.interfaceAudit.InterfaceAuditRequest;
import com.niuma.huaapi.model.dto.interfaceinfo.InterfaceInfoAddRequest;
import com.niuma.huaapi.model.vo.InterfaceAuditVO;
import com.niuma.huaapi.service.InterfaceAuditService;
import com.niuma.huaapi.service.UserService;
import com.niuma.huaapicommon.common.BaseResponse;
import com.niuma.huaapicommon.common.ErrorCode;
import com.niuma.huaapicommon.common.ResultUtils;
import com.niuma.huaapicommon.exception.BusinessException;
import com.niuma.huaapicommon.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 接口管理
 *
 * @author niuma
 */
@RestController
@RequestMapping("/interfaceAudit")
@Slf4j
public class InterfaceAuditController {

    @Resource
    private InterfaceAuditService interfaceAuditService;

    @Resource
    private UserService userService;

    /**
     * 获取审核接口列表
     * @param request
     * @return
     */
    @PostMapping("/getInterfaceAuditList")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<Page<InterfaceAuditVO>> getInterfaceAuditList(InterfaceAuditQueryRequest interfaceAuditQueryRequest, HttpServletRequest request) {
        if (interfaceAuditQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        return ResultUtils.success(interfaceAuditService.getInterfaceAuditListPage(interfaceAuditQueryRequest));
    }

    /**
     * 审核接口成功
     * @param interfaceAuditRequest
     * @param request
     * @return
     */
    @PostMapping("/auditInterface")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<Boolean> auditInterface(@RequestBody InterfaceAuditRequest interfaceAuditRequest, HttpServletRequest request) {
        if (interfaceAuditRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取当前登录用户
        User user = userService.getLoginUser(request);
        return ResultUtils.success(interfaceAuditService.auditInterface(interfaceAuditRequest,user));
    }
    /**
     * 用户添加接口
     * @param interfaceInfoAddRequest
     * @param request
     * @return
     */
    @PostMapping("/userAdd")
    public BaseResponse<Boolean> userAdd(@RequestBody InterfaceInfoAddRequest interfaceInfoAddRequest, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        boolean b = interfaceAuditService.userAddInterface(interfaceInfoAddRequest, loginUser);
        return ResultUtils.success(b);
    }

}
