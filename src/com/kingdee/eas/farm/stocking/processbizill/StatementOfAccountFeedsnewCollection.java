package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementOfAccountFeedsnewCollection extends AbstractObjectCollection 
{
    public StatementOfAccountFeedsnewCollection()
    {
        super(StatementOfAccountFeedsnewInfo.class);
    }
    public boolean add(StatementOfAccountFeedsnewInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementOfAccountFeedsnewCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementOfAccountFeedsnewInfo item)
    {
        return removeObject(item);
    }
    public StatementOfAccountFeedsnewInfo get(int index)
    {
        return(StatementOfAccountFeedsnewInfo)getObject(index);
    }
    public StatementOfAccountFeedsnewInfo get(Object key)
    {
        return(StatementOfAccountFeedsnewInfo)getObject(key);
    }
    public void set(int index, StatementOfAccountFeedsnewInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementOfAccountFeedsnewInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementOfAccountFeedsnewInfo item)
    {
        return super.indexOf(item);
    }
}