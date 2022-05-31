package swu.lj.service;

import org.springframework.web.multipart.MultipartFile;
import swu.lj.domain.ResponseResult;

public interface UploadService {
    ResponseResult uploadImg(MultipartFile file);
}
