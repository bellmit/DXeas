package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlementItemMaterialEntryCollection extends AbstractObjectCollection 
{
    public SettlementItemMaterialEntryCollection()
    {
        super(SettlementItemMaterialEntryInfo.class);
    }
    public boolean add(SettlementItemMaterialEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlementItemMaterialEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlementItemMaterialEntryInfo item)
    {
        return removeObject(item);
    }
    public SettlementItemMaterialEntryInfo get(int index)
    {
        return(SettlementItemMaterialEntryInfo)getObject(index);
    }
    public SettlementItemMaterialEntryInfo get(Object key)
    {
        return(SettlementItemMaterialEntryInfo)getObject(key);
    }
    public void set(int index, SettlementItemMaterialEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlementItemMaterialEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlementItemMaterialEntryInfo item)
    {
        return super.indexOf(item);
    }
}