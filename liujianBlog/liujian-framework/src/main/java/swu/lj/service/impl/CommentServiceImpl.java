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
{
        "code": 200,
        "data": {
        "rows": [
        {
        "articleId": "1",
        "children": [
        {
        "articleId": "1",
        "content": "你说啥？",
        "createBy": "1",
        "id": "20",
        "rootId": "1",
        "toCommentId": "1",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "content": "说你咋地",
        "createBy": "14787164048662",
        "id": "27",
        "rootId": "1",
        "toCommentId": "20",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "weixin"
        },
        {
        "articleId": "1",
        "content": "sdad",
        "createBy": "14787164048662",
        "id": "28",
        "rootId": "1",
        "toCommentId": "1",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "weixin"
        },
        {
        "articleId": "1",
        "content": "撒大声地",
        "createBy": "14787164048662",
        "id": "30",
        "rootId": "1",
        "toCommentId": "1",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "weixin"
        }
        ],
        "content": "asS",
        "createBy": "1",
        "id": "1",
        "rootId": "-1",
        "toCommentId": "-1",
        "toCommentUserId": "-1",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "children": [
        {
        "articleId": "1",
        "content": "你说什么",
        "createBy": "1",
        "id": "9",
        "rootId": "2",
        "toCommentId": "2",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "content": "哈哈哈哈[哈哈]",
        "createBy": "1",
        "id": "10",
        "rootId": "2",
        "toCommentId": "9",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "content": "we全文",
        "createBy": "3",
        "id": "11",
        "rootId": "2",
        "toCommentId": "10",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "weqe"
        },
        {
        "articleId": "1",
        "content": "3333",
        "createBy": "1",
        "id": "16",
        "rootId": "2",
        "toCommentId": "11",
        "toCommentUserId": "1",
        "toCommentUserName": "sg333",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "content": "回复weqedadsd",
        "createBy": "1",
        "id": "17",
        "rootId": "2",
        "toCommentId": "11",
        "toCommentUserId": "3",
        "toCommentUserName": "weqe",
        "username": "sg333"
        }
        ],
        "content": "[哈哈]SDAS",
        "createBy": "1",
        "id": "2",
        "rootId": "-1",
        "toCommentId": "-1",
        "toCommentUserId": "-1",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "children": [],
        "content": "是大多数",
        "createBy": "1",
        "id": "3",
        "rootId": "-1",
        "toCommentId": "-1",
        "toCommentUserId": "-1",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "children": [],
        "content": "撒大声地",
        "createBy": "1",
        "id": "4",
        "rootId": "-1",
        "toCommentId": "-1",
        "toCommentUserId": "-1",
        "username": "sg333"
        },
        {
        "articleId": "1",
        "children": [],
        "content": "你再说什么",
        "createBy": "1",
        "id": "5",
        "rootId": "-1",
        "toCommentId": "-1",
        "toCommentUserId": "-1",
        "username": "sg333"
        }
        ],
        "total": "17"
        },
        "msg": "操作成功"
        }