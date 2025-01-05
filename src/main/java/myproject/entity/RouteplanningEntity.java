package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 线路规划
*
*/

@Data
@TableName("routeplanning")
public class RouteplanningEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 线路名
        */
        private String name;

        /**
        * 线路编号
        */
        private String routenumbers;

        /**
        * 起始站
        */
        private String initiatingstation;

        /**
        * 终点站
        */
        private String terminal;

        /**
        * 总长度
        */
        private String totallength;

        /**
        * 简介
        */
        private String detail;

        /**
        * 详情
        */
        private String details;

        /**
        * 封面
        */
        private String photo;

        /**
        * 详情图
        */
        private String photos;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}