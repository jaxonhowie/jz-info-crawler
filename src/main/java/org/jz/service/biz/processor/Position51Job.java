package org.jz.service.biz.processor;

import org.jz.model.JobDescription;
import org.jz.service.JobDescriptionService;
import org.jz.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.UUID;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
@Component("position51Job")
public class Position51Job implements PageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(Position51Job.class);

    @Autowired
    JobDescriptionService jobDescriptionService;

    /**目标页url*/
    private static final String TARGET_URL = "https://jobs.51job.com/shanghai\\w+\\d+\\.html?s=01&t=\\d";

    private Site site = Site.me()
            .setSleepTime(1500+(int)(Math.random()*5000))
            .setRetryTimes(3);

    @Override
    public void process(Page page) {


        if (page.getUrl().regex(TARGET_URL).match()) {
            //targetUrl
            logger.info("目标页==>",page.getUrl().toString());
            JobDescription instance = JobDescription.newInstance();
            instance.setCity("上海");
            instance.setSearchKey("java");
            instance.setTraceId(RandomUtils.genUUID());
            instance.setTitle("");
            instance.setCorpName(page.getHtml().xpath("//*[@class='cname']/a[@title]").toString().trim());
            page.putField("",page.getUrl().regex(""));
            page.putField("",page.getHtml().xpath("").toString());


            jobDescriptionService.insert(instance);

        }else {
            //help links
            logger.info("列表页==>",page.getUrl().toString());
            //add help links to target list
            page.addTargetRequests(page.getHtml().xpath("//*[@class='p_in']/ul/li/a[@href]").links().all());
            page.setSkip(true);
        }


    }

    @Override
    public Site getSite() {
        return site;
    }

    public void startSpider(String startPage){
        Spider position51 = Spider.create(new Position51Job())
                //start page
                .addUrl(startPage)
                .thread(5);
        position51.start();
    }
}
