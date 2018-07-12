package org.jz.commons;

/**
 * @author Hongyi Zheng
 * @date 2018/7/12
 */
public enum RspCode {


    /******************** 成功情况 2xx ********************/
    /**
     * 成功
     */
    SUCCESS("200", "成功"),


    /******************** 客户端错误 4xx ********************/
    /**
     * 未登录：未检测到session、cookie、登录状态等情况
     */
    NOT_LOGIN("400", "未登录"),

    /**
     * 参数错误：必输字段未传、传入字段为null或空串、传入字段类型错误等情况
     */
    PARAMS_ERROR("403", "参数错误"),

    /**
     * 登录验证错误：用户名错误、密码错误等情况
     */
    LOGIN_FAIL("405", "用户名或密码错误"),

    /**
     * 图片验证码错误：错误、失效等情况
     */
    IMG_CODE_ERR("406", "图片验证码错误"),

    /**
     * 短信验证码错误：错误、失效等情况
     */
    SMS_CODE_ERR("407", "短信验证码错误"),


    /******************** 服务端错误 5xx ********************/
    /**
     * 系统异常：所有后台业务系统抛出的非以上类型错误
     */
    EXCEPTION("501", "系统异常"),


    /******************** 业务类错误 6xx ********************/
    /**
     * 账户状态异常：用户账户锁定、失效、删除等情况
     */
    ACC_STS_ABNORMAL("601", "用户状态异常"),

    /**
     * 无访问权限：用户账户无权访问某模块、菜单、页面、功能等情况
     */
    NO_PERMISSION("604", "无访问权限");

    private String code;
    private String message;

    private RspCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }

}
