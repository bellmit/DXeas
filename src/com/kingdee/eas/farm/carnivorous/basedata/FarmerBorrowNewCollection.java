package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerBorrowNewCollection extends AbstractObjectCollection 
{
    public FarmerBorrowNewCollection()
    {
        super(FarmerBorrowNewInfo.class);
    }
    public boolean add(FarmerBorrowNewInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerBorrowNewCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerBorrowNewInfo item)
    {
        return removeObject(item);
    }
    public FarmerBorrowNewInfo get(int index)
    {
        return(FarmerBorrowNewInfo)getObject(index);
    }
    public FarmerBorrowNewInfo get(Object key)
    {
        return(FarmerBorrowNewInfo)getObject(key);
    }
    public void set(int index, FarmerBorrowNewInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerBorrowNewInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerBorrowNewInfo item)
    {
        return super.indexOf(item);
    }
}