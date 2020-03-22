package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CompanyOwnBreedSetCollection extends AbstractObjectCollection 
{
    public CompanyOwnBreedSetCollection()
    {
        super(CompanyOwnBreedSetInfo.class);
    }
    public boolean add(CompanyOwnBreedSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CompanyOwnBreedSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CompanyOwnBreedSetInfo item)
    {
        return removeObject(item);
    }
    public CompanyOwnBreedSetInfo get(int index)
    {
        return(CompanyOwnBreedSetInfo)getObject(index);
    }
    public CompanyOwnBreedSetInfo get(Object key)
    {
        return(CompanyOwnBreedSetInfo)getObject(key);
    }
    public void set(int index, CompanyOwnBreedSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CompanyOwnBreedSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CompanyOwnBreedSetInfo item)
    {
        return super.indexOf(item);
    }
}