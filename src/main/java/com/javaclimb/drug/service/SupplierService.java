package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 供应商 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-17
 */
public interface SupplierService extends IService<Supplier> {

    /**
     * 分页查询供应商数据
     * @param pageNum 第几页
     * @param pageSize 每页多少数据
     * @param param 查询参数--供应商名称
     * @return //
     */
    public IPage<Supplier> selectSupplierPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条供应商信息
     * @param supplier
     * @return
     */
    public int addSupplier(Supplier supplier);

    /**
     * 修改一条供应商信息
     * @param supplier
     * @return
     */
    public int editSupplier(Supplier supplier);
    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */

    public Supplier querySupplierById(Integer id);

    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    public int delSupplierById(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    public List<Supplier> querySupplierList();


}
