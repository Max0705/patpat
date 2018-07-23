package com.etc.service;

import com.etc.dao.AppLabelMapper;
import com.etc.entity.AppLabel;
import com.etc.entity.AppLabelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppLabelService {
    @Autowired
    AppLabelMapper appLabelMapper;
    //为app添加新标签
    public boolean insertAppLabel(AppLabel appLabel){
        return appLabelMapper.insert(appLabel)>0;
    }
    //删除标签
    public  boolean deleteAppLabel(Integer Id){
        return appLabelMapper.deleteByPrimaryKey(Id)>0;
    }
    //修改标签
    public boolean updataAppLable(AppLabel appLabel){
        AppLabelExample appLabelExample=new AppLabelExample();
        appLabelExample.createCriteria().andAppidEqualTo(appLabel.getAppid()).andLabelidEqualTo(appLabel.getLabelid());
        return appLabelMapper.updateByExample(appLabel,appLabelExample)>0;
    }
    //查看App的标签
    public List<AppLabel> selectAppLabel(Integer appId){
        AppLabelExample appLabelExample=new AppLabelExample();
        appLabelExample.createCriteria().andAppidEqualTo(appId);
        return appLabelMapper.selectByExample(appLabelExample);
    }
}
