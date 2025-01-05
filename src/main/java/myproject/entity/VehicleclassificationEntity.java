package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 车辆分类
*
*/

@Data
@TableName("vehicleclassification")
public class VehicleclassificationEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 名称
        */
        private String name;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}