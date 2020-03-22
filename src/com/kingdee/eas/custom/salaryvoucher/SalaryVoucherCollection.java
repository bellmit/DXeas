package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalaryVoucherCollection extends AbstractObjectCollection 
{
    public SalaryVoucherCollection()
    {
        super(SalaryVoucherInfo.class);
    }
    public boolean add(SalaryVoucherInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalaryVoucherCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalaryVoucherInfo item)
    {
        return removeObject(item);
    }
    public SalaryVoucherInfo get(int index)
    {
        return(SalaryVoucherInfo)getObject(index);
    }
    public SalaryVoucherInfo get(Object key)
    {
        return(SalaryVoucherInfo)getObject(key);
    }
    public void set(int index, SalaryVoucherInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalaryVoucherInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalaryVoucherInfo item)
    {
        return super.indexOf(item);
    }
}