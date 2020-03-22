package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CandlingBillInputModelCollection extends AbstractObjectCollection 
{
    public CandlingBillInputModelCollection()
    {
        super(CandlingBillInputModelInfo.class);
    }
    public boolean add(CandlingBillInputModelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CandlingBillInputModelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CandlingBillInputModelInfo item)
    {
        return removeObject(item);
    }
    public CandlingBillInputModelInfo get(int index)
    {
        return(CandlingBillInputModelInfo)getObject(index);
    }
    public CandlingBillInputModelInfo get(Object key)
    {
        return(CandlingBillInputModelInfo)getObject(key);
    }
    public void set(int index, CandlingBillInputModelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CandlingBillInputModelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CandlingBillInputModelInfo item)
    {
        return super.indexOf(item);
    }
}