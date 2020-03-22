package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsPolicyCollection extends AbstractObjectCollection 
{
    public StatementsPolicyCollection()
    {
        super(StatementsPolicyInfo.class);
    }
    public boolean add(StatementsPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsPolicyInfo item)
    {
        return removeObject(item);
    }
    public StatementsPolicyInfo get(int index)
    {
        return(StatementsPolicyInfo)getObject(index);
    }
    public StatementsPolicyInfo get(Object key)
    {
        return(StatementsPolicyInfo)getObject(key);
    }
    public void set(int index, StatementsPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsPolicyInfo item)
    {
        return super.indexOf(item);
    }
}