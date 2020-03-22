package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BorrowItemReturnEntryCollection extends AbstractObjectCollection 
{
    public BorrowItemReturnEntryCollection()
    {
        super(BorrowItemReturnEntryInfo.class);
    }
    public boolean add(BorrowItemReturnEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BorrowItemReturnEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BorrowItemReturnEntryInfo item)
    {
        return removeObject(item);
    }
    public BorrowItemReturnEntryInfo get(int index)
    {
        return(BorrowItemReturnEntryInfo)getObject(index);
    }
    public BorrowItemReturnEntryInfo get(Object key)
    {
        return(BorrowItemReturnEntryInfo)getObject(key);
    }
    public void set(int index, BorrowItemReturnEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BorrowItemReturnEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BorrowItemReturnEntryInfo item)
    {
        return super.indexOf(item);
    }
}