package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 线路规划查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "线路规划查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteplanningQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "线路名")
    private String name;

    @Schema(description = "线路编号")
    private String routenumbers;

    @Schema(description = "起始站")
    private String initiatingstation;

    @Schema(description = "终点站")
    private String terminal;

    @Schema(description = "总长度")
    private String totallength;

    @Schema(description = "简介")
    private String detail;

    @Schema(description = "详情")
    private String details;

    @Schema(description = "封面")
    private String photo;

    @Schema(description = "详情图")
    private String photos;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}