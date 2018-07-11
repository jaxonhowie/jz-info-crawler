package org.jz.service.biz;

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

    private Site site = Site.me().setSleepTime(1500).setRetryTimes(3);

    @Override
    public void process(Page page) {
        if ("".equals(page.getUrl().xpath("").toString())) {
            page.setSkip(true);
        }else {
            page.putField("",page.getUrl().regex(""));
            page.putField("",page.getHtml().xpath("").toString());
        }


    }

    @Override
    public Site getSite() {
        return site;
    }
}
