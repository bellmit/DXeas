package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StapleSupplierCollection extends AbstractObjectCollection 
{
    public StapleSupplierCollection()
    {
        super(StapleSupplierInfo.class);
    }
    public boolean add(StapleSupplierInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StapleSupplierCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StapleSupplierInfo item)
    {
        return removeObject(item);
    }
    public StapleSupplierInfo get(int index)
    {
        return(StapleSupplierInfo)getObject(index);
    }
    public StapleSupplierInfo get(Object key)
    {
        return(StapleSupplierInfo)getObject(key);
    }
    public void set(int index, StapleSupplierInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StapleSupplierInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StapleSupplierInfo item)
    {
        return super.indexOf(item);
    }
}