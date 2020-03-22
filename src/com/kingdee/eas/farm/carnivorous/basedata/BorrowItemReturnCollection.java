package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BorrowItemReturnCollection extends AbstractObjectCollection 
{
    public BorrowItemReturnCollection()
    {
        super(BorrowItemReturnInfo.class);
    }
    public boolean add(BorrowItemReturnInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BorrowItemReturnCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BorrowItemReturnInfo item)
    {
        return removeObject(item);
    }
    public BorrowItemReturnInfo get(int index)
    {
        return(BorrowItemReturnInfo)getObject(index);
    }
    public BorrowItemReturnInfo get(Object key)
    {
        return(BorrowItemReturnInfo)getObject(key);
    }
    public void set(int index, BorrowItemReturnInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BorrowItemReturnInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BorrowItemReturnInfo item)
    {
        return super.indexOf(item);
    }
}