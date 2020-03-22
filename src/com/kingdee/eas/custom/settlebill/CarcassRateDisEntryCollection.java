package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarcassRateDisEntryCollection extends AbstractObjectCollection 
{
    public CarcassRateDisEntryCollection()
    {
        super(CarcassRateDisEntryInfo.class);
    }
    public boolean add(CarcassRateDisEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarcassRateDisEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarcassRateDisEntryInfo item)
    {
        return removeObject(item);
    }
    public CarcassRateDisEntryInfo get(int index)
    {
        return(CarcassRateDisEntryInfo)getObject(index);
    }
    public CarcassRateDisEntryInfo get(Object key)
    {
        return(CarcassRateDisEntryInfo)getObject(key);
    }
    public void set(int index, CarcassRateDisEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarcassRateDisEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarcassRateDisEntryInfo item)
    {
        return super.indexOf(item);
    }
}