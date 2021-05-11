package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.BillInfo;
import com.javaclimb.drug.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 账单信息 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/billInfo")
public class BillInfoController {
    @Autowired
    private BillInfoService billInfoService;

    /**
     * 转向账单信息页面
     */
    @RequestMapping
    public String billInfo(){
        return "/billInfo";
    }

    /**
     * 分页查询账单信息列表
     */
    @RequestMapping("/billInfoQueryPage")
    @ResponseBody
    public Object billInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<BillInfo> iPage = billInfoService.selectBillInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息新增页面
     */
    @RequestMapping("/billInfoPage")
    public String billInfoPage(){
        return "/billInfoPage";
    }

    /**
     * 添加一个账单信息
     */
    @RequestMapping("/billInfoAdd")
    @ResponseBody
    public Object billInfoAdd(BillInfo billInfo){
        try {
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息编辑页面
     */
    @RequestMapping("/billInfoQueryById")
    public Object billInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billInfoPage";
    }

    /**
     * 修改一个账单信息
     */
    @RequestMapping("/billInfoEdit")
    @ResponseBody
    public Object billInfoEdit(BillInfo billInfo){
        try {
            int i = billInfoService.editBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个账单信息
     */
    @RequestMapping("/billInfoDelById")
    @ResponseBody
    public Object billInfoDelById(Integer id){
        try {
            int i = billInfoService.delBillInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


}

