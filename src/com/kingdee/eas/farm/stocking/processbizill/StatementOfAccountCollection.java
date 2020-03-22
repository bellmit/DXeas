package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementOfAccountCollection extends AbstractObjectCollection 
{
    public StatementOfAccountCollection()
    {
        super(StatementOfAccountInfo.class);
    }
    public boolean add(StatementOfAccountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementOfAccountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementOfAccountInfo item)
    {
        return removeObject(item);
    }
    public StatementOfAccountInfo get(int index)
    {
        return(StatementOfAccountInfo)getObject(index);
    }
    public StatementOfAccountInfo get(Object key)
    {
        return(StatementOfAccountInfo)getObject(key);
    }
    public void set(int index, StatementOfAccountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementOfAccountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementOfAccountInfo item)
    {
        return super.indexOf(item);
    }
}