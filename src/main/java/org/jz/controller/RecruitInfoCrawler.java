package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jz.commons.Constants;
import org.jz.commons.Result;
import org.jz.commons.RspCode;
import org.jz.service.biz.processor.Position51Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
@RestController
@RequestMapping("/jd")
public class RecruitInfoCrawler extends BaseController {

    private AsyncTaskExecutor asyncTaskExecutor;

    @Autowired
    Position51Job position51Job;

    @PostMapping("/get")
    public Result startSpider(String website, String startPage) {
        if (StringUtils.isBlank(website)) {
            return result(RspCode.PARAMS_ERROR);
        }

        switch (website.toUpperCase()) {
            case Constants.SITE_NAME_51 :
                asyncTaskExecutor.execute(() -> {
                    position51Job.startSpider(startPage);
                });
                break;
            case Constants.SITE_NAME_ZL:
                asyncTaskExecutor.execute(()->{

                });
                break;
            default:
                break;
        }
        return result(RspCode.SUCCESS,"开始爬取");
    }
}
