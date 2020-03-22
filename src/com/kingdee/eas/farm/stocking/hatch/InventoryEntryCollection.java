package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InventoryEntryCollection extends AbstractObjectCollection 
{
    public InventoryEntryCollection()
    {
        super(InventoryEntryInfo.class);
    }
    public boolean add(InventoryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InventoryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InventoryEntryInfo item)
    {
        return removeObject(item);
    }
    public InventoryEntryInfo get(int index)
    {
        return(InventoryEntryInfo)getObject(index);
    }
    public InventoryEntryInfo get(Object key)
    {
        return(InventoryEntryInfo)getObject(key);
    }
    public void set(int index, InventoryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InventoryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InventoryEntryInfo item)
    {
        return super.indexOf(item);
    }
}