package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 项目预约
*
*/

@Data
@TableName("projectappointment")
public class ProjectappointmentEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 项目名称
        */
        private String name;

        /**
        * 项目id
        */
        private Long shenheid;

        /**
        * 预约人id
        */
        private Long userid;

        /**
        * 预约人
        */
        private String username;

        /**
        * 创建人id
        */
        private Long adduserid;

        /**
        * 创建人
        */
        private String addusername;

        /**
        * 封面
        */
        private String photo;

        /**
        * 审核
        */
        private String shenhe;

        /**
        * 检测报告
        */
        private String files;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}