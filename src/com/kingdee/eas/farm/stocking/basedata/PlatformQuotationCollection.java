package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PlatformQuotationCollection extends AbstractObjectCollection 
{
    public PlatformQuotationCollection()
    {
        super(PlatformQuotationInfo.class);
    }
    public boolean add(PlatformQuotationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PlatformQuotationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PlatformQuotationInfo item)
    {
        return removeObject(item);
    }
    public PlatformQuotationInfo get(int index)
    {
        return(PlatformQuotationInfo)getObject(index);
    }
    public PlatformQuotationInfo get(Object key)
    {
        return(PlatformQuotationInfo)getObject(key);
    }
    public void set(int index, PlatformQuotationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PlatformQuotationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PlatformQuotationInfo item)
    {
        return super.indexOf(item);
    }
}