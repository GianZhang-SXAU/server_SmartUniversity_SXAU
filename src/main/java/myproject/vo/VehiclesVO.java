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
* 车辆
*
*/
@Data
@Schema(description = "车辆")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclesVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "所属品牌")
    @ExcelProperty("所属品牌")
    private String classify;

    @Schema(description = "车辆名称")
    @ExcelProperty("车辆名称")
    private String name;

    @Schema(description = "车身颜色")
    @ExcelProperty("车身颜色")
    private String color;

    @Schema(description = "VIN代码")
    @ExcelProperty("VIN代码")
    private Integer vin;

    @Schema(description = "发动机号码")
    @ExcelProperty("发动机号码")
    private String code;

    @Schema(description = "发动机类型与排量")
    @ExcelProperty("发动机类型与排量")
    private String type;

    @Schema(description = "变速器类型")
    @ExcelProperty("变速器类型")
    private String transmissiontype;

    @Schema(description = "车辆尺寸")
    @ExcelProperty("车辆尺寸")
    private String size;

    @Schema(description = "轮胎规格")
    @ExcelProperty("轮胎规格")
    private String tirespecifications;

    @Schema(description = "行驶里程")
    @ExcelProperty("行驶里程")
    private String mileage;

    @Schema(description = "燃油种类")
    @ExcelProperty("燃油种类")
    private String fueltype;

    @Schema(description = "简介")
    @ExcelProperty("简介")
    private String detail;

    @Schema(description = "详情")
    @ExcelProperty("详情")
    private String details;

    @Schema(description = "车辆封面")
    @ExcelProperty("车辆封面")
    private String photo;

    @Schema(description = "车辆照片")
    @ExcelProperty("车辆照片")
    private String photos;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private String status;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}