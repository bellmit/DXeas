package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCBreedPlanCollection extends AbstractObjectCollection 
{
    public CCBreedPlanCollection()
    {
        super(CCBreedPlanInfo.class);
    }
    public boolean add(CCBreedPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCBreedPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCBreedPlanInfo item)
    {
        return removeObject(item);
    }
    public CCBreedPlanInfo get(int index)
    {
        return(CCBreedPlanInfo)getObject(index);
    }
    public CCBreedPlanInfo get(Object key)
    {
        return(CCBreedPlanInfo)getObject(key);
    }
    public void set(int index, CCBreedPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCBreedPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCBreedPlanInfo item)
    {
        return super.indexOf(item);
    }
}