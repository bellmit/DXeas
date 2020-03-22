package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginBorrowPolicyCollection extends AbstractObjectCollection 
{
    public MarginBorrowPolicyCollection()
    {
        super(MarginBorrowPolicyInfo.class);
    }
    public boolean add(MarginBorrowPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginBorrowPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginBorrowPolicyInfo item)
    {
        return removeObject(item);
    }
    public MarginBorrowPolicyInfo get(int index)
    {
        return(MarginBorrowPolicyInfo)getObject(index);
    }
    public MarginBorrowPolicyInfo get(Object key)
    {
        return(MarginBorrowPolicyInfo)getObject(key);
    }
    public void set(int index, MarginBorrowPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginBorrowPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginBorrowPolicyInfo item)
    {
        return super.indexOf(item);
    }
}