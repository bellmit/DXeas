package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarSendPlanCollection extends AbstractObjectCollection 
{
    public CarSendPlanCollection()
    {
        super(CarSendPlanInfo.class);
    }
    public boolean add(CarSendPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarSendPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarSendPlanInfo item)
    {
        return removeObject(item);
    }
    public CarSendPlanInfo get(int index)
    {
        return(CarSendPlanInfo)getObject(index);
    }
    public CarSendPlanInfo get(Object key)
    {
        return(CarSendPlanInfo)getObject(key);
    }
    public void set(int index, CarSendPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarSendPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarSendPlanInfo item)
    {
        return super.indexOf(item);
    }
}