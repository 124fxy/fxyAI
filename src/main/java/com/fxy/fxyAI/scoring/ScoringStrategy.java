package com    .fxy.fxyAI.scoring;

import com    .fxy.fxyAI.model.entity.App;
import com    .fxy.fxyAI.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
  
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}