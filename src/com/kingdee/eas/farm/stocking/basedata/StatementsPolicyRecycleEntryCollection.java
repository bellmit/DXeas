package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsPolicyRecycleEntryCollection extends AbstractObjectCollection 
{
    public StatementsPolicyRecycleEntryCollection()
    {
        super(StatementsPolicyRecycleEntryInfo.class);
    }
    public boolean add(StatementsPolicyRecycleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsPolicyRecycleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsPolicyRecycleEntryInfo item)
    {
        return removeObject(item);
    }
    public StatementsPolicyRecycleEntryInfo get(int index)
    {
        return(StatementsPolicyRecycleEntryInfo)getObject(index);
    }
    public StatementsPolicyRecycleEntryInfo get(Object key)
    {
        return(StatementsPolicyRecycleEntryInfo)getObject(key);
    }
    public void set(int index, StatementsPolicyRecycleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsPolicyRecycleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsPolicyRecycleEntryInfo item)
    {
        return super.indexOf(item);
    }
}