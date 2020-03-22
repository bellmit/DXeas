package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CSlaughterBillCollection extends AbstractObjectCollection 
{
    public CSlaughterBillCollection()
    {
        super(CSlaughterBillInfo.class);
    }
    public boolean add(CSlaughterBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CSlaughterBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CSlaughterBillInfo item)
    {
        return removeObject(item);
    }
    public CSlaughterBillInfo get(int index)
    {
        return(CSlaughterBillInfo)getObject(index);
    }
    public CSlaughterBillInfo get(Object key)
    {
        return(CSlaughterBillInfo)getObject(key);
    }
    public void set(int index, CSlaughterBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CSlaughterBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CSlaughterBillInfo item)
    {
        return super.indexOf(item);
    }
}