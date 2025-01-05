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
* 线路规划
*
*/
@Data
@Schema(description = "线路规划")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteplanningVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "线路名")
    @ExcelProperty("线路名")
    private String name;

    @Schema(description = "线路编号")
    @ExcelProperty("线路编号")
    private String routenumbers;

    @Schema(description = "起始站")
    @ExcelProperty("起始站")
    private String initiatingstation;

    @Schema(description = "终点站")
    @ExcelProperty("终点站")
    private String terminal;

    @Schema(description = "总长度")
    @ExcelProperty("总长度")
    private String totallength;

    @Schema(description = "简介")
    @ExcelProperty("简介")
    private String detail;

    @Schema(description = "详情")
    @ExcelProperty("详情")
    private String details;

    @Schema(description = "封面")
    @ExcelProperty("封面")
    private String photo;

    @Schema(description = "详情图")
    @ExcelProperty("详情图")
    private String photos;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}