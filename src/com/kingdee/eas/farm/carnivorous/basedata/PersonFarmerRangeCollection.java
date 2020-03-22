package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonFarmerRangeCollection extends AbstractObjectCollection 
{
    public PersonFarmerRangeCollection()
    {
        super(PersonFarmerRangeInfo.class);
    }
    public boolean add(PersonFarmerRangeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonFarmerRangeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonFarmerRangeInfo item)
    {
        return removeObject(item);
    }
    public PersonFarmerRangeInfo get(int index)
    {
        return(PersonFarmerRangeInfo)getObject(index);
    }
    public PersonFarmerRangeInfo get(Object key)
    {
        return(PersonFarmerRangeInfo)getObject(key);
    }
    public void set(int index, PersonFarmerRangeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonFarmerRangeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonFarmerRangeInfo item)
    {
        return super.indexOf(item);
    }
}