package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalaryVoucherEntryCmpItemCollection extends AbstractObjectCollection 
{
    public SalaryVoucherEntryCmpItemCollection()
    {
        super(SalaryVoucherEntryCmpItemInfo.class);
    }
    public boolean add(SalaryVoucherEntryCmpItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalaryVoucherEntryCmpItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalaryVoucherEntryCmpItemInfo item)
    {
        return removeObject(item);
    }
    public SalaryVoucherEntryCmpItemInfo get(int index)
    {
        return(SalaryVoucherEntryCmpItemInfo)getObject(index);
    }
    public SalaryVoucherEntryCmpItemInfo get(Object key)
    {
        return(SalaryVoucherEntryCmpItemInfo)getObject(key);
    }
    public void set(int index, SalaryVoucherEntryCmpItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalaryVoucherEntryCmpItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalaryVoucherEntryCmpItemInfo item)
    {
        return super.indexOf(item);
    }
}