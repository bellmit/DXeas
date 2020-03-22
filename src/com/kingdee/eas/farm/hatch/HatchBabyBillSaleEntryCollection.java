package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBabyBillSaleEntryCollection extends AbstractObjectCollection 
{
    public HatchBabyBillSaleEntryCollection()
    {
        super(HatchBabyBillSaleEntryInfo.class);
    }
    public boolean add(HatchBabyBillSaleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBabyBillSaleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBabyBillSaleEntryInfo item)
    {
        return removeObject(item);
    }
    public HatchBabyBillSaleEntryInfo get(int index)
    {
        return(HatchBabyBillSaleEntryInfo)getObject(index);
    }
    public HatchBabyBillSaleEntryInfo get(Object key)
    {
        return(HatchBabyBillSaleEntryInfo)getObject(key);
    }
    public void set(int index, HatchBabyBillSaleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBabyBillSaleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBabyBillSaleEntryInfo item)
    {
        return super.indexOf(item);
    }
}