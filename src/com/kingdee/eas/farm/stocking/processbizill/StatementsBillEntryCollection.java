package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsBillEntryCollection extends AbstractObjectCollection 
{
    public StatementsBillEntryCollection()
    {
        super(StatementsBillEntryInfo.class);
    }
    public boolean add(StatementsBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsBillEntryInfo item)
    {
        return removeObject(item);
    }
    public StatementsBillEntryInfo get(int index)
    {
        return(StatementsBillEntryInfo)getObject(index);
    }
    public StatementsBillEntryInfo get(Object key)
    {
        return(StatementsBillEntryInfo)getObject(key);
    }
    public void set(int index, StatementsBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}