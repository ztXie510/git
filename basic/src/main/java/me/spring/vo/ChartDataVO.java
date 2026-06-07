package me.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Value object for ECharts chart data — structured for frontend chart rendering.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartDataVO {
    private String chartType;      // pie, line, bar, doughnut
    private String title;
    private List<String> labels;
    private List<Map<String, Object>> datasets;
    private Map<String, BigDecimal> extraData;
}
