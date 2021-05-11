package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.service.ProblemService;
import io.swagger.models.auth.In;
import org.apache.ibatis.executor.result.ResultMapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;

/**
 * <p>
 * 问题药品 前端控制器
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-29
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 转向问题药品页面
     */
    @RequestMapping
    public String problem(){
        return "/problem";
    }

    /**
     * 分页查询问题药品列表
     */
    @RequestMapping("/problemQueryPage")
    @ResponseBody
    public Object problemQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Problem> iPage = problemService.selectProblemPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品新增页面
     */
    @RequestMapping("/problemPage")
    public String problemPage(){
        return "/problemPage";
    }

    /**
     *添加一个问题药品
     */
    @RequestMapping("/problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem){
        try {
            problem.setCreateTime(new Date());
            int i = problemService.addProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品编辑页面
     */
    @RequestMapping("/problemQueryById")
    public String problemQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Problem problem = problemService.queryProblemById(id);
        model.addAttribute("obj",problem);
        return "/problemPage";
    }

    /**
     * 修改一个问题药品
     */
    @RequestMapping("/problemEdit")
    @ResponseBody
    public Object problemEdit(Problem problem){
        try {
            int i = problemService.editProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个问题药品
     */
    @RequestMapping("/problemDelById")
    @ResponseBody
    public Object problemDelById(Integer id){
        try {
            int i = problemService.delProblemById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

