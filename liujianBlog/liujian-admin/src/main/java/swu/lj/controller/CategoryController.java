package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.service.ICategoryService;

@RestController
@RequestMapping("/content/category/")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/listAllCategory")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}
