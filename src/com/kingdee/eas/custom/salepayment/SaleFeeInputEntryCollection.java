package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleFeeInputEntryCollection extends AbstractObjectCollection 
{
    public SaleFeeInputEntryCollection()
    {
        super(SaleFeeInputEntryInfo.class);
    }
    public boolean add(SaleFeeInputEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleFeeInputEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleFeeInputEntryInfo item)
    {
        return removeObject(item);
    }
    public SaleFeeInputEntryInfo get(int index)
    {
        return(SaleFeeInputEntryInfo)getObject(index);
    }
    public SaleFeeInputEntryInfo get(Object key)
    {
        return(SaleFeeInputEntryInfo)getObject(key);
    }
    public void set(int index, SaleFeeInputEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleFeeInputEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleFeeInputEntryInfo item)
    {
        return super.indexOf(item);
    }
}