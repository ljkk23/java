package swu.lj.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import swu.lj.domain.entity.Article;
import swu.lj.service.IArticleService;
import swu.lj.utils.RedisCache;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class updateViewCountJob {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IArticleService articleService;
    @Scheduled(cron = "0/50 * * * * ?")
    public void updateViewCountJob(){
        Map<String, Integer> ViewCountcacheMap = redisCache.getCacheMap("article:viewCount");
        List<Article> articleList=new ArrayList<>();
        for (String key : ViewCountcacheMap.keySet()) {
            Article article=new Article(Long.valueOf(key),ViewCountcacheMap.get(key).longValue());
            System.out.println("key = " + key + ", value = " + ViewCountcacheMap.get(key));
            articleList.add(article);
        }
        articleService.updateBatchById(articleList);
    }
}
