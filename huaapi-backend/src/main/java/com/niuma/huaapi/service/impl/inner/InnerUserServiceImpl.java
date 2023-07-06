package com.niuma.huaapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niuma.huaapi.mapper.UserMapper;
import com.niuma.huaapi.service.UserService;
import com.niuma.huaapicommon.common.ErrorCode;
import com.niuma.huaapicommon.exception.BusinessException;
import com.niuma.huaapicommon.model.entity.User;
import com.niuma.huaapicommon.model.vo.UserVO;
import com.niuma.huaapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;


/**
 * @author niuma
 * @create 2023-02-27 16:13
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    @Override
    public User getInvokeUser(String ak) {
        if (StringUtils.isAnyBlank(ak)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", ak);
        User user = userMapper.selectOne(queryWrapper);

        return user;
    }

    @Override
    public UserVO getLoginUser(String cookie) {
        return userService.getLoginUser(cookie);
    }
}
