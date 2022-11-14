package edu.swu.cs.controller;


import edu.swu.cs.domain.ResponseResult;
import edu.swu.cs.entity.Doctor;
import edu.swu.cs.entity.VO.DoctorVO;
import edu.swu.cs.enums.AppHttpCodeEnum;
import edu.swu.cs.service.IDoctorService;
import edu.swu.cs.utils.BeanCopyUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 医院用户表 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-11-10
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;

    @ApiImplicitParams({
            @ApiImplicitParam(name="deptId",value="部门id",dataType="Long",example="2"),
            @ApiImplicitParam(name="title",value="医生职称",dataType="String")}
    )
    @PostMapping("/addDoctor")
    public ResponseResult addDoctor(Doctor doctor){
        if (!doctorService.save(doctor)){
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR,"插入数据库出错");
        }
        return ResponseResult.okResult();
    }
    @GetMapping("FeignGetDoctorInfo")
    public DoctorVO FeignGetDoctorInfo(Long id){
        Doctor doctor = doctorService.getById(id);
        return BeanCopyUtils.copyBean(doctor, DoctorVO.class);
    }
}

