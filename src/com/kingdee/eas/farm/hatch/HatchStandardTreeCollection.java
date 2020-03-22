package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchStandardTreeCollection extends AbstractObjectCollection 
{
    public HatchStandardTreeCollection()
    {
        super(HatchStandardTreeInfo.class);
    }
    public boolean add(HatchStandardTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchStandardTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchStandardTreeInfo item)
    {
        return removeObject(item);
    }
    public HatchStandardTreeInfo get(int index)
    {
        return(HatchStandardTreeInfo)getObject(index);
    }
    public HatchStandardTreeInfo get(Object key)
    {
        return(HatchStandardTreeInfo)getObject(key);
    }
    public void set(int index, HatchStandardTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchStandardTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchStandardTreeInfo item)
    {
        return super.indexOf(item);
    }
}