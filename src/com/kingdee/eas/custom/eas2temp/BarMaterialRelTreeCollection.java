package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BarMaterialRelTreeCollection extends AbstractObjectCollection 
{
    public BarMaterialRelTreeCollection()
    {
        super(BarMaterialRelTreeInfo.class);
    }
    public boolean add(BarMaterialRelTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BarMaterialRelTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BarMaterialRelTreeInfo item)
    {
        return removeObject(item);
    }
    public BarMaterialRelTreeInfo get(int index)
    {
        return(BarMaterialRelTreeInfo)getObject(index);
    }
    public BarMaterialRelTreeInfo get(Object key)
    {
        return(BarMaterialRelTreeInfo)getObject(key);
    }
    public void set(int index, BarMaterialRelTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BarMaterialRelTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BarMaterialRelTreeInfo item)
    {
        return super.indexOf(item);
    }
}