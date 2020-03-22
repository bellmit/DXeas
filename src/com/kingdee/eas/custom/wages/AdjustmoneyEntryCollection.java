package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AdjustmoneyEntryCollection extends AbstractObjectCollection 
{
    public AdjustmoneyEntryCollection()
    {
        super(AdjustmoneyEntryInfo.class);
    }
    public boolean add(AdjustmoneyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AdjustmoneyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AdjustmoneyEntryInfo item)
    {
        return removeObject(item);
    }
    public AdjustmoneyEntryInfo get(int index)
    {
        return(AdjustmoneyEntryInfo)getObject(index);
    }
    public AdjustmoneyEntryInfo get(Object key)
    {
        return(AdjustmoneyEntryInfo)getObject(key);
    }
    public void set(int index, AdjustmoneyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AdjustmoneyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AdjustmoneyEntryInfo item)
    {
        return super.indexOf(item);
    }
}