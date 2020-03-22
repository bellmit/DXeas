package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleDataBaseEntryCollection extends AbstractObjectCollection 
{
    public SettleDataBaseEntryCollection()
    {
        super(SettleDataBaseEntryInfo.class);
    }
    public boolean add(SettleDataBaseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleDataBaseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleDataBaseEntryInfo item)
    {
        return removeObject(item);
    }
    public SettleDataBaseEntryInfo get(int index)
    {
        return(SettleDataBaseEntryInfo)getObject(index);
    }
    public SettleDataBaseEntryInfo get(Object key)
    {
        return(SettleDataBaseEntryInfo)getObject(key);
    }
    public void set(int index, SettleDataBaseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleDataBaseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleDataBaseEntryInfo item)
    {
        return super.indexOf(item);
    }
}