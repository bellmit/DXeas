package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsBillHandEntryCollection extends AbstractObjectCollection 
{
    public StatementsBillHandEntryCollection()
    {
        super(StatementsBillHandEntryInfo.class);
    }
    public boolean add(StatementsBillHandEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsBillHandEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsBillHandEntryInfo item)
    {
        return removeObject(item);
    }
    public StatementsBillHandEntryInfo get(int index)
    {
        return(StatementsBillHandEntryInfo)getObject(index);
    }
    public StatementsBillHandEntryInfo get(Object key)
    {
        return(StatementsBillHandEntryInfo)getObject(key);
    }
    public void set(int index, StatementsBillHandEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsBillHandEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsBillHandEntryInfo item)
    {
        return super.indexOf(item);
    }
}