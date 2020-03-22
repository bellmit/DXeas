package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginBreedPolicyCollection extends AbstractObjectCollection 
{
    public MarginBreedPolicyCollection()
    {
        super(MarginBreedPolicyInfo.class);
    }
    public boolean add(MarginBreedPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginBreedPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginBreedPolicyInfo item)
    {
        return removeObject(item);
    }
    public MarginBreedPolicyInfo get(int index)
    {
        return(MarginBreedPolicyInfo)getObject(index);
    }
    public MarginBreedPolicyInfo get(Object key)
    {
        return(MarginBreedPolicyInfo)getObject(key);
    }
    public void set(int index, MarginBreedPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginBreedPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginBreedPolicyInfo item)
    {
        return super.indexOf(item);
    }
}