package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.ReturnSupplier;
import com.javaclimb.drug.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 退货给供应商 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/returnSupplier")
public class ReturnSupplierController {

    @Autowired
    private ReturnSupplierService returnSupplierService;

    /**
     * 转向退货给供应商页面
     */
    @RequestMapping
    public String returnSupplier(){
        return "/returnSupplier";
    }

    /**
     * 分页查询退货给供应商列表
     */
    @RequestMapping("/returnSupplierQueryPage")
    @ResponseBody
    public Object returnSupplierQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<ReturnSupplier> iPage = returnSupplierService.selectReturnSupplierPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 转向退货给供应商新增页面
     */
    @RequestMapping("/returnSupplierPage")
    public String returnSupplierPage(){
        return "/returnSupplierPage";
    }

    /**
     * 添加一个退货给供应商
     */
    @RequestMapping("/returnSupplierAdd")
    @ResponseBody
    public Object returnSupplierAdd(ReturnSupplier returnSupplier){
        try {
            int i = returnSupplierService.addReturnSupplier(returnSupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商编辑页面
     */
    @RequestMapping("/returnSupplierQueryById")
    public String returnSupplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ReturnSupplier returnSupplier = returnSupplierService.queryReturnSupplierById(id);
        model.addAttribute("obj",returnSupplier);
        return "/returnSupplierPage";
    }

    /**
     * 修改一个退货给供应商
     */
    @RequestMapping("/returnSupplierEdit")
    @ResponseBody
    public Object returnSupplierEdit(ReturnSupplier returnSupplier){
        try {
            int i = returnSupplierService.editReturnSupplier(returnSupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个退货给供应商
     */
    @RequestMapping("/returnSupplierDelById")
    @ResponseBody
    public Object returnSupplierDelById(Integer id){
        try {
            int i = returnSupplierService.delReturnSupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

