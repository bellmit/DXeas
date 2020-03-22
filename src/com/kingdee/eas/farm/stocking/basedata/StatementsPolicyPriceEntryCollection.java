package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsPolicyPriceEntryCollection extends AbstractObjectCollection 
{
    public StatementsPolicyPriceEntryCollection()
    {
        super(StatementsPolicyPriceEntryInfo.class);
    }
    public boolean add(StatementsPolicyPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsPolicyPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsPolicyPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public StatementsPolicyPriceEntryInfo get(int index)
    {
        return(StatementsPolicyPriceEntryInfo)getObject(index);
    }
    public StatementsPolicyPriceEntryInfo get(Object key)
    {
        return(StatementsPolicyPriceEntryInfo)getObject(key);
    }
    public void set(int index, StatementsPolicyPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsPolicyPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsPolicyPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}