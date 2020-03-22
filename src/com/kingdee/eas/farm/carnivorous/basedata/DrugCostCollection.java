package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugCostCollection extends AbstractObjectCollection 
{
    public DrugCostCollection()
    {
        super(DrugCostInfo.class);
    }
    public boolean add(DrugCostInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugCostCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugCostInfo item)
    {
        return removeObject(item);
    }
    public DrugCostInfo get(int index)
    {
        return(DrugCostInfo)getObject(index);
    }
    public DrugCostInfo get(Object key)
    {
        return(DrugCostInfo)getObject(key);
    }
    public void set(int index, DrugCostInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugCostInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugCostInfo item)
    {
        return super.indexOf(item);
    }
}