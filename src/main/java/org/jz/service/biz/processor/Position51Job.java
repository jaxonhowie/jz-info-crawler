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
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
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
            //城市
            instance.setCity("上海");
            //搜索关键字
            instance.setSearchKey("java");
            instance.setTraceId(RandomUtils.genUUID());

            instance.setTitle(page.getHtml().xpath("//div[@class='cn']/h1[@title]").toString().trim());
            instance.setCorpName(page.getHtml().xpath("//p[@class='cname']/a[@title]").toString().trim());
            instance.setPosition(page.getHtml().xpath("//p[@class='fp']/span[@class='el']/text()").toString().trim());
            instance.setLocation(page.getHtml().xpath("//span[@class='lname']/text()").toString().trim());

            String corpInfo = page.getHtml().xpath("//p[@class='msg ltype']/text()").toString().trim();
            instance.setCorpType(corpInfo.split("\\|")[0].replaceAll("&nbsp;",""));
            instance.setCorpIndustry(corpInfo.split("\\|")[2].replaceAll("&nbsp;",""));
            /**企业规模*/
            instance.setCorpSize(corpInfo.split("\\|")[1].replaceAll("&nbsp;",""));

            /**职位描述*/
            List<String> jds = page.getHtml().xpath("//div[@class='bmsg job_msg inbox']/p/text()").all();
            StringBuilder sb = new StringBuilder();
            jds.forEach(sb::append);
            instance.setJd(sb.toString());
            /**薪资*/
            instance.setSalary(page.getHtml().xpath("//div[@class='cn']/strong/text()").toString().trim());
            /**职位要求*/
            StringBuilder sb1 =new StringBuilder();
            page.getHtml().xpath("//div[@class='t1']/span/text()").all().forEach(e->sb1.append(e).append("/"));
            instance.setRequirement(sb1.toString());
            /**福利待遇*/
            StringBuilder sb2 = new StringBuilder();
            page.getHtml().xpath("//p[@class='t2']/span/text()").all().forEach(e->sb2.append(e).append("/"));
            instance.setWelfare(sb2.toString());
            /**标签 关键词*/
            StringBuilder sb3 = new StringBuilder();
            page.getHtml().xpath("//p[@class='fp']/span[@class='el']/text()").all().forEach(e->sb3.append(e).append("/"));
            instance.setKeywords(sb3.toString());
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
                .addPipeline(new FilePipeline("D:\\web-magic"))
                .thread(5);
        position51.start();
    }
}
