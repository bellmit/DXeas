package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalaryVoucherEntryAssistActItemCollection extends AbstractObjectCollection 
{
    public SalaryVoucherEntryAssistActItemCollection()
    {
        super(SalaryVoucherEntryAssistActItemInfo.class);
    }
    public boolean add(SalaryVoucherEntryAssistActItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalaryVoucherEntryAssistActItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalaryVoucherEntryAssistActItemInfo item)
    {
        return removeObject(item);
    }
    public SalaryVoucherEntryAssistActItemInfo get(int index)
    {
        return(SalaryVoucherEntryAssistActItemInfo)getObject(index);
    }
    public SalaryVoucherEntryAssistActItemInfo get(Object key)
    {
        return(SalaryVoucherEntryAssistActItemInfo)getObject(key);
    }
    public void set(int index, SalaryVoucherEntryAssistActItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalaryVoucherEntryAssistActItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalaryVoucherEntryAssistActItemInfo item)
    {
        return super.indexOf(item);
    }
}