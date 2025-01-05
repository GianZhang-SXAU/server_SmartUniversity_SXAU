package myproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
    import java.util.Date;

/**
* 检测项目
*
*/

@Data
@TableName("testproject")
public class TestprojectEntity {
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
        * 封面
        */
        private String photo;

        /**
        * 效果图
        */
        private String photos;

        /**
        * 项目分类
        */
        private String classify;

        /**
        * 项目简介
        */
        private String detail;

        /**
        * 项目详情
        */
        private String details;

        /**
        * 创建人id
        */
        private Long adduserid;

        /**
        * 创建人
        */
        private String addusername;

        /**
        * 创建时间
        */
        @TableField(fill = FieldFill.INSERT)
        private Date addtime;

}