package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedBillCollection extends AbstractObjectCollection 
{
    public BreedSeedBillCollection()
    {
        super(BreedSeedBillInfo.class);
    }
    public boolean add(BreedSeedBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedBillInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedBillInfo get(int index)
    {
        return(BreedSeedBillInfo)getObject(index);
    }
    public BreedSeedBillInfo get(Object key)
    {
        return(BreedSeedBillInfo)getObject(key);
    }
    public void set(int index, BreedSeedBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedBillInfo item)
    {
        return super.indexOf(item);
    }
}