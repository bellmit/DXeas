package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SzCountPositionSetOperatorEntryCollection extends AbstractObjectCollection 
{
    public SzCountPositionSetOperatorEntryCollection()
    {
        super(SzCountPositionSetOperatorEntryInfo.class);
    }
    public boolean add(SzCountPositionSetOperatorEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SzCountPositionSetOperatorEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SzCountPositionSetOperatorEntryInfo item)
    {
        return removeObject(item);
    }
    public SzCountPositionSetOperatorEntryInfo get(int index)
    {
        return(SzCountPositionSetOperatorEntryInfo)getObject(index);
    }
    public SzCountPositionSetOperatorEntryInfo get(Object key)
    {
        return(SzCountPositionSetOperatorEntryInfo)getObject(key);
    }
    public void set(int index, SzCountPositionSetOperatorEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SzCountPositionSetOperatorEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SzCountPositionSetOperatorEntryInfo item)
    {
        return super.indexOf(item);
    }
}