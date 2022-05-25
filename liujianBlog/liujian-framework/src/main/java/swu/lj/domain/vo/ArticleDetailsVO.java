package swu.lj.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDetailsVO {
    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;

    //所属分类id
    private Long categoryId;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    @TableField(exist = false)
    private String categoryName;

    private Date createTime;
}
