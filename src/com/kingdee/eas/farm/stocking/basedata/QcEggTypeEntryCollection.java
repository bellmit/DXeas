package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QcEggTypeEntryCollection extends AbstractObjectCollection 
{
    public QcEggTypeEntryCollection()
    {
        super(QcEggTypeEntryInfo.class);
    }
    public boolean add(QcEggTypeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QcEggTypeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QcEggTypeEntryInfo item)
    {
        return removeObject(item);
    }
    public QcEggTypeEntryInfo get(int index)
    {
        return(QcEggTypeEntryInfo)getObject(index);
    }
    public QcEggTypeEntryInfo get(Object key)
    {
        return(QcEggTypeEntryInfo)getObject(key);
    }
    public void set(int index, QcEggTypeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QcEggTypeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QcEggTypeEntryInfo item)
    {
        return super.indexOf(item);
    }
}