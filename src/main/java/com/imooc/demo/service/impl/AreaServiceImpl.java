package com.imooc.demo.service.impl;

import com.imooc.demo.dao.TbAreaMapper;
import com.imooc.demo.entity.TbArea;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// 通知Spring容器，加载此Bean
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private TbAreaMapper tbAreaMapper;

    @Override
    public List<TbArea> queryArea() {
        return tbAreaMapper.queryArea();
    }

    @Override
    public TbArea queryAreaById(int areaId) {
        return tbAreaMapper.queryAreaById(areaId);
    }

    /**
     * 开始事务控制，Transactional默认使用RuntimeException事件作为回滚事件。
     * 可以通过@Transactional(rollbackFor = Exception.class) 的方式设置回滚事件
      */
    @Transactional
    @Override
    public boolean insertArea(TbArea record) {
        if(record.getAreaName() != null && !"".equals(record.getAreaName())){
            record.setCreateTime(new Date());
            record.setLastEditTime(new Date());
            try {
                int effectedNum = tbAreaMapper.insertArea(record);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateArea(TbArea record) {
        if(record.getAreaName() != null && !"".equals(record.getAreaName())){
            record.setCreateTime(new Date());
            record.setLastEditTime(new Date());
            try {
                int effectedNum = tbAreaMapper.updateArea(record);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try {
                int effectedNum = tbAreaMapper.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }
}
