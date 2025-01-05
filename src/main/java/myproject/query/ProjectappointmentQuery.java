package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 项目预约查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "项目预约查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectappointmentQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "项目名称")
    private String name;

    @Schema(description = "项目id")
    private Long shenheid;

    @Schema(description = "预约人id")
    private Long userid;

    @Schema(description = "预约人")
    private String username;

    @Schema(description = "创建人id")
    private Long adduserid;

    @Schema(description = "创建人")
    private String addusername;

    @Schema(description = "封面")
    private String photo;

    @Schema(description = "审核")
    private String shenhe;

    @Schema(description = "检测报告")
    private String files;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}