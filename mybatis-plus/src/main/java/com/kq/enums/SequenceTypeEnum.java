package com.kq.enums;

/**
 * <p>
 * 序列枚举
 * </p>
 *
 * @author kq
 * @since 2023-07-17
 */
public enum SequenceTypeEnum {

    /**
     * 访问规则
     */
    ACCESS_RULE_SEQ("access_rule", "访问规则"),

    /**
     * 门禁权限
     */
    PERMISSION_SEQ("door:permission:%s", "权限"),

    /**
     * 门禁临时权限
     */
    TEMP_PERMISSION_SEQ("door:temp_permission:%s","临时权限");

    private String key;
    private String message;

    SequenceTypeEnum(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
