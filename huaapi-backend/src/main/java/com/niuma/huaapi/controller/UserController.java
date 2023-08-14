package com.niuma.huaapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.niuma.huaapi.model.dto.user.*;
import com.niuma.huaapi.model.vo.UserDevKeyVO;
import com.niuma.huaapi.service.UserService;
import com.niuma.huaapi.utils.FileUploadUtil;
import com.niuma.huaapicommon.common.BaseResponse;
import com.niuma.huaapicommon.common.DeleteRequest;
import com.niuma.huaapicommon.common.ErrorCode;
import com.niuma.huaapicommon.common.ResultUtils;
import com.niuma.huaapicommon.exception.BusinessException;
import com.niuma.huaapicommon.model.entity.User;
import com.niuma.huaapicommon.model.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户接口
 *
 * @author niuma
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    // region 登录相关

    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long result = userService.userRegister(userRegisterRequest, request);
        return ResultUtils.success(result);
    }

    /**
     * 获取图形验证码
     *
     * @param request
     * @param response
     */
    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        userService.getCaptcha(request, response);
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNum
     * @return
     */
    @GetMapping("/smsCaptcha")
    public BaseResponse<String> smsCaptcha(@RequestParam String phoneNum) {
        return ResultUtils.error(ErrorCode.NOT_FOUND_ERROR, "该功能暂时关闭，敬请期待！");
//        userService.sendSmsCaptcha(phoneNum);
//        return ResultUtils.success("获取短信验证码成功！");
    }

    /**
     * 发送短信验证码(通过QQ邮箱)
     *
     * @param emailNum
     * @return
     */
    @GetMapping("/smsCaptchaByEmail")
    public BaseResponse<String> smsCaptchaByEmail(@RequestParam String emailNum) {
        Boolean isSuccess = userService.sendSmsCaptchaByEmail(emailNum);
        if (!isSuccess) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "获取邮箱验证码失败");
        }
        return ResultUtils.success("获取邮箱验证码成功！");
    }

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.userLogin(userAccount, userPassword, request, response);
        return ResultUtils.success(user);
    }

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/loginBySms")
    public BaseResponse<User> userLoginBySms(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String phoneNum = userLoginRequest.getPhoneNum();
        String phoneCaptcha = userLoginRequest.getPhoneCaptcha();
        if (StringUtils.isAnyBlank(phoneNum, phoneCaptcha)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.userLoginBySms(phoneNum, phoneCaptcha, request, response);
        return ResultUtils.success(user);
    }

    /**
     * 用户登录(通过邮箱)
     *
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/loginByEmail")
    public BaseResponse<User> userLoginByEmail(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String emailNum = userLoginRequest.getEmailNum();
        String phoneCaptcha = userLoginRequest.getPhoneCaptcha();
        if (StringUtils.isAnyBlank(emailNum, phoneCaptcha)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.userLoginByEmail(emailNum, phoneCaptcha, request, response);
        return ResultUtils.success(user);
    }

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public BaseResponse<Boolean> userLogout(HttpServletRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = userService.userLogout(request);
        return ResultUtils.success(result);
    }

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    @GetMapping("/get/login")
    public BaseResponse<UserVO> getLoginUser(HttpServletRequest request) {
        User user = userService.getLoginUser(request);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtils.success(userVO);
    }

    // endregion

    // region 增删改查

    /**
     * 创建用户
     *
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addUser(@RequestBody UserAddRequest userAddRequest, HttpServletRequest request) {
        // todo 单独写一个添加用户的逻辑
        throw new BusinessException(ErrorCode.OPERATION_ERROR, "暂未开放，新建用户请到注册页");
//        if (userAddRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        User user = new User();
//        BeanUtils.copyProperties(userAddRequest, user);
//        boolean result = userService.save(user);
//        if (!result) {
//            throw new BusinessException(ErrorCode.OPERATION_ERROR);
//        }
//        return ResultUtils.success(user.getId());
    }

    /**
     * 删除用户
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = userService.removeById(deleteRequest.getId());
        return ResultUtils.success(b);
    }

    /**
     * 更新用户
     *
     * @param userUpdateRequest
     * @param request
     * @return
     */
    @PostMapping("/update")
    public BaseResponse<Boolean> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
        if (userUpdateRequest == null || userUpdateRequest.getId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateRequest, user);
        boolean result = userService.updateById(user);
        return ResultUtils.success(result);
    }

    /**
     * 更新头像
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/update/avatar")
    public BaseResponse<Boolean> updateUserAvatar(@RequestParam(required = false) MultipartFile file, HttpServletRequest request) {
        if (!FileUploadUtil.validate(file)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        User user = new User();
        user.setId(loginUser.getId());
        String url = FileUploadUtil.uploadFileAvatar(file);
        user.setUserAvatar(url);
        boolean result = userService.updateById(user);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取用户
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<UserVO> getUserById(int id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtils.success(userVO);
    }

    /**
     * 获取用户列表
     *
     * @param userQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<UserVO>> listUser(UserQueryRequest userQueryRequest, HttpServletRequest request) {
        User userQuery = new User();
        if (userQueryRequest != null) {
            BeanUtils.copyProperties(userQueryRequest, userQuery);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(userQuery);
        List<User> userList = userService.list(queryWrapper);
        List<UserVO> userVOList = userList.stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(userVOList);
    }

    /**
     * 分页获取用户列表
     *
     * @param userQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    public BaseResponse<Page<UserVO>> listUserByPage(UserQueryRequest userQueryRequest, HttpServletRequest request) {
        long current = 1;
        long size = 10;
        User userQuery = new User();
        if (userQueryRequest != null) {
            BeanUtils.copyProperties(userQueryRequest, userQuery);
            userQuery.setPhoneNum(null);
            current = userQueryRequest.getCurrent();
            size = userQueryRequest.getPageSize();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(userQuery);

        queryWrapper.like(userQueryRequest != null && StringUtils.isNotBlank(userQueryRequest.getPhoneNum()), "phoneNum", userQueryRequest.getPhoneNum());
        queryWrapper.ge(userQueryRequest != null && StringUtils.isNotBlank(userQueryRequest.getCreateTime()), "createTime", userQueryRequest.getCreateTime());
        queryWrapper.ge(userQueryRequest != null && StringUtils.isNotBlank(userQueryRequest.getUpdateTime()), "phoneNum", userQueryRequest.getUpdateTime());

        Page<User> userPage = userService.page(new Page<>(current, size), queryWrapper);
        Page<UserVO> userVOPage = new PageDTO<>(userPage.getCurrent(), userPage.getSize(), userPage.getTotal());
        List<UserVO> userVOList = userPage.getRecords().stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        }).collect(Collectors.toList());
        userVOPage.setRecords(userVOList);
        return ResultUtils.success(userVOPage);
    }

    // endregion

    @GetMapping("/key")
    public BaseResponse<UserDevKeyVO> getKey(HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        if (loginUser == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", loginUser.getId());
        queryWrapper.eq("userAccount", loginUser.getUserAccount());
        queryWrapper.select("accessKey", "secretKey");
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        UserDevKeyVO userDevKeyVO = new UserDevKeyVO();
        userDevKeyVO.setSecretKey(user.getSecretKey());
        userDevKeyVO.setAccessKey(user.getAccessKey());
        return ResultUtils.success(userDevKeyVO);
    }

    @PostMapping("/gen/key")
    public BaseResponse<UserDevKeyVO> genKey(HttpServletRequest request) {
        UserDevKeyVO userDevKeyVO = userService.genkey(request);
        return ResultUtils.success(userDevKeyVO);
    }
}
