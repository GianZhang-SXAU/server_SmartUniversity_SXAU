package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 传感器
*
*/

@Data
@TableName("sensores")
public class SensoresEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 传感器名称
        */
        private String name;

        /**
        * 传感器类型
        */
        private String type;

        /**
        * 传感器品牌
        */
        private String sensorbrand;

        /**
        * 安装位置
        */
        private String installationposition;

        /**
        * 安装时间
        */
        private Date installationtime;

        /**
        * 传感器状态
        */
        private String sensorstate;

        /**
        * 车辆id
        */
        private Long vehicleid;

        /**
        * 车辆名称
        */
        private String vehiclename;

        /**
        * 传感器图片
        */
        private String photo;

        /**
        * 传感器详情
        */
        private String details;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}