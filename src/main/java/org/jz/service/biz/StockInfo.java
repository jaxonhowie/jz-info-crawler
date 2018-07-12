package org.jz.service.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
@Component("stockInfo")
public class StockInfo implements PageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(StockInfo.class);

    //目标页url
    private static final String TARGET_URL = "";

    private Site site = Site.me()
            .setSleepTime(1500+(int)(Math.random()*5000))
            .setRetryTimes(3);

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(TARGET_URL).match()) {
            //targetUrl
            logger.info("目标页==>",page.getUrl().toString());
            page.putField("",page.getUrl().regex(""));
            page.putField("",page.getHtml().xpath("").toString());

        }else {
            //help links
            logger.info("列表页==>",page.getUrl().toString());
            //add help links to target list
            page.addTargetRequests(page.getHtml().xpath("").links().regex("").all());
            page.setSkip(true);
        }


    }

    @Override
    public Site getSite() {
        return site;
    }
}
