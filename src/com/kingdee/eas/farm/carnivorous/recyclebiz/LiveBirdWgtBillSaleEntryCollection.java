package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LiveBirdWgtBillSaleEntryCollection extends AbstractObjectCollection 
{
    public LiveBirdWgtBillSaleEntryCollection()
    {
        super(LiveBirdWgtBillSaleEntryInfo.class);
    }
    public boolean add(LiveBirdWgtBillSaleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LiveBirdWgtBillSaleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LiveBirdWgtBillSaleEntryInfo item)
    {
        return removeObject(item);
    }
    public LiveBirdWgtBillSaleEntryInfo get(int index)
    {
        return(LiveBirdWgtBillSaleEntryInfo)getObject(index);
    }
    public LiveBirdWgtBillSaleEntryInfo get(Object key)
    {
        return(LiveBirdWgtBillSaleEntryInfo)getObject(key);
    }
    public void set(int index, LiveBirdWgtBillSaleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LiveBirdWgtBillSaleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LiveBirdWgtBillSaleEntryInfo item)
    {
        return super.indexOf(item);
    }
}