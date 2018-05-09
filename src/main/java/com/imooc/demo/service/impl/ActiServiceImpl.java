package com.imooc.demo.service.impl;

import com.imooc.demo.dao.ActiDetailMapper;
import com.imooc.demo.dao.ActiInfoMapper;
import com.imooc.demo.entity.ActiDetail;
import com.imooc.demo.entity.ActiInfo;
import com.imooc.demo.service.ActiService;
import com.imooc.demo.utils.A0628BeanConstants;
import com.imooc.demo.utils.ConstantUtil;
import com.imooc.demo.utils.DataBusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiServiceImpl implements ActiService {

    @Autowired
    ActiInfoMapper actiInfoMapper;

    @Autowired
    ActiDetailMapper actiDetailMapper;

    public List<ActiInfo> enquireActiList(ActiInfo actiInfo){
        return actiInfoMapper.select(actiInfo);
    }

    @Override
    public ActiDetail enquireActiDetail(String actiId) {
        ActiDetail res = null;
        res = actiDetailMapper.selectByPrimaryKey(actiId);
        return res;
    }

    @Override
    public void dealActiDetail() {
        String svcTpcd = (String) DataBusUtils.getValue(A0628BeanConstants.SVC_TPCD);
        ActiInfo actiInfo = (ActiInfo) DataBusUtils.getValue(A0628BeanConstants.ACTI_INFO);

        switch (svcTpcd) {
            case ConstantUtil.SVC_TPCD_ADD:
                actiInfoMapper.insert(actiInfo);
                break;
            case ConstantUtil.SVC_TPCD_DELETE:
                actiInfoMapper.deleteByPrimaryKey(actiInfo.getActiId());
                break;
            case ConstantUtil.SVC_TPCD_EDIT:
                actiInfoMapper.updateByPrimaryKey(actiInfo);
                break;
            case ConstantUtil.SVC_TPCD_QUERY:
                actiInfo = actiInfoMapper.selectByPrimaryKey(actiInfo.getActiId());
                break;
            default:
                break;
        }

        DataBusUtils.setValue(A0628BeanConstants.ACTI_INFO, actiInfo);
    }

}
