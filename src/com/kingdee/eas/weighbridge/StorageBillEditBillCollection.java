package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StorageBillEditBillCollection extends AbstractObjectCollection 
{
    public StorageBillEditBillCollection()
    {
        super(StorageBillEditBillInfo.class);
    }
    public boolean add(StorageBillEditBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StorageBillEditBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StorageBillEditBillInfo item)
    {
        return removeObject(item);
    }
    public StorageBillEditBillInfo get(int index)
    {
        return(StorageBillEditBillInfo)getObject(index);
    }
    public StorageBillEditBillInfo get(Object key)
    {
        return(StorageBillEditBillInfo)getObject(key);
    }
    public void set(int index, StorageBillEditBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StorageBillEditBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StorageBillEditBillInfo item)
    {
        return super.indexOf(item);
    }
}