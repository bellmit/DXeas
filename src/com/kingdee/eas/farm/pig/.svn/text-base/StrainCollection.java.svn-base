package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StrainCollection extends AbstractObjectCollection 
{
    public StrainCollection()
    {
        super(StrainInfo.class);
    }
    public boolean add(StrainInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StrainCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StrainInfo item)
    {
        return removeObject(item);
    }
    public StrainInfo get(int index)
    {
        return(StrainInfo)getObject(index);
    }
    public StrainInfo get(Object key)
    {
        return(StrainInfo)getObject(key);
    }
    public void set(int index, StrainInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StrainInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StrainInfo item)
    {
        return super.indexOf(item);
    }
}