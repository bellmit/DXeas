package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillCollection extends AbstractObjectCollection 
{
    public CKSettleBillCollection()
    {
        super(CKSettleBillInfo.class);
    }
    public boolean add(CKSettleBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillInfo get(int index)
    {
        return(CKSettleBillInfo)getObject(index);
    }
    public CKSettleBillInfo get(Object key)
    {
        return(CKSettleBillInfo)getObject(key);
    }
    public void set(int index, CKSettleBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillInfo item)
    {
        return super.indexOf(item);
    }
}