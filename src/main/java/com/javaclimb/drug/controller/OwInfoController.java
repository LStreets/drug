package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.DrugInfo;
import com.javaclimb.drug.entity.OwInfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.OwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 出入库 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-19
 */
@Controller
@RequestMapping("/owInfo")
public class OwInfoController {

    @Autowired
    private OwInfoService owInfoService;

    /**
     * 转向药品出入库页面
     */
    @RequestMapping
    public String owInfo(){
        return "/owInfo";
    }

    /**
     * 分页查询药品出入库列表
     */
    @RequestMapping("/owInfoQueryPage")
    @ResponseBody
    public Object owInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<OwInfo> iPage = owInfoService.selectOwInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品出入库新增页面
     */
    @RequestMapping("/owInfoPage")
    public String owInfoPage(){
        return "/owInfoPage";
    }

    /**
     * 添加一个药品出入库
     */
    @RequestMapping("/owInfoAdd")
    @ResponseBody
    public Object owInfoAdd(OwInfo owInfo){
        try {
            owInfo.setCreateTime(new Date());
            int i = owInfoService.addOwInfo(owInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向药品出入库编辑页面
     */
    @RequestMapping("/owInfoQueryById")
    public String owInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        OwInfo owInfo = owInfoService.queryOwInfoById(id);
        model.addAttribute("obj",owInfo);
        return "/owInfoPage";
    }

    /**
     * 修改一个药品出入库
     */
    @RequestMapping("/owInfoEdit")
    @ResponseBody
    public Object owInfoEdit(OwInfo owInfo){
        try {
            int i = owInfoService.editOwInfo(owInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品出入库
     */
    @RequestMapping("/owInfoDelById")
    @ResponseBody
    public Object owInfoDelById(Integer id){
        try {
            int i = owInfoService.delOwInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


}

