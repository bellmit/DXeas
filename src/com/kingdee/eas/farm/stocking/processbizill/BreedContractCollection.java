package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedContractCollection extends AbstractObjectCollection 
{
    public BreedContractCollection()
    {
        super(BreedContractInfo.class);
    }
    public boolean add(BreedContractInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedContractCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedContractInfo item)
    {
        return removeObject(item);
    }
    public BreedContractInfo get(int index)
    {
        return(BreedContractInfo)getObject(index);
    }
    public BreedContractInfo get(Object key)
    {
        return(BreedContractInfo)getObject(key);
    }
    public void set(int index, BreedContractInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedContractInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedContractInfo item)
    {
        return super.indexOf(item);
    }
}