package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QcBillEntryCollection extends AbstractObjectCollection 
{
    public QcBillEntryCollection()
    {
        super(QcBillEntryInfo.class);
    }
    public boolean add(QcBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QcBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QcBillEntryInfo item)
    {
        return removeObject(item);
    }
    public QcBillEntryInfo get(int index)
    {
        return(QcBillEntryInfo)getObject(index);
    }
    public QcBillEntryInfo get(Object key)
    {
        return(QcBillEntryInfo)getObject(key);
    }
    public void set(int index, QcBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QcBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QcBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}