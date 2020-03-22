package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProcesstechPicentryCollection extends AbstractObjectCollection 
{
    public ProcesstechPicentryCollection()
    {
        super(ProcesstechPicentryInfo.class);
    }
    public boolean add(ProcesstechPicentryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProcesstechPicentryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProcesstechPicentryInfo item)
    {
        return removeObject(item);
    }
    public ProcesstechPicentryInfo get(int index)
    {
        return(ProcesstechPicentryInfo)getObject(index);
    }
    public ProcesstechPicentryInfo get(Object key)
    {
        return(ProcesstechPicentryInfo)getObject(key);
    }
    public void set(int index, ProcesstechPicentryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProcesstechPicentryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProcesstechPicentryInfo item)
    {
        return super.indexOf(item);
    }
}