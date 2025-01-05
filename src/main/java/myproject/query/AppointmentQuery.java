package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 预约查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "预约查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "审核id")
    private Long shenheid;

    @Schema(description = "车辆名称")
    private String name;

    @Schema(description = "用户id")
    private Long userid;

    @Schema(description = "用户名称")
    private String username;

    @Schema(description = "审核")
    private String shenhe;

    @Schema(description = "封面")
    private String photo;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}