package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PreHouseWgtBillCollection extends AbstractObjectCollection 
{
    public PreHouseWgtBillCollection()
    {
        super(PreHouseWgtBillInfo.class);
    }
    public boolean add(PreHouseWgtBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PreHouseWgtBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PreHouseWgtBillInfo item)
    {
        return removeObject(item);
    }
    public PreHouseWgtBillInfo get(int index)
    {
        return(PreHouseWgtBillInfo)getObject(index);
    }
    public PreHouseWgtBillInfo get(Object key)
    {
        return(PreHouseWgtBillInfo)getObject(key);
    }
    public void set(int index, PreHouseWgtBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PreHouseWgtBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PreHouseWgtBillInfo item)
    {
        return super.indexOf(item);
    }
}