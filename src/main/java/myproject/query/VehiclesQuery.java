package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 车辆查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "车辆查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclesQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "所属品牌")
    private String classify;

    @Schema(description = "车辆名称")
    private String name;

    @Schema(description = "车身颜色")
    private String color;

    @Schema(description = "VIN代码")
    private Integer vin;

    @Schema(description = "发动机号码")
    private String code;

    @Schema(description = "发动机类型与排量")
    private String type;

    @Schema(description = "变速器类型")
    private String transmissiontype;

    @Schema(description = "车辆尺寸")
    private String size;

    @Schema(description = "轮胎规格")
    private String tirespecifications;

    @Schema(description = "行驶里程")
    private String mileage;

    @Schema(description = "燃油种类")
    private String fueltype;

    @Schema(description = "简介")
    private String detail;

    @Schema(description = "详情")
    private String details;

    @Schema(description = "车辆封面")
    private String photo;

    @Schema(description = "车辆照片")
    private String photos;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}