package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QualityawardticketEntryCollection extends AbstractObjectCollection 
{
    public QualityawardticketEntryCollection()
    {
        super(QualityawardticketEntryInfo.class);
    }
    public boolean add(QualityawardticketEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QualityawardticketEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QualityawardticketEntryInfo item)
    {
        return removeObject(item);
    }
    public QualityawardticketEntryInfo get(int index)
    {
        return(QualityawardticketEntryInfo)getObject(index);
    }
    public QualityawardticketEntryInfo get(Object key)
    {
        return(QualityawardticketEntryInfo)getObject(key);
    }
    public void set(int index, QualityawardticketEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QualityawardticketEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QualityawardticketEntryInfo item)
    {
        return super.indexOf(item);
    }
}