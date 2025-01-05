package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

    import java.util.Date;

/**
* 投诉反馈查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "投诉反馈查询")
public class TousufankuiQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "投诉原因")
    private String name;

    @Schema(description = "投诉照片")
    private String photo;

    @Schema(description = "投诉简介")
    private String detail;

    @Schema(description = "投诉详情")
    private String details;

    @Schema(description = "投诉人id")
    private Long userid;

    @Schema(description = "投诉人名字")
    private String username;

    @Schema(description = "投诉状态")
    private String status;

    @Schema(description = "反馈结果")
    private String fankuijieguo;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}