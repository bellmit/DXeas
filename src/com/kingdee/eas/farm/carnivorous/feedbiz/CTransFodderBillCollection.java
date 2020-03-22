package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CTransFodderBillCollection extends AbstractObjectCollection 
{
    public CTransFodderBillCollection()
    {
        super(CTransFodderBillInfo.class);
    }
    public boolean add(CTransFodderBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CTransFodderBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CTransFodderBillInfo item)
    {
        return removeObject(item);
    }
    public CTransFodderBillInfo get(int index)
    {
        return(CTransFodderBillInfo)getObject(index);
    }
    public CTransFodderBillInfo get(Object key)
    {
        return(CTransFodderBillInfo)getObject(key);
    }
    public void set(int index, CTransFodderBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CTransFodderBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CTransFodderBillInfo item)
    {
        return super.indexOf(item);
    }
}