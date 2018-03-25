package com.gordon.tmall.service.impl;

import com.gordon.tmall.mapper.PropertyValueMapper;
import com.gordon.tmall.pojo.Product;
import com.gordon.tmall.pojo.Property;
import com.gordon.tmall.pojo.PropertyValue;
import com.gordon.tmall.pojo.PropertyValueExample;
import com.gordon.tmall.service.PropertyService;
import com.gordon.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gordon
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Autowired
    PropertyService propertyService;

    @Override
    public void init(Product p) {

        List<Property> pts = propertyService.list(p.getCid());

        for (Property pt: pts) {
            
            //查询是否已经存在属性值
            PropertyValue pv = get(pt.getId(),p.getId());
            
            //如果不存在
            if(null==pv){
                
                //初始化PropertyValue
                pv = new PropertyValue();
                
                //对于PropertyValue的管理，没有增加，只有修改。 
                //所以需要通过初始化来进行自动地增加，以便于后面的修改
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }

    }

    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs= propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty())
            return null;
        return pvs.get(0);
    }

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : result) {
            Property property = propertyService.get(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }
}