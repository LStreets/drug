package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.SaleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 销售记录 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
public interface SaleInfoService extends IService<SaleInfo> {
    /**
     * 分页查询销售记录数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-销售记录名称
     * @return
     */
    public IPage<SaleInfo> selectSaleinfoPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条销售记录信息
     * @param saleInfo
     */
    public int addSaleInfo(SaleInfo saleInfo);

    /**
     * 修改一条销售记录信息
     * @param saleInfo
     */
    public int editSaleInfo(SaleInfo saleInfo);

    /**
     * 根据主键id查询一个销售记录对象
     * @param id
     * @return
     */
    public SaleInfo querySaleInfoById(Integer id);

    /**
     * 根据主键id删除一个销售记录对象
     * @param id
     * @return
     */
    public int delSaleInfoById(Integer id);

}
