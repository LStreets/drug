package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.BillInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账单信息 服务类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
public interface BillInfoService extends IService<BillInfo> {
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<BillInfo> selectBillInfoPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条账单信息信息
     * @param billInfo
     */
    public int addBillInfo(BillInfo billInfo);

    /**
     * 修改一条账单信息信息
     * @param billInfo
     */
    public int editBillInfo(BillInfo billInfo);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public BillInfo queryBillInfoById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int delBillInfoById(Integer id);

}
