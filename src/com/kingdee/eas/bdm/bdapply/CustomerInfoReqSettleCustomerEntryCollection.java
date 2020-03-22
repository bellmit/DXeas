package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerInfoReqSettleCustomerEntryCollection extends AbstractObjectCollection 
{
    public CustomerInfoReqSettleCustomerEntryCollection()
    {
        super(CustomerInfoReqSettleCustomerEntryInfo.class);
    }
    public boolean add(CustomerInfoReqSettleCustomerEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerInfoReqSettleCustomerEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerInfoReqSettleCustomerEntryInfo item)
    {
        return removeObject(item);
    }
    public CustomerInfoReqSettleCustomerEntryInfo get(int index)
    {
        return(CustomerInfoReqSettleCustomerEntryInfo)getObject(index);
    }
    public CustomerInfoReqSettleCustomerEntryInfo get(Object key)
    {
        return(CustomerInfoReqSettleCustomerEntryInfo)getObject(key);
    }
    public void set(int index, CustomerInfoReqSettleCustomerEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerInfoReqSettleCustomerEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerInfoReqSettleCustomerEntryInfo item)
    {
        return super.indexOf(item);
    }
}