package swu.lj.controller;


import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Tag;
import swu.lj.domain.vo.PageVo;
import swu.lj.enums.AppHttpCodeEnum;
import swu.lj.mapper.TagMapper;
import swu.lj.service.ITagService;
import swu.lj.service.impl.TagServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private ITagService tagService;
    @GetMapping("/list")
    public ResponseResult getTagList(Integer pageNum,Integer pageSize,String name,String remark){
        PageVo pageTag = tagService.getPageTag(pageNum, pageSize, name, remark);
        return ResponseResult.okResult(pageTag);
    }

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<Tag> list = tagService.list();
        return ResponseResult.okResult(list);
    }
    @PostMapping()
    public ResponseResult addTag(String name,String remark){
        Tag tag=new Tag();
        tag.setName(name);
        tag.setRemark(remark);
        if (tagService.save(tag)){
            return ResponseResult.okResult();
        }else
            return ResponseResult.errorResult(500,"数据库保存错误");
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable("id") Integer id){
        if (tagService.removeById(id)){
            return ResponseResult.okResult();
        }else
            return ResponseResult.errorResult(500,"数据库操作失败");
    }
    @GetMapping("/{id}")
    public ResponseResult getTag(@PathVariable("id") Integer id){
        return ResponseResult.okResult(tagService.getById(id));

    }
    @PutMapping()
    public ResponseResult modifyTag(@RequestBody Map<String, Object> data){
        System.out.println(data.get("id").toString()+data.get("name").toString()+data.get("remark").toString());
        Tag tag=new Tag(Long.valueOf(data.get("id").toString()),data.get("name").toString(),data.get("remark").toString());
        if (tagService.updateById(tag)) {
            return ResponseResult.okResult();
        }else
            return ResponseResult.errorResult(500,"数据库错误");
    }
}

