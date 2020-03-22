package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CompanyMonthFeeCollection extends AbstractObjectCollection 
{
    public CompanyMonthFeeCollection()
    {
        super(CompanyMonthFeeInfo.class);
    }
    public boolean add(CompanyMonthFeeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CompanyMonthFeeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CompanyMonthFeeInfo item)
    {
        return removeObject(item);
    }
    public CompanyMonthFeeInfo get(int index)
    {
        return(CompanyMonthFeeInfo)getObject(index);
    }
    public CompanyMonthFeeInfo get(Object key)
    {
        return(CompanyMonthFeeInfo)getObject(key);
    }
    public void set(int index, CompanyMonthFeeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CompanyMonthFeeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CompanyMonthFeeInfo item)
    {
        return super.indexOf(item);
    }
}