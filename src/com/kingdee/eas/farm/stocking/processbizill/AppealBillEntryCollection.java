package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AppealBillEntryCollection extends AbstractObjectCollection 
{
    public AppealBillEntryCollection()
    {
        super(AppealBillEntryInfo.class);
    }
    public boolean add(AppealBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AppealBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AppealBillEntryInfo item)
    {
        return removeObject(item);
    }
    public AppealBillEntryInfo get(int index)
    {
        return(AppealBillEntryInfo)getObject(index);
    }
    public AppealBillEntryInfo get(Object key)
    {
        return(AppealBillEntryInfo)getObject(key);
    }
    public void set(int index, AppealBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AppealBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AppealBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}