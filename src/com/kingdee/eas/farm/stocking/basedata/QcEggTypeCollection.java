package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QcEggTypeCollection extends AbstractObjectCollection 
{
    public QcEggTypeCollection()
    {
        super(QcEggTypeInfo.class);
    }
    public boolean add(QcEggTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QcEggTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QcEggTypeInfo item)
    {
        return removeObject(item);
    }
    public QcEggTypeInfo get(int index)
    {
        return(QcEggTypeInfo)getObject(index);
    }
    public QcEggTypeInfo get(Object key)
    {
        return(QcEggTypeInfo)getObject(key);
    }
    public void set(int index, QcEggTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QcEggTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QcEggTypeInfo item)
    {
        return super.indexOf(item);
    }
}