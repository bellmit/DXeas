package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerBorrowCollection extends AbstractObjectCollection 
{
    public FarmerBorrowCollection()
    {
        super(FarmerBorrowInfo.class);
    }
    public boolean add(FarmerBorrowInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerBorrowCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerBorrowInfo item)
    {
        return removeObject(item);
    }
    public FarmerBorrowInfo get(int index)
    {
        return(FarmerBorrowInfo)getObject(index);
    }
    public FarmerBorrowInfo get(Object key)
    {
        return(FarmerBorrowInfo)getObject(key);
    }
    public void set(int index, FarmerBorrowInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerBorrowInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerBorrowInfo item)
    {
        return super.indexOf(item);
    }
}