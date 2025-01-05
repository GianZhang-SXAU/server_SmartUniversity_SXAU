package myproject.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 投诉反馈
*
*/

@Data
@TableName("tousufankui")
public class TousufankuiEntity {
        /**
        * 主键
        */
        @TableId
        private Long id;

        /**
        * 投诉原因
        */
        private String name;

        /**
        * 投诉照片
        */
        private String photo;

        /**
        * 投诉简介
        */
        private String detail;

        /**
        * 投诉详情
        */
        private String details;

        /**
        * 投诉人id
        */
        private Long userid;

        /**
        * 投诉人名字
        */
        private String username;

        /**
        * 投诉状态
        */
        private String status;

        /**
        * 反馈结果
        */
        private String fankuijieguo;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}