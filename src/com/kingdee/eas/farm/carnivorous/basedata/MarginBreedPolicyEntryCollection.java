package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginBreedPolicyEntryCollection extends AbstractObjectCollection 
{
    public MarginBreedPolicyEntryCollection()
    {
        super(MarginBreedPolicyEntryInfo.class);
    }
    public boolean add(MarginBreedPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginBreedPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginBreedPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public MarginBreedPolicyEntryInfo get(int index)
    {
        return(MarginBreedPolicyEntryInfo)getObject(index);
    }
    public MarginBreedPolicyEntryInfo get(Object key)
    {
        return(MarginBreedPolicyEntryInfo)getObject(key);
    }
    public void set(int index, MarginBreedPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginBreedPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginBreedPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}