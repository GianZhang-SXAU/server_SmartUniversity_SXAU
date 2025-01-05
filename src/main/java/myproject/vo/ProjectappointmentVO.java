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
* 项目预约
*
*/
@Data
@Schema(description = "项目预约")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectappointmentVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "项目名称")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "项目id")
    @ExcelProperty("项目id")
    private Long shenheid;

    @Schema(description = "预约人id")
    @ExcelProperty("预约人id")
    private Long userid;

    @Schema(description = "预约人")
    @ExcelProperty("预约人")
    private String username;

    @Schema(description = "创建人id")
    @ExcelProperty("创建人id")
    private Long adduserid;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String addusername;

    @Schema(description = "封面")
    @ExcelProperty("封面")
    private String photo;

    @Schema(description = "审核")
    @ExcelProperty("审核")
    private String shenhe;

    @Schema(description = "检测报告")
    @ExcelProperty("检测报告")
    private String files;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}