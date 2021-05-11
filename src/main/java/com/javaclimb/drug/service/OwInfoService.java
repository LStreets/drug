package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.OwInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 出入库 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-19
 */
public interface OwInfoService extends IService<OwInfo> {
    /**
     * 分页查询药品出入库出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品出入库名称
     * @return
     */
    public IPage<OwInfo> selectOwInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品出入库信息
     * @param drugInfo
     */
    public int addOwInfo(OwInfo drugInfo);

    /**
     * 修改一条药品出入库信息
     * @param drugInfo
     */
    public int editOwInfo(OwInfo drugInfo);

    /**
     * 根据主键id查询一个药品出入库对象
     * @param id
     * @return
     */
    public OwInfo queryOwInfoById(Integer id);

    /**
     * 根据主键id删除一个药品出入库对象
     * @param id
     * @return
     */
    public int delOwInfoById(Integer id);

}
