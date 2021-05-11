package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.DrugInfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 药品信息 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-18
 */
@Controller
@RequestMapping("/drugInfo")
public class DrugInfoController {

    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * 转向药品页面
     */
    @RequestMapping
    public String drugInfo(){
        return "/drugInfo";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping("/drugInfoQueryPage")
    @ResponseBody
    public Object drugInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<DrugInfo> iPage = drugInfoService.selectDrugInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     */
    @RequestMapping("/drugInfoPage")
    public String drugInfoPage(){
        return "/drugInfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping("/drugInfoAdd")
    @ResponseBody
    public Object drugInfoAdd(DrugInfo drugInfo){
        try {
            int i = drugInfoService.addDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向药品编辑页面
     */
    @RequestMapping("/drugInfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        DrugInfo drugInfo = drugInfoService.queryDrugInfoById(id);
        model.addAttribute("obj",drugInfo);
        return "/drugInfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping("/drugInfoEdit")
    @ResponseBody
    public Object drugInfoEdit(DrugInfo drugInfo){
        try {
            int i = drugInfoService.editDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping("/drugInfoDelById")
    @ResponseBody
    public Object drugInfoDelById(Integer id){
        try {
            int i = drugInfoService.delDrugInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 获取所有的供应商
     */
    @RequestMapping("/drugInfoList")
    @ResponseBody
    public Object drugInfoList(){
        List<DrugInfo> drugInfoList = drugInfoService.queryDrugInfoList();
        return ResultMapUtil.getHashMapList(drugInfoList);
    }

    /**
     * 转向药品保质期检查页面
     */
    @RequestMapping("/warranty")
    public String warranty(){
        return "/warranty";
    }
}

