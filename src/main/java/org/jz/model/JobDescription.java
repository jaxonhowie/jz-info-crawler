package org.jz.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
@Table(name = "jobdescription")
public class JobDescription implements Serializable {

    private static final long serialVersionUID = 7435377241360265023L;

    @Id
    private Long oid;
    private String traceId;

    private String city;
    /**搜索关键字*/
    private String searchKey;
    /**标题*/
    private String title;
    /**职位*/
    private String position;
    /**公司位置*/
    private String location;
    /**企业名*/
    private String corpName;
    /**企业类型*/
    private String corpType;
    /**所属行业*/
    private String corpIndustry;
    /**企业规模*/
    private String corpSize;
    /**职位描述*/
    private String jd;
    /**薪资*/
    private String salary;
    /**职位要求*/
    private String requirement;
    /**福利待遇*/
    private String welfare;
    /**标签 关键词*/
    private String keywords;

    private Date oitime;
    private Date outime;
    private String isDel;

    public static JobDescription newInstance(){
        return new JobDescription();
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOitime() {
        return oitime;
    }

    public void setOitime(Date oitime) {
        this.oitime = oitime;
    }

    public Date getOutime() {
        return outime;
    }

    public void setOutime(Date outime) {
        this.outime = outime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getCorpIndustry() {
        return corpIndustry;
    }

    public void setCorpIndustry(String corpIndustry) {
        this.corpIndustry = corpIndustry;
    }

    public String getCorpSize() {
        return corpSize;
    }

    public void setCorpSize(String corpSize) {
        this.corpSize = corpSize;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
