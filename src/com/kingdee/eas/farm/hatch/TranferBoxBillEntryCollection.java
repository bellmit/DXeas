package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TranferBoxBillEntryCollection extends AbstractObjectCollection 
{
    public TranferBoxBillEntryCollection()
    {
        super(TranferBoxBillEntryInfo.class);
    }
    public boolean add(TranferBoxBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TranferBoxBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TranferBoxBillEntryInfo item)
    {
        return removeObject(item);
    }
    public TranferBoxBillEntryInfo get(int index)
    {
        return(TranferBoxBillEntryInfo)getObject(index);
    }
    public TranferBoxBillEntryInfo get(Object key)
    {
        return(TranferBoxBillEntryInfo)getObject(key);
    }
    public void set(int index, TranferBoxBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TranferBoxBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TranferBoxBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}