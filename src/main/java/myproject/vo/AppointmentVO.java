package myproject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import myproject.common.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 预约
*
*/
@Data
@Schema(description = "预约")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "审核id")
    @ExcelProperty("审核id")
    private Long shenheid;

    @Schema(description = "车辆名称")
    @ExcelProperty("车辆名称")
    private String name;

    @Schema(description = "用户id")
    @ExcelProperty("用户id")
    private Long userid;

    @Schema(description = "用户名称")
    @ExcelProperty("用户名称")
    private String username;

    @Schema(description = "审核")
    @ExcelProperty("审核")
    private String shenhe;

    @Schema(description = "封面")
    @ExcelProperty("封面")
    private String photo;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}