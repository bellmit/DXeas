package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ContractPaymentCollection extends AbstractObjectCollection 
{
    public ContractPaymentCollection()
    {
        super(ContractPaymentInfo.class);
    }
    public boolean add(ContractPaymentInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ContractPaymentCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ContractPaymentInfo item)
    {
        return removeObject(item);
    }
    public ContractPaymentInfo get(int index)
    {
        return(ContractPaymentInfo)getObject(index);
    }
    public ContractPaymentInfo get(Object key)
    {
        return(ContractPaymentInfo)getObject(key);
    }
    public void set(int index, ContractPaymentInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ContractPaymentInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ContractPaymentInfo item)
    {
        return super.indexOf(item);
    }
}