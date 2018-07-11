package org.jz.service.biz;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Hongyi Zheng
 * @date 2018/7/11
 */
public class StockInfo implements PageProcessor {

    private Site site = Site.me();

    @Override
    public void process(Page page) {
        if ("".equals(page.getUrl().xpath("").toString())) {
            page.setSkip(true);
        }
        page.putField("",page.getUrl().regex(""));
        page.putField("",page.getHtml().xpath("").toString());


    }

    @Override
    public Site getSite() {
        return site;
    }
}
