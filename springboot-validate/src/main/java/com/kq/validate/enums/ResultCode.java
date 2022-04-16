package com.kq.validate.enums;

/**
 * @Description 返回的code值
 * 10000～19999 区间表示系统级代码错误
 * 20000～29999 区间表示服务级代码错误
 * 30000～39999 区间表示硬件相关的代码错误
 * 40000～49999 区间表示数据相关的代码错误
 * 50000～59999 区间表示其它内部系统错误
 **/
public enum ResultCode {

    /**
     * -1为特别错误码，需要系统指定错误信息，不建议使用失败两个字
     */
    FAIL(-1, "请求失败", "Failed"),
    SUCCESS(200, "请求成功", "Success"),
    WARN(201,"警告信息", "Warn"),

    SYSTEM_ERROR(10001, "系统错误", "System Error"),
    SERVICE_UNAVAILABLE(10002, "服务不可用", "Service unavailable"),
    SYSTEM_BUSY(10003, "系统繁忙,请稍候再试", "system busy"),
    SERVER_OFFLINE(10004, "无法连接到服务器", "Cannot connect to server"),

    USER_NOT_EXIST(20001, "用户不存在", "User does not exists"),
    NO_AUTHORITY(20002, "无权限", "no authority"),
    PARAM_ERROR(20003, "参数错误", "parameters error"),
    UPLOAD_FILE_SIZE_LIMIT(20004, "上传文件大小超过限制", "upload file size exceed"),
    ARGUMENT_NOT_VALID(20005, "请求参数校验不通过", "argument not valid"),
    GATEWAY_NOT_FOUND_SERVICE(20006, "服务未找到", "gateway service not found "),
    GATEWAY_ERROR(20007, "网关异常", "gateway error"),
    GATEWAY_CONNECT_TIME_OUT(20008, "网关超时", ""),
    INVALID_REQUEST(20009, "无效请求", "invalid request"),
    INVALID_CLIENT(20010, "无效client_id", "invalid client"),
    INVALID_GRANT(20011, "用户名或密码错误", "incorrect username or password"),
    INVALID_SCOPE(20012, "无效scope", "invalid scope"),
    INVALID_TOKEN(20013, "无效token", "invalid token"),
    INSUFFICIENT_SCOPE(20014, "授权不足", "insufficient scope"),
    REDIRECT_URI_MISMATCH(20015, "redirect url不匹配", "redirect uri mismatch"),
    ACCESS_DENIED(20016, "拒绝访问", "access denied"),
    METHOD_NOT_ALLOWED(20017, "不支持该方法", "method not allowed"),
    SERVER_ERROR(20018, "权限服务错误", "server error"),
    UNAUTHORIZED_CLIENT(20019, "未授权客户端", "unauthorized client"),
    UNAUTHORIZED(20020, "未授权", "unauthorized"),
    UNSUPPORTED_RESPONSE_TYPE(20021, "不支持的响应类型", "unsupported response type"),
    UNSUPPORTED_GRANT_TYPE(20022, "不支持的授权类型", "unsupported grant type"),
    SIGN_ERROR(20023, "签名错误", "sign error"),
    ILLEGAL_REQUEST(20024, "非法请求", "illegal request"),
    VERIFICATION_CODE_ERROR(20025, "验证码错误", "verification code error"),
    LOGOUT_FAIL(20026, "登出失败", "logout fail"),
    ROLE_EXIST(20027, "角色已存在", "role exist error"),
    EXIST_RELATION(20028, "存在关联", "exist relation"),
    NO_MODIFIED(20029, "无法修改", "no modified"),
    INVALID_VERIFICATION_CODE(20030,"无效的验证码","Verification code is invalid"),
    COMPANY_NOT_EXIST(20031,"单位不存在","company not exist"),
    DEPARTMENT_NOT_EXIST(20032,"组织机构不存在","department not exist"),
    ROLE_NOT_EXIST(20033,"角色不存在","role not exist"),
    PRODUCT_NOT_EXIST(20034,"产品不存在","product not exist"),
    AUTHORITY_NOT_EXIST(20035,"权限不存在","authority not exist"),
    PASSWORD_WRONG(20036,"当前密码错误","password wrong"),
    NULL_AUTHORIZATION(20037,"Authorization为空","authorization is null"),
    LOGIN_ERROR_TIMES(20038,"登录错误次数超过5次，请15分钟之后重试","login error is more than 5 times, please try again after 15 minutes"),
    COMPANY_EXIST(20039, "单位已存在", "company exist"),
    DEPARTMENT_EXIST(20040, "组织机构已存在", "department exist"),
    PRODUCT_EXIST(20041, "产品已存在", "product exist"),
    USER_EXIST(20042, "用户已存在", "user exist"),
    AUTHORITY_EXIST(20043, "权限已存在", "authority exist"),
    LOGIN_ID_EXIST(20044, "用户账号已存在", "loginId exist"),
    PHONE_EXIST(20045, "手机号已存在", "phone exist"),
    EMAIL_EXIST(20046, "邮箱已存在", "email exist"),
    ID_NUMBER_EXIST(20047, "证件号已存在", "id number exist"),
    USER_NOT_UNIT(20048, "用户不属于该单位", "user does not belong to this unit"),
    MISSING_REQUEST_PARAMETER(20049, "缺少请求参数", "missing request parameter"),
    DISABLE_COMPANY(20050, "用户所属的使用单位是无效的", "disabled company"),
    DISABLE_DEPARTMENT(20051, "用户所属的组织机构是无效的", "disabled department"),
    DISABLE_USER(20052, "无效的用户", "disabled user"),
    USER_KICKED_OUT(20053,"用户已在其他地方登录，请重新登录，如非本人操作，请重置密码","The user has been kicked out. Please log in again. If not operated by yourself, please reset the password"),
    LOGIN_TIMEOUT(20054,"登录超时","login timeout"),
    CLIENT_NOT_EXIST(20055,"客户凭证信息不存在","client not exist"),
    POLICY_NOT_EXIST(20056,"策略信息不存在","policy not exist"),
    NO_RESOURCE(20057, "无可用资源", "no resource"),
    USER_NUM_EXIST(20058, "学/工号已存在", "user number exist"),
    USER_EXIST_IN_GROUP(20059, "用户已存在该用户组", "the user group already exists for the user"),
    USER_PROP_NOT_EXIST(20059, "属性组不存在", "user prop not exist"),
    APPLICATIONCODE_NOT_ALLOW_NULL(20060, "应用标识不能为空", "applicationcode not allow null"),
    APPLICATIONCODE_NOT_AVAILABLE(20061, "应用服务不可用，请稍后再试", "applicationcode not available"),
    VERIFICATION_CODE_OVERDUE(20062, "验证码已过期，请重新输入", "verification code overdue"),
    DEFAULT_USER_DELETE(20063,"默认用户无法删除","default user not allow delete"),
    DEFAULT_USER_UPDATE(20064,"默认用户只能修改密码","default user not allow update，but can update password"),
    DEFAULT_ROLE_DELETE(20065,"默认角色无法删除","default role not allow delete"),
    DEFAULT_ROLE_UPDATE(20066,"默认角色无法修改","default role not allow update"),
    LOGIN_ERROR(20067,"用户未登录","login error"),
    OAUTH2_TOKEN_EXPIRED(20068,"Token已过期","token expired"),
    OAUTH2_TOKEN_INVALID(20069,"无效Token","token invalid"),
    ACCOUNT_NUMBER_EXIST(20070,"账号已存在","account number exist"),
    USER_NUMBER_EXIST(20071,"人员编号已存在","user number exist"),
    USER_NOT_ACTIVE(20072,"用户账户未激活","user not active"),
    SECONDARY_CERTFICATION(20073, "因安全需要,访问需要二次认证", "SECONDARY_CERTFICATION"),

    ORACLE_CONNECTION_ERROR(40001, "无法连接到Oracle数据库", "Cannot connect to Oracle DB"),
    MYSQL_CONNECTION_ERROR(40002, "无法连接到Mysql数据库", "Cannot connect to Mysql DB"),
    DUPLICATE_PRIMARY_KEY(40003, "唯一键冲突", "duplicate primary key"),
    ;


    private Integer code;
    private String msg;
    private String enName;

    private ResultCode(Integer code, String msg, String enName) {
        this.code = code;
        this.msg = msg;
        this.enName = enName;
    }

    public Integer getCode() {
        return code;
    }

    public String getEnName() {
        return enName;
    }

    public String getMsg() {
        return msg;
    }

}
