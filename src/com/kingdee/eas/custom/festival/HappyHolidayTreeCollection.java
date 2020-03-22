package com.kingdee.eas.custom.festival;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HappyHolidayTreeCollection extends AbstractObjectCollection 
{
    public HappyHolidayTreeCollection()
    {
        super(HappyHolidayTreeInfo.class);
    }
    public boolean add(HappyHolidayTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HappyHolidayTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HappyHolidayTreeInfo item)
    {
        return removeObject(item);
    }
    public HappyHolidayTreeInfo get(int index)
    {
        return(HappyHolidayTreeInfo)getObject(index);
    }
    public HappyHolidayTreeInfo get(Object key)
    {
        return(HappyHolidayTreeInfo)getObject(key);
    }
    public void set(int index, HappyHolidayTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HappyHolidayTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HappyHolidayTreeInfo item)
    {
        return super.indexOf(item);
    }
}