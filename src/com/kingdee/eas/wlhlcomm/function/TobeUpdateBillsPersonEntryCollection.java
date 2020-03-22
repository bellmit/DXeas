package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TobeUpdateBillsPersonEntryCollection extends AbstractObjectCollection 
{
    public TobeUpdateBillsPersonEntryCollection()
    {
        super(TobeUpdateBillsPersonEntryInfo.class);
    }
    public boolean add(TobeUpdateBillsPersonEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TobeUpdateBillsPersonEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TobeUpdateBillsPersonEntryInfo item)
    {
        return removeObject(item);
    }
    public TobeUpdateBillsPersonEntryInfo get(int index)
    {
        return(TobeUpdateBillsPersonEntryInfo)getObject(index);
    }
    public TobeUpdateBillsPersonEntryInfo get(Object key)
    {
        return(TobeUpdateBillsPersonEntryInfo)getObject(key);
    }
    public void set(int index, TobeUpdateBillsPersonEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TobeUpdateBillsPersonEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TobeUpdateBillsPersonEntryInfo item)
    {
        return super.indexOf(item);
    }
}