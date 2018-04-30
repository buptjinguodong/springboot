package com.imooc.demo.service;

import com.imooc.demo.entity.TbArea;

import java.util.List;

public interface AreaService {
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
    boolean insertArea(TbArea record);

    /**
     * 更新区域信息
     * @param record
     * @return
     */
    boolean updateArea(TbArea record);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
