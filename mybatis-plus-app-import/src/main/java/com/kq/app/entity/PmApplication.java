package com.kq.app.entity;

import java.util.List;

/**
 * @author kq
 * @date 2022-03-09 15:24
 * @since 2020-0630
 */
public class PmApplication {

    private String id;
    private String name;
    private String logo;
    private String appCode;
    private String shortName;

    private String deployType;
    private String appType;
    private String categoryId;
    private String appDevName;

    // 这个字段待定
    private String seqNumber;
    // 启用状态
    private String isUsing;

    private String url;
    private String appId;
    private String appSecret;
    private String appVersion;

    private List<PmApplicationFunction> functionList;


    public List<PmApplicationFunction> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<PmApplicationFunction> functionList) {
        this.functionList = functionList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDeployType() {
        return deployType;
    }

    public void setDeployType(String deployType) {
        this.deployType = deployType;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAppDevName() {
        return appDevName;
    }

    public void setAppDevName(String appDevName) {
        this.appDevName = appDevName;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    public String getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(String isUsing) {
        this.isUsing = isUsing;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "PmApplication{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", appCode='" + appCode + '\'' +
                ", shortName='" + shortName + '\'' +
                ", deployType='" + deployType + '\'' +
                ", appType='" + appType + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", appDevName='" + appDevName + '\'' +
                ", seqNumber='" + seqNumber + '\'' +
                ", isUsing='" + isUsing + '\'' +
                ", url='" + url + '\'' +
                ", appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", functionList=" + functionList +
                '}';
    }
}
