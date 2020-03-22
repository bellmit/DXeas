package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DayrateFeeItemEntryCollection extends AbstractObjectCollection 
{
    public DayrateFeeItemEntryCollection()
    {
        super(DayrateFeeItemEntryInfo.class);
    }
    public boolean add(DayrateFeeItemEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DayrateFeeItemEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DayrateFeeItemEntryInfo item)
    {
        return removeObject(item);
    }
    public DayrateFeeItemEntryInfo get(int index)
    {
        return(DayrateFeeItemEntryInfo)getObject(index);
    }
    public DayrateFeeItemEntryInfo get(Object key)
    {
        return(DayrateFeeItemEntryInfo)getObject(key);
    }
    public void set(int index, DayrateFeeItemEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DayrateFeeItemEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DayrateFeeItemEntryInfo item)
    {
        return super.indexOf(item);
    }
}