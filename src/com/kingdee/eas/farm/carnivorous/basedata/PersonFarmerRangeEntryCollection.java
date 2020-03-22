package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonFarmerRangeEntryCollection extends AbstractObjectCollection 
{
    public PersonFarmerRangeEntryCollection()
    {
        super(PersonFarmerRangeEntryInfo.class);
    }
    public boolean add(PersonFarmerRangeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonFarmerRangeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonFarmerRangeEntryInfo item)
    {
        return removeObject(item);
    }
    public PersonFarmerRangeEntryInfo get(int index)
    {
        return(PersonFarmerRangeEntryInfo)getObject(index);
    }
    public PersonFarmerRangeEntryInfo get(Object key)
    {
        return(PersonFarmerRangeEntryInfo)getObject(key);
    }
    public void set(int index, PersonFarmerRangeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonFarmerRangeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonFarmerRangeEntryInfo item)
    {
        return super.indexOf(item);
    }
}