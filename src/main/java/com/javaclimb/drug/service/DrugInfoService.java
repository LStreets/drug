package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.DrugInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 药品信息 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-18
 */
public interface DrugInfoService extends IService<DrugInfo> {
    /**
     * 分页查询药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品名称
     * @return
     */
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条药品信息
     * @param drugInfo
     */
    public int addDrugInfo(DrugInfo drugInfo);

    /**
     * 修改一条药品信息
     * @param drugInfo
     */
    public int editDrugInfo(DrugInfo drugInfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public DrugInfo queryDrugInfoById(Integer id);

    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
     public int delDrugInfoById(Integer id);

    /**
     * 查询所有药品
     * @return
     */
    public List<DrugInfo> queryDrugInfoList();


}
