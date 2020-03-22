package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalaryVoucherPersonCollection extends AbstractObjectCollection 
{
    public SalaryVoucherPersonCollection()
    {
        super(SalaryVoucherPersonInfo.class);
    }
    public boolean add(SalaryVoucherPersonInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalaryVoucherPersonCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalaryVoucherPersonInfo item)
    {
        return removeObject(item);
    }
    public SalaryVoucherPersonInfo get(int index)
    {
        return(SalaryVoucherPersonInfo)getObject(index);
    }
    public SalaryVoucherPersonInfo get(Object key)
    {
        return(SalaryVoucherPersonInfo)getObject(key);
    }
    public void set(int index, SalaryVoucherPersonInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalaryVoucherPersonInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalaryVoucherPersonInfo item)
    {
        return super.indexOf(item);
    }
}