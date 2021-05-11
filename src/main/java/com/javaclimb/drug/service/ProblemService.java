package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Problem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 问题药品 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-29
 */
public interface ProblemService extends IService<Problem> {
    /**
     * 分页查询问题药品出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-问题药品名称
     * @return
     */
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条问题药品信息
     * @param problem
     */
    public int addProblem(Problem problem);

    /**
     * 修改一条问题药品信息
     * @param problem
     */
    public int editProblem(Problem problem);

    /**
     * 根据主键id查询一个问题药品对象
     * @param id
     * @return
     */
    public Problem queryProblemById(Integer id);

    /**
     * 根据主键id删除一个问题药品对象
     * @param id
     * @return
     */
    public int delProblemById(Integer id);
}
