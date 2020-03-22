package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderReceiveBillCollection extends AbstractObjectCollection 
{
    public FodderReceiveBillCollection()
    {
        super(FodderReceiveBillInfo.class);
    }
    public boolean add(FodderReceiveBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderReceiveBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderReceiveBillInfo item)
    {
        return removeObject(item);
    }
    public FodderReceiveBillInfo get(int index)
    {
        return(FodderReceiveBillInfo)getObject(index);
    }
    public FodderReceiveBillInfo get(Object key)
    {
        return(FodderReceiveBillInfo)getObject(key);
    }
    public void set(int index, FodderReceiveBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderReceiveBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderReceiveBillInfo item)
    {
        return super.indexOf(item);
    }
}