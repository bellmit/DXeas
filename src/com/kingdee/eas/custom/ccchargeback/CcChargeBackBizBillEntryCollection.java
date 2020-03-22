package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CcChargeBackBizBillEntryCollection extends AbstractObjectCollection 
{
    public CcChargeBackBizBillEntryCollection()
    {
        super(CcChargeBackBizBillEntryInfo.class);
    }
    public boolean add(CcChargeBackBizBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CcChargeBackBizBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CcChargeBackBizBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CcChargeBackBizBillEntryInfo get(int index)
    {
        return(CcChargeBackBizBillEntryInfo)getObject(index);
    }
    public CcChargeBackBizBillEntryInfo get(Object key)
    {
        return(CcChargeBackBizBillEntryInfo)getObject(key);
    }
    public void set(int index, CcChargeBackBizBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CcChargeBackBizBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CcChargeBackBizBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}