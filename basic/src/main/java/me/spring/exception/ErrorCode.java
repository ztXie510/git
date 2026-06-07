package me.spring.exception;

/**
 * Unified error code enumeration for API responses.
 */
public enum ErrorCode {

    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未认证，请先登录"),
    FORBIDDEN(403, "权限不足"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),
    INTERNAL_ERROR(500, "服务器内部错误"),

    // User module: 1xxx
    USERNAME_EXISTS(1001, "用户名已存在"),
    EMAIL_EXISTS(1002, "邮箱已被注册"),
    INVALID_PASSWORD(1003, "密码错误"),
    ACCOUNT_DISABLED(1004, "账户已被禁用"),
    TOKEN_EXPIRED(1005, "Token已过期"),
    TOKEN_INVALID(1006, "无效Token"),

    // Budget module: 2xxx
    BUDGET_EXCEEDED(2001, "预算已超支"),
    BUDGET_ALERT(2002, "预算已达到预警线"),

    // Bill module: 3xxx
    BILL_OVERDUE(3001, "账单已逾期"),
    BILL_NOT_FOUND(3002, "账单不存在"),

    // Ledger module: 4xxx
    LEDGER_NOT_FOUND(4001, "家庭账本不存在"),
    NOT_LEDGER_MEMBER(4002, "不是该账本成员"),
    INSUFFICIENT_PERMISSION(4003, "账本操作权限不足");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
}
