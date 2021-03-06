package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swu.lj.domain.ResponseResult;
import swu.lj.service.ILinkService;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private ILinkService linkService;
    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
