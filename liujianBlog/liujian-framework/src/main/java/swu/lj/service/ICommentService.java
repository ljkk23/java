package swu.lj.service;

import io.swagger.models.auth.In;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-08-03
 */
public interface ICommentService extends IService<Comment> {

    ResponseResult getCommentlist(Long articleID,Integer pageNum,Integer pageSize);
}
