package edu.swu.cs.controller;


import edu.swu.cs.domain.ResponseResult;
import edu.swu.cs.entity.Ware;
import edu.swu.cs.service.IWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单的库存 前端控制器
 * </p>
 *
 * @author liujian
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/ware")
public class WareController {
    @Autowired
    private IWareService wareService;
    @PostMapping("addWare")
    public ResponseResult addStock(Ware ware){
        boolean save = wareService.save(ware);
        if (!save){
            throw new RuntimeException("新增库存数据库出错");
        }
        return ResponseResult.okResult();
    }

    @GetMapping("lockWare")
    public Boolean lockWare(Long productID){
         return wareService.lockWare(productID);
    }




}

