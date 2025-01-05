package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 预约
*
*/

@Data
@TableName("appointment")
public class AppointmentEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 审核id
        */
        private Long shenheid;

        /**
        * 车辆名称
        */
        private String name;

        /**
        * 用户id
        */
        private Long userid;

        /**
        * 用户名称
        */
        private String username;

        /**
        * 审核
        */
        private String shenhe;

        /**
        * 封面
        */
        private String photo;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}