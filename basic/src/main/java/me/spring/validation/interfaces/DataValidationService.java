package me.spring.validation;

import java.util.List;
import java.util.Map;

/**
 * 数据验证服务接口
 */
public interface DataValidationService {

    /**
     * 验证数据
     */
    ValidationResult validate(Object data, ValidationRule rule);

    /**
     * 批量验证数据
     */
    List<ValidationResult> batchValidate(List<Object> dataList, ValidationRule rule);

    /**
     * 创建验证规则
     */
    String createRule(ValidationRule rule);

    /**
     * 更新验证规则
     */
    boolean updateRule(String ruleId, ValidationRule rule);

    /**
     * 删除验证规则
     */
    boolean deleteRule(String ruleId);

    /**
     * 获取验证规则
     */
    ValidationRule getRule(String ruleId);

    /**
     * 获取所有规则
     */
    List<ValidationRule> getAllRules();

    /**
     * 动态创建验证器
     */
    Validator createDynamicValidator(String ruleName, Map<String, Object> params);

    /**
     * 验证Excel数据
     */
    ExcelValidationResult validateExcel(byte[] excelData, ExcelValidationConfig config);
}

/**
 * 业务规则验证接口
 */
public interface BusinessRuleService {

    /**
     * 验证业务规则
     */
    BusinessRuleResult validateBusinessRule(Object data, String ruleName, Map<String, Object> context);

    /**
     * 创建业务规则
     */
    String createBusinessRule(BusinessRule rule);

    /**
     * 更新业务规则
     */
    boolean updateBusinessRule(String ruleId, BusinessRule rule);

    /**
     * 删除业务规则
     */
    boolean deleteBusinessRule(String ruleId);

    /**
     * 获取业务规则
     */
    BusinessRule getBusinessRule(String ruleId);

    /**
     * 获取所有业务规则
     */
    List<BusinessRule> getAllBusinessRules();

    /**
     * 规则冲突检测
     */
    List<RuleConflict> detectRuleConflicts(List<String> ruleIds);

    /**
     * 规则优先级排序
     */
    List<String> sortRulesByPriority(List<String> ruleIds);
}

/**
 * 数据完整性检查接口
 */
public interface DataIntegrityService {

    /**
     * 检查数据完整性
     */
    IntegrityCheckResult checkDataIntegrity(String dataType, Map<String, Object> data);

    /**
     * 执行完整性检查
     */
    void performIntegrityCheck(String dataType, Map<String, Object> context);

    /**
     * 获取完整性检查历史
     */
    List<IntegrityCheckResult> getIntegrityCheckHistory(LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 设置完整性检查规则
     */
    void setIntegrityRule(String dataType, IntegrityRule rule);

    /**
     * 获取完整性规则
     */
    IntegrityRule getIntegrityRule(String dataType);
}