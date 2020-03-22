package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DayrateFeeItemTreeCollection extends AbstractObjectCollection 
{
    public DayrateFeeItemTreeCollection()
    {
        super(DayrateFeeItemTreeInfo.class);
    }
    public boolean add(DayrateFeeItemTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DayrateFeeItemTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DayrateFeeItemTreeInfo item)
    {
        return removeObject(item);
    }
    public DayrateFeeItemTreeInfo get(int index)
    {
        return(DayrateFeeItemTreeInfo)getObject(index);
    }
    public DayrateFeeItemTreeInfo get(Object key)
    {
        return(DayrateFeeItemTreeInfo)getObject(key);
    }
    public void set(int index, DayrateFeeItemTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DayrateFeeItemTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DayrateFeeItemTreeInfo item)
    {
        return super.indexOf(item);
    }
}