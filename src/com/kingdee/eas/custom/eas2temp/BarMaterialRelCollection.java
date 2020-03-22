package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BarMaterialRelCollection extends AbstractObjectCollection 
{
    public BarMaterialRelCollection()
    {
        super(BarMaterialRelInfo.class);
    }
    public boolean add(BarMaterialRelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BarMaterialRelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BarMaterialRelInfo item)
    {
        return removeObject(item);
    }
    public BarMaterialRelInfo get(int index)
    {
        return(BarMaterialRelInfo)getObject(index);
    }
    public BarMaterialRelInfo get(Object key)
    {
        return(BarMaterialRelInfo)getObject(key);
    }
    public void set(int index, BarMaterialRelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BarMaterialRelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BarMaterialRelInfo item)
    {
        return super.indexOf(item);
    }
}