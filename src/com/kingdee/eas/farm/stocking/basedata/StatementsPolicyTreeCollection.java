package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsPolicyTreeCollection extends AbstractObjectCollection 
{
    public StatementsPolicyTreeCollection()
    {
        super(StatementsPolicyTreeInfo.class);
    }
    public boolean add(StatementsPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public StatementsPolicyTreeInfo get(int index)
    {
        return(StatementsPolicyTreeInfo)getObject(index);
    }
    public StatementsPolicyTreeInfo get(Object key)
    {
        return(StatementsPolicyTreeInfo)getObject(key);
    }
    public void set(int index, StatementsPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}