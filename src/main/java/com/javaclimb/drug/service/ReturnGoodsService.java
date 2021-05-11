package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.ReturnGoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收到退货 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
public interface ReturnGoodsService extends IService<ReturnGoods> {
    /**
     * 分页查询收到退货数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-收到退货名称
     * @return
     */
    public IPage<ReturnGoods> selectReturnGoodsPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条退货给供应商信息
     * @param returnGoods
     */
    public int addReturnGoods(ReturnGoods returnGoods);

    /**
     * 修改一条收到退货信息
     * @param returngoods
     */
    public int editReturnGoods(ReturnGoods returngoods);

    /**
     * 根据主键id查询一个收到退货对象
     * @param id
     * @return
     */
    public ReturnGoods queryReturnGoodsById(Integer id);

    /**
     * 根据主键id删除一个收到退货对象
     * @param id
     * @return
     */
    public int delReturnGoodsById(Integer id);

}
