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
* 项目分类
*
*/
@Data
@Schema(description = "项目分类")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectclassificationVO implements Serializable {
private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @ExcelIgnore
    private Long id;

    @Schema(description = "名称")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_PATTERN)
    @ExcelProperty("创建时间")
    private Date addtime;


}