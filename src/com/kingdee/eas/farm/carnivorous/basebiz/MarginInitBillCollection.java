package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginInitBillCollection extends AbstractObjectCollection 
{
    public MarginInitBillCollection()
    {
        super(MarginInitBillInfo.class);
    }
    public boolean add(MarginInitBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginInitBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginInitBillInfo item)
    {
        return removeObject(item);
    }
    public MarginInitBillInfo get(int index)
    {
        return(MarginInitBillInfo)getObject(index);
    }
    public MarginInitBillInfo get(Object key)
    {
        return(MarginInitBillInfo)getObject(key);
    }
    public void set(int index, MarginInitBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginInitBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginInitBillInfo item)
    {
        return super.indexOf(item);
    }
}