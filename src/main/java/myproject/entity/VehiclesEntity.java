package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 车辆
*
*/

@Data
@TableName("vehicles")
public class VehiclesEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 所属品牌
        */
        private String classify;

        /**
        * 车辆名称
        */
        private String name;

        /**
        * 车身颜色
        */
        private String color;

        /**
        * VIN代码
        */
        private Integer vin;

        /**
        * 发动机号码
        */
        private String code;

        /**
        * 发动机类型与排量
        */
        private String type;

        /**
        * 变速器类型
        */
        private String transmissiontype;

        /**
        * 车辆尺寸
        */
        private String size;

        /**
        * 轮胎规格
        */
        private String tirespecifications;

        /**
        * 行驶里程
        */
        private String mileage;

        /**
        * 燃油种类
        */
        private String fueltype;

        /**
        * 简介
        */
        private String detail;

        /**
        * 详情
        */
        private String details;

        /**
        * 车辆封面
        */
        private String photo;

        /**
        * 车辆照片
        */
        private String photos;

        /**
        * 状态
        */
        private String status;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}