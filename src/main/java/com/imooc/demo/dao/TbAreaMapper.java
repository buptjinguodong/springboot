package com.imooc.demo.dao;

import java.util.List;

import com.imooc.demo.entity.TbArea;
import org.apache.ibatis.annotations.Param;

public interface TbAreaMapper {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<TbArea> queryArea();

    /**
     * 根据Id列出具体区域
     * @param areaId
     * @return area
     */
    TbArea queryAreaById(int areaId);

    /**
     * 插入区域信息
     * @param record
     * @return
     */
    int insertArea(TbArea record);

    /**
     * 更新区域信息
     * @param record
     * @return
     */
    int updateArea(TbArea record);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

}