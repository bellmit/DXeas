package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementOfAccountFeedCollection extends AbstractObjectCollection 
{
    public StatementOfAccountFeedCollection()
    {
        super(StatementOfAccountFeedInfo.class);
    }
    public boolean add(StatementOfAccountFeedInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementOfAccountFeedCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementOfAccountFeedInfo item)
    {
        return removeObject(item);
    }
    public StatementOfAccountFeedInfo get(int index)
    {
        return(StatementOfAccountFeedInfo)getObject(index);
    }
    public StatementOfAccountFeedInfo get(Object key)
    {
        return(StatementOfAccountFeedInfo)getObject(key);
    }
    public void set(int index, StatementOfAccountFeedInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementOfAccountFeedInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementOfAccountFeedInfo item)
    {
        return super.indexOf(item);
    }
}