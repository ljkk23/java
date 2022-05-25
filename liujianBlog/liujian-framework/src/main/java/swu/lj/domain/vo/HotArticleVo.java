package swu.lj.domain.vo;

import lombok.Data;

@Data
public class HotArticleVo {
    private Long id;
    //访问量
    private Long viewCount;
    //标题
    private String title;
}
