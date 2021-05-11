package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.drug.entity.ReturnGoods;
import com.javaclimb.drug.mapper.ReturnGoodsMapper;
import com.javaclimb.drug.service.ReturnGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 收到退货 服务实现类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Service
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper, ReturnGoods> implements ReturnGoodsService {

    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;
    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<ReturnGoods> selectReturnGoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoods> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(param)){
            queryWrapper.like("dname",param);
        }
        Page<ReturnGoods> page = new Page<>(pageNum, pageSize);
        return returnGoodsMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条退货给供应商信息
     *
     * @param returnGoods
     */
    @Override
    public int addReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.insert(returnGoods);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returngoods
     */
    @Override
    public int editReturnGoods(ReturnGoods returngoods) {
        return returnGoodsMapper.updateById(returngoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public ReturnGoods queryReturnGoodsById(Integer id) {
        return returnGoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturnGoodsById(Integer id) {
        return returnGoodsMapper.deleteById(id);
    }
}
