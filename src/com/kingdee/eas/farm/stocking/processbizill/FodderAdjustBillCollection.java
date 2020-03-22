package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderAdjustBillCollection extends AbstractObjectCollection 
{
    public FodderAdjustBillCollection()
    {
        super(FodderAdjustBillInfo.class);
    }
    public boolean add(FodderAdjustBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderAdjustBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderAdjustBillInfo item)
    {
        return removeObject(item);
    }
    public FodderAdjustBillInfo get(int index)
    {
        return(FodderAdjustBillInfo)getObject(index);
    }
    public FodderAdjustBillInfo get(Object key)
    {
        return(FodderAdjustBillInfo)getObject(key);
    }
    public void set(int index, FodderAdjustBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderAdjustBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderAdjustBillInfo item)
    {
        return super.indexOf(item);
    }
}