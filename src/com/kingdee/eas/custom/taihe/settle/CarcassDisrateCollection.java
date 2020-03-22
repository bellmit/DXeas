package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarcassDisrateCollection extends AbstractObjectCollection 
{
    public CarcassDisrateCollection()
    {
        super(CarcassDisrateInfo.class);
    }
    public boolean add(CarcassDisrateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarcassDisrateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarcassDisrateInfo item)
    {
        return removeObject(item);
    }
    public CarcassDisrateInfo get(int index)
    {
        return(CarcassDisrateInfo)getObject(index);
    }
    public CarcassDisrateInfo get(Object key)
    {
        return(CarcassDisrateInfo)getObject(key);
    }
    public void set(int index, CarcassDisrateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarcassDisrateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarcassDisrateInfo item)
    {
        return super.indexOf(item);
    }
}