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
* 检测项目
*
*/
@Data
@Schema(description = "检测项目")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestprojectVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "项目名称")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "封面")
    @ExcelProperty("封面")
    private String photo;

    @Schema(description = "效果图")
    @ExcelProperty("效果图")
    private String photos;

    @Schema(description = "项目分类")
    @ExcelProperty("项目分类")
    private String classify;

    @Schema(description = "项目简介")
    @ExcelProperty("项目简介")
    private String detail;

    @Schema(description = "项目详情")
    @ExcelProperty("项目详情")
    private String details;

    @Schema(description = "创建人id")
    @ExcelProperty("创建人id")
    private Long adduserid;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String addusername;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}