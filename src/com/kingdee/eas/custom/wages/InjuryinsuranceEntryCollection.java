package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InjuryinsuranceEntryCollection extends AbstractObjectCollection 
{
    public InjuryinsuranceEntryCollection()
    {
        super(InjuryinsuranceEntryInfo.class);
    }
    public boolean add(InjuryinsuranceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InjuryinsuranceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InjuryinsuranceEntryInfo item)
    {
        return removeObject(item);
    }
    public InjuryinsuranceEntryInfo get(int index)
    {
        return(InjuryinsuranceEntryInfo)getObject(index);
    }
    public InjuryinsuranceEntryInfo get(Object key)
    {
        return(InjuryinsuranceEntryInfo)getObject(key);
    }
    public void set(int index, InjuryinsuranceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InjuryinsuranceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InjuryinsuranceEntryInfo item)
    {
        return super.indexOf(item);
    }
}