package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CompanyMonthFeeEntryCollection extends AbstractObjectCollection 
{
    public CompanyMonthFeeEntryCollection()
    {
        super(CompanyMonthFeeEntryInfo.class);
    }
    public boolean add(CompanyMonthFeeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CompanyMonthFeeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CompanyMonthFeeEntryInfo item)
    {
        return removeObject(item);
    }
    public CompanyMonthFeeEntryInfo get(int index)
    {
        return(CompanyMonthFeeEntryInfo)getObject(index);
    }
    public CompanyMonthFeeEntryInfo get(Object key)
    {
        return(CompanyMonthFeeEntryInfo)getObject(key);
    }
    public void set(int index, CompanyMonthFeeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CompanyMonthFeeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CompanyMonthFeeEntryInfo item)
    {
        return super.indexOf(item);
    }
}