package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonFarmerRangeTreeCollection extends AbstractObjectCollection 
{
    public PersonFarmerRangeTreeCollection()
    {
        super(PersonFarmerRangeTreeInfo.class);
    }
    public boolean add(PersonFarmerRangeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonFarmerRangeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonFarmerRangeTreeInfo item)
    {
        return removeObject(item);
    }
    public PersonFarmerRangeTreeInfo get(int index)
    {
        return(PersonFarmerRangeTreeInfo)getObject(index);
    }
    public PersonFarmerRangeTreeInfo get(Object key)
    {
        return(PersonFarmerRangeTreeInfo)getObject(key);
    }
    public void set(int index, PersonFarmerRangeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonFarmerRangeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonFarmerRangeTreeInfo item)
    {
        return super.indexOf(item);
    }
}