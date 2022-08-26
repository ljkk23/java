package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Comment;
import swu.lj.domain.vo.CommentVo;
import swu.lj.domain.vo.PageVo;
import swu.lj.mapper.CommentMapper;
import swu.lj.service.IArticleService;
import swu.lj.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import swu.lj.service.IUserService;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-08-03
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {


    @Autowired
    private IUserService userService;


    @Override
    public ResponseResult getCommentlist(Long articleID, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,articleID).eq(Comment::getRootId,-1);
        Page<Comment> commentPage=new Page<>(pageNum,pageSize);
        page(commentPage,queryWrapper);
        //把每一个评论的所属人的昵称和被评论人的昵称通过数据库查询出来，并且赋值
        List<CommentVo> commentVoList=toCommentVoList(commentPage.getRecords());
        //设置子评论
        for (CommentVo commentVo: commentVoList){
            commentVo.setChildren(getCommentChildren(commentVo.getId()));
        }
        return ResponseResult.okResult(new PageVo(commentVoList, commentPage.getTotal()));
    }

    private List<CommentVo> toCommentVoList(List<Comment> records) {
        List<CommentVo> commentVoList=BeanCopyUtils.copyBeanList(records, CommentVo.class);

        for (CommentVo commentVo:commentVoList){
            //设置回复评论的人的昵称
            String nickName=userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);
            if (commentVo.getToCommentUserId()!=-1){
                //设置评论所属人的昵称
                String toCommentUserName=userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
       }
        return commentVoList;
    }

    private List<CommentVo> getCommentChildren(Long commentID) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,commentID);
        queryWrapper.orderByAsc(Comment::getCreateTime);
        //因为是在service这一个文件中，所以继承了Iservice的方法
        List<Comment> commentVoListChildren=list(queryWrapper);
        return toCommentVoList(commentVoListChildren);
    }
}
