package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 传感器查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "传感器查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensoresQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "传感器名称")
    private String name;

    @Schema(description = "传感器类型")
    private String type;

    @Schema(description = "传感器品牌")
    private String sensorbrand;

    @Schema(description = "安装位置")
    private String installationposition;

    @Schema(description = "安装时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] installationtime;

    @Schema(description = "传感器状态")
    private String sensorstate;

    @Schema(description = "车辆id")
    private Long vehicleid;

    @Schema(description = "车辆名称")
    private String vehiclename;

    @Schema(description = "传感器图片")
    private String photo;

    @Schema(description = "传感器详情")
    private String details;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}