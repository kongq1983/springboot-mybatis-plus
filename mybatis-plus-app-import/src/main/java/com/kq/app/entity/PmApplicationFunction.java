package com.kq.app.entity;

/**
 * @author kq
 * @date 2022-03-09 15:33
 * @since 2020-0630
 */
public class PmApplicationFunction {

    private String id;
    private String name;
    private String applicationId;
    private String funcCode;
    private String funcUrl;

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

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    @Override
    public String toString() {
        return "PmApplicationFunction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", funcCode='" + funcCode + '\'' +
                ", funcUrl='" + funcUrl + '\'' +
                '}';
    }
}
