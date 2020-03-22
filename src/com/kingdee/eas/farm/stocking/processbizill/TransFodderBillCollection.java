package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransFodderBillCollection extends AbstractObjectCollection 
{
    public TransFodderBillCollection()
    {
        super(TransFodderBillInfo.class);
    }
    public boolean add(TransFodderBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransFodderBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransFodderBillInfo item)
    {
        return removeObject(item);
    }
    public TransFodderBillInfo get(int index)
    {
        return(TransFodderBillInfo)getObject(index);
    }
    public TransFodderBillInfo get(Object key)
    {
        return(TransFodderBillInfo)getObject(key);
    }
    public void set(int index, TransFodderBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransFodderBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransFodderBillInfo item)
    {
        return super.indexOf(item);
    }
}