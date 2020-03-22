package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedFodderPlanCollection extends AbstractObjectCollection 
{
    public BreedFodderPlanCollection()
    {
        super(BreedFodderPlanInfo.class);
    }
    public boolean add(BreedFodderPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedFodderPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedFodderPlanInfo item)
    {
        return removeObject(item);
    }
    public BreedFodderPlanInfo get(int index)
    {
        return(BreedFodderPlanInfo)getObject(index);
    }
    public BreedFodderPlanInfo get(Object key)
    {
        return(BreedFodderPlanInfo)getObject(key);
    }
    public void set(int index, BreedFodderPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedFodderPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedFodderPlanInfo item)
    {
        return super.indexOf(item);
    }
}