package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AreaTargetSalerEntryCollection extends AbstractObjectCollection 
{
    public AreaTargetSalerEntryCollection()
    {
        super(AreaTargetSalerEntryInfo.class);
    }
    public boolean add(AreaTargetSalerEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AreaTargetSalerEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AreaTargetSalerEntryInfo item)
    {
        return removeObject(item);
    }
    public AreaTargetSalerEntryInfo get(int index)
    {
        return(AreaTargetSalerEntryInfo)getObject(index);
    }
    public AreaTargetSalerEntryInfo get(Object key)
    {
        return(AreaTargetSalerEntryInfo)getObject(key);
    }
    public void set(int index, AreaTargetSalerEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AreaTargetSalerEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AreaTargetSalerEntryInfo item)
    {
        return super.indexOf(item);
    }
}