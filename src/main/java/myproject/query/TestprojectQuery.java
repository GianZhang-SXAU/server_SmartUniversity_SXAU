package myproject.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myproject.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.Date;

/**
* 检测项目查询
*
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "检测项目查询")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestprojectQuery extends Query {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "项目名称")
    private String name;

    @Schema(description = "封面")
    private String photo;

    @Schema(description = "效果图")
    private String photos;

    @Schema(description = "项目分类")
    private String classify;

    @Schema(description = "项目简介")
    private String detail;

    @Schema(description = "项目详情")
    private String details;

    @Schema(description = "创建人id")
    private Long adduserid;

    @Schema(description = "创建人")
    private String addusername;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date[] addtime;

}