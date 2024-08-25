package com    .fxy.fxyAI.controller;

import cn.hutool.core.io.FileUtil;

import com    .fxy.fxyAI.common.BaseResponse;
import com    .fxy.fxyAI.common.ErrorCode;
import com    .fxy.fxyAI.common.ResultUtils;
import com    .fxy.fxyAI.constant.FileConstant;
import com    .fxy.fxyAI.exception.BusinessException;
import com    .fxy.fxyAI.exception.ThrowUtils;
import com    .fxy.fxyAI.manager.CosManager;
import com.fxy.fxyAI.mapper.UserAnswerMapper;
import com    .fxy.fxyAI.model.dto.file.UploadFileRequest;
import com    .fxy.fxyAI.model.dto.statistic.AppAnswerCountDTO;
import com    .fxy.fxyAI.model.dto.statistic.AppAnswerResultCountDTO;
import com    .fxy.fxyAI.model.entity.User;
import com    .fxy.fxyAI.model.enums.FileUploadBizEnum;
import com    .fxy.fxyAI.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * App 统计分析接口
 *
  
  
 */
@RestController
@RequestMapping("/app/statistic")
@Slf4j
public class AppStatisticController {

    @Resource
    private UserAnswerMapper userAnswerMapper;

    /**
     * 热门应用及回答数统计（top 10）
     *
     * @return
     */
    @GetMapping("/answer_count")
    public BaseResponse<List<AppAnswerCountDTO>> getAppAnswerCount() {
        return ResultUtils.success(userAnswerMapper.doAppAnswerCount());
    }

    /**
     * 某应用回答结果分布统计
     *
     * @param appId
     * @return
     */
    @GetMapping("/answer_result_count")
    public BaseResponse<List<AppAnswerResultCountDTO>> getAppAnswerResultCount(Long appId) {
        ThrowUtils.throwIf(appId == null || appId <= 0, ErrorCode.PARAMS_ERROR);
        return ResultUtils.success(userAnswerMapper.doAppAnswerResultCount(appId));
    }
}
