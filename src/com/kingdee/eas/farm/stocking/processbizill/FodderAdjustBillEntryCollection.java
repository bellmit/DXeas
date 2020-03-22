package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderAdjustBillEntryCollection extends AbstractObjectCollection 
{
    public FodderAdjustBillEntryCollection()
    {
        super(FodderAdjustBillEntryInfo.class);
    }
    public boolean add(FodderAdjustBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderAdjustBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderAdjustBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FodderAdjustBillEntryInfo get(int index)
    {
        return(FodderAdjustBillEntryInfo)getObject(index);
    }
    public FodderAdjustBillEntryInfo get(Object key)
    {
        return(FodderAdjustBillEntryInfo)getObject(key);
    }
    public void set(int index, FodderAdjustBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderAdjustBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderAdjustBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}