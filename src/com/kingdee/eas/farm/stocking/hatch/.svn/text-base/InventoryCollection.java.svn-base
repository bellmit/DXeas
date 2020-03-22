package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InventoryCollection extends AbstractObjectCollection 
{
    public InventoryCollection()
    {
        super(InventoryInfo.class);
    }
    public boolean add(InventoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InventoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InventoryInfo item)
    {
        return removeObject(item);
    }
    public InventoryInfo get(int index)
    {
        return(InventoryInfo)getObject(index);
    }
    public InventoryInfo get(Object key)
    {
        return(InventoryInfo)getObject(key);
    }
    public void set(int index, InventoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InventoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InventoryInfo item)
    {
        return super.indexOf(item);
    }
}