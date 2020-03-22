package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OtherReceptionBillCollection extends AbstractObjectCollection 
{
    public OtherReceptionBillCollection()
    {
        super(OtherReceptionBillInfo.class);
    }
    public boolean add(OtherReceptionBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OtherReceptionBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OtherReceptionBillInfo item)
    {
        return removeObject(item);
    }
    public OtherReceptionBillInfo get(int index)
    {
        return(OtherReceptionBillInfo)getObject(index);
    }
    public OtherReceptionBillInfo get(Object key)
    {
        return(OtherReceptionBillInfo)getObject(key);
    }
    public void set(int index, OtherReceptionBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OtherReceptionBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OtherReceptionBillInfo item)
    {
        return super.indexOf(item);
    }
}