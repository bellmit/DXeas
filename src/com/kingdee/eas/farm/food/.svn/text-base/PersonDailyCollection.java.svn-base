package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonDailyCollection extends AbstractObjectCollection 
{
    public PersonDailyCollection()
    {
        super(PersonDailyInfo.class);
    }
    public boolean add(PersonDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonDailyInfo item)
    {
        return removeObject(item);
    }
    public PersonDailyInfo get(int index)
    {
        return(PersonDailyInfo)getObject(index);
    }
    public PersonDailyInfo get(Object key)
    {
        return(PersonDailyInfo)getObject(key);
    }
    public void set(int index, PersonDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonDailyInfo item)
    {
        return super.indexOf(item);
    }
}