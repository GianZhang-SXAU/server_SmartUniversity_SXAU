package myproject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import myproject.common.utils.DateUtils;
    import java.util.Date;

/**
* 投诉反馈
*
*/
@Data
@Schema(description = "投诉反馈")
public class TousufankuiVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "投诉原因")
    @ExcelProperty("投诉原因")
    private String name;

    @Schema(description = "投诉照片")
    @ExcelProperty("投诉照片")
    private String photo;

    @Schema(description = "投诉简介")
    @ExcelProperty("投诉简介")
    private String detail;

    @Schema(description = "投诉详情")
    @ExcelProperty("投诉详情")
    private String details;

    @Schema(description = "投诉人id")
    @ExcelProperty("投诉人id")
    private Long userid;

    @Schema(description = "投诉人名字")
    @ExcelProperty("投诉人名字")
    private String username;

    @Schema(description = "投诉状态")
    @ExcelProperty("投诉状态")
    private String status;

    @Schema(description = "反馈结果")
    @ExcelProperty("反馈结果")
    private String fankuijieguo;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}