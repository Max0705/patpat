package com.etc.service;

import com.etc.dao.AppLabelMapper;
import com.etc.dao.AppMapper;
import com.etc.entity.App;
import com.etc.entity.AppExample;
import com.etc.entity.AppLabel;
import com.etc.entity.AppLabelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Component
public class AppService {
    @Autowired
    private AppMapper appMapper;
    @Autowired
    private AppLabelMapper appLabelMapper;


    //添加新的App
    public  int insertNewApp(App app){
        return appMapper.insertSelective(app);
    }
    //根据Appid删除App
    public boolean deleteApp(Integer Id){
        AppExample appExample=new AppExample();
        appExample.createCriteria().andAppidEqualTo(Id);
        return appMapper.deleteByExample(appExample)>0;
    }
    //修改App信息
    public boolean updataApp(App app){
        AppExample appExample=new AppExample();
        appExample.createCriteria().andAppidEqualTo(app.getAppid());
        return appMapper.updateByExampleSelective(app,appExample)>0;
    }
    //根据id查看App信息
    public App selectAppById(Integer Id){
        return appMapper.selectByPrimaryKey(Id);
    }
    //根据名字查找App
    public List<App> selectAppByName(String name){
        AppExample appExample=new AppExample();
        appExample.createCriteria().andAppnameLike(name);
        return appMapper.selectByExample(appExample);
    }
    //根据标签查找App
    public List<App> selectAppByLabel(String label){
        AppLabelExample appLabelExample=new AppLabelExample();
        appLabelExample.createCriteria().andLabelnameEqualTo(label);
        List<AppLabel> appLabels=appLabelMapper.selectByExample(appLabelExample);
        List<App> apps=new ArrayList<>();
        for(AppLabel appLabel:appLabels){
            apps.add(appMapper.selectByPrimaryKey(appLabel.getAppid()));
        }
        return apps;
    }
    //根据App类型查找App
    public List<App> selectAppByType(String type){
        AppExample appExample=new AppExample();
        appExample.createCriteria().andApptypeEqualTo(type);
        return appMapper.selectByExample(appExample);
    }
}
