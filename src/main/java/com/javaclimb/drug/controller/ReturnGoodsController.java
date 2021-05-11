package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.ReturnGoods;
import com.javaclimb.drug.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 收到退货 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/returnGoods")
public class ReturnGoodsController {

    @Autowired
    private ReturnGoodsService returnGoodsService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returnGoods(){
        return "/returnGoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping("/returnGoodsQueryPage")
    @ResponseBody
    public Object returnGoodsQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<ReturnGoods> iPage = returnGoodsService.selectReturnGoodsPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping("/returnGoodsPage")
    public String returnGoodsPage(){
        return "/returnGoodsPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping("/returnGoodsAdd")
    @ResponseBody
    public Object returnGoodsAdd(ReturnGoods returnGoods){
        try {
            int i = returnGoodsService.addReturnGoods(returnGoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping("/returnGoodsQueryById")
    public String returnGoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ReturnGoods returnGoods = returnGoodsService.queryReturnGoodsById(id);
        model.addAttribute("obj",returnGoods);
        return "/returnGoodsPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping("/returnGoodsEdit")
    @ResponseBody
    public Object returnGoodsEdit(ReturnGoods returnGoods){
        try {
            int i = returnGoodsService.editReturnGoods(returnGoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping("/returnGoodsDelById")
    @ResponseBody
    public Object returnGoodsDelById(Integer id){
        try {
            int i = returnGoodsService.delReturnGoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

