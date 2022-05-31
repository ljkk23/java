package swu.lj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import swu.lj.domain.ResponseResult;
import swu.lj.service.UploadService;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadImg")
    public ResponseResult uploadImg(MultipartFile file){
        return uploadService.uploadImg(file);
    }
}
