package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.drug.entity.DrugInfo;
import com.javaclimb.drug.mapper.DrugInfoMapper;
import com.javaclimb.drug.service.DrugInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 药品信息 服务实现类
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-18
 */
@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {

    @Autowired
    private DrugInfoMapper drugInfoMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param) {

        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(param)){
            queryWrapper.like("name",param);
        }
        Page<DrugInfo> page = new Page<>(pageNum, pageSize);
        return drugInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条药品信息
     *
     * @param drugInfo
     */
    @Override
    public int addDrugInfo(DrugInfo drugInfo) {
        return drugInfoMapper.insert(drugInfo);
    }

    /**
     * 修改一条药品信息
     * @param drugInfo
     */
    @Override
    public int editDrugInfo(DrugInfo drugInfo) {

        return drugInfoMapper.updateById(drugInfo);
    }

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    @Override
    public DrugInfo queryDrugInfoById(Integer id) {
        return drugInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    @Override
    public int delDrugInfoById(Integer id) {
        return drugInfoMapper.deleteById(id);
    }


    /**
     * 查询所有药品
     * @return
     */
    @Override
    public List<DrugInfo> queryDrugInfoList() {
        return drugInfoMapper.selectList(null);
    }
}
