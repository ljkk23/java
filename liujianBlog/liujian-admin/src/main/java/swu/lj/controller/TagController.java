package swu.lj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.mapper.TagMapper;
import swu.lj.service.ITagService;
import swu.lj.service.impl.TagServiceImpl;

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
    public ResponseResult getTagList(){
        System.out.println("sss");
        return ResponseResult.okResult(tagService.list());
    }
}

