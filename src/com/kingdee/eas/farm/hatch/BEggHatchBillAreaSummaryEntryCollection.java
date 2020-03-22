package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BEggHatchBillAreaSummaryEntryCollection extends AbstractObjectCollection 
{
    public BEggHatchBillAreaSummaryEntryCollection()
    {
        super(BEggHatchBillAreaSummaryEntryInfo.class);
    }
    public boolean add(BEggHatchBillAreaSummaryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BEggHatchBillAreaSummaryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BEggHatchBillAreaSummaryEntryInfo item)
    {
        return removeObject(item);
    }
    public BEggHatchBillAreaSummaryEntryInfo get(int index)
    {
        return(BEggHatchBillAreaSummaryEntryInfo)getObject(index);
    }
    public BEggHatchBillAreaSummaryEntryInfo get(Object key)
    {
        return(BEggHatchBillAreaSummaryEntryInfo)getObject(key);
    }
    public void set(int index, BEggHatchBillAreaSummaryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BEggHatchBillAreaSummaryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BEggHatchBillAreaSummaryEntryInfo item)
    {
        return super.indexOf(item);
    }
}