package org.jz.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jz.commons.Result;
import org.jz.commons.RspCode;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
@RestController
@RequestMapping("/positions")
public class RecruitInfoCrawler extends BaseController {

    private AsyncTaskExecutor asyncTaskExecutor;

    @PostMapping("/get")
    public Result startSpider(String website) {
        if (StringUtils.isBlank(website)) {
            return result(RspCode.PARAMS_ERROR);
        }

        switch (website) {
            case "51job" :
                asyncTaskExecutor.execute(() -> {

                });
                break;
            case "zhilian":
                asyncTaskExecutor.execute(()->{

                });
                break;
            default:
                break;
        }

        return result(RspCode.SUCCESS,"开始爬取");
    }
}
