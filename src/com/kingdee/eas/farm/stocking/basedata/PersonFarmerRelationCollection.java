package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonFarmerRelationCollection extends AbstractObjectCollection 
{
    public PersonFarmerRelationCollection()
    {
        super(PersonFarmerRelationInfo.class);
    }
    public boolean add(PersonFarmerRelationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonFarmerRelationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonFarmerRelationInfo item)
    {
        return removeObject(item);
    }
    public PersonFarmerRelationInfo get(int index)
    {
        return(PersonFarmerRelationInfo)getObject(index);
    }
    public PersonFarmerRelationInfo get(Object key)
    {
        return(PersonFarmerRelationInfo)getObject(key);
    }
    public void set(int index, PersonFarmerRelationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonFarmerRelationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonFarmerRelationInfo item)
    {
        return super.indexOf(item);
    }
}