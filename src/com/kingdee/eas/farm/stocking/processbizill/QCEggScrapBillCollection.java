package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QCEggScrapBillCollection extends AbstractObjectCollection 
{
    public QCEggScrapBillCollection()
    {
        super(QCEggScrapBillInfo.class);
    }
    public boolean add(QCEggScrapBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QCEggScrapBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QCEggScrapBillInfo item)
    {
        return removeObject(item);
    }
    public QCEggScrapBillInfo get(int index)
    {
        return(QCEggScrapBillInfo)getObject(index);
    }
    public QCEggScrapBillInfo get(Object key)
    {
        return(QCEggScrapBillInfo)getObject(key);
    }
    public void set(int index, QCEggScrapBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QCEggScrapBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QCEggScrapBillInfo item)
    {
        return super.indexOf(item);
    }
}