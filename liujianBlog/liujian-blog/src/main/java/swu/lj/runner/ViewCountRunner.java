package swu.lj.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import swu.lj.domain.entity.Article;
import swu.lj.service.IArticleService;
import swu.lj.service.IUserService;
import swu.lj.utils.RedisCache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {
        List<Article> articleList=articleService.list();
        Map<String,Integer> viewCountMap=new HashMap<>();
        for (Article article:articleList){
            viewCountMap.put(article.getId().toString(),article.getViewCount().intValue());
        }
        redisCache.setCacheMap("article:viewCount",viewCountMap);
    }
}
