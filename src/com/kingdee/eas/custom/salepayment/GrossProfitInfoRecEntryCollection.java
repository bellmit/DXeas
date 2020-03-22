package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class GrossProfitInfoRecEntryCollection extends AbstractObjectCollection 
{
    public GrossProfitInfoRecEntryCollection()
    {
        super(GrossProfitInfoRecEntryInfo.class);
    }
    public boolean add(GrossProfitInfoRecEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(GrossProfitInfoRecEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(GrossProfitInfoRecEntryInfo item)
    {
        return removeObject(item);
    }
    public GrossProfitInfoRecEntryInfo get(int index)
    {
        return(GrossProfitInfoRecEntryInfo)getObject(index);
    }
    public GrossProfitInfoRecEntryInfo get(Object key)
    {
        return(GrossProfitInfoRecEntryInfo)getObject(key);
    }
    public void set(int index, GrossProfitInfoRecEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(GrossProfitInfoRecEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(GrossProfitInfoRecEntryInfo item)
    {
        return super.indexOf(item);
    }
}