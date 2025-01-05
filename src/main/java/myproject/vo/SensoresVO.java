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
* 传感器
*
*/
@Data
@Schema(description = "传感器")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensoresVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "传感器名称")
    @ExcelProperty("传感器名称")
    private String name;

    @Schema(description = "传感器类型")
    @ExcelProperty("传感器类型")
    private String type;

    @Schema(description = "传感器品牌")
    @ExcelProperty("传感器品牌")
    private String sensorbrand;

    @Schema(description = "安装位置")
    @ExcelProperty("安装位置")
    private String installationposition;

    @Schema(description = "安装时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("安装时间")
    private Date installationtime;

    @Schema(description = "传感器状态")
    @ExcelProperty("传感器状态")
    private String sensorstate;

    @Schema(description = "车辆id")
    @ExcelProperty("车辆id")
    private Long vehicleid;

    @Schema(description = "车辆名称")
    @ExcelProperty("车辆名称")
    private String vehiclename;

    @Schema(description = "传感器图片")
    @ExcelProperty("传感器图片")
    private String photo;

    @Schema(description = "传感器详情")
    @ExcelProperty("传感器详情")
    private String details;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}