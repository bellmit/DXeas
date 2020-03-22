package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarcassRateDisRateEntryCollection extends AbstractObjectCollection 
{
    public CarcassRateDisRateEntryCollection()
    {
        super(CarcassRateDisRateEntryInfo.class);
    }
    public boolean add(CarcassRateDisRateEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarcassRateDisRateEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarcassRateDisRateEntryInfo item)
    {
        return removeObject(item);
    }
    public CarcassRateDisRateEntryInfo get(int index)
    {
        return(CarcassRateDisRateEntryInfo)getObject(index);
    }
    public CarcassRateDisRateEntryInfo get(Object key)
    {
        return(CarcassRateDisRateEntryInfo)getObject(key);
    }
    public void set(int index, CarcassRateDisRateEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarcassRateDisRateEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarcassRateDisRateEntryInfo item)
    {
        return super.indexOf(item);
    }
}