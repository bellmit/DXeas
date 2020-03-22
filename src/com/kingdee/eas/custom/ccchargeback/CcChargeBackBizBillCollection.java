package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CcChargeBackBizBillCollection extends AbstractObjectCollection 
{
    public CcChargeBackBizBillCollection()
    {
        super(CcChargeBackBizBillInfo.class);
    }
    public boolean add(CcChargeBackBizBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CcChargeBackBizBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CcChargeBackBizBillInfo item)
    {
        return removeObject(item);
    }
    public CcChargeBackBizBillInfo get(int index)
    {
        return(CcChargeBackBizBillInfo)getObject(index);
    }
    public CcChargeBackBizBillInfo get(Object key)
    {
        return(CcChargeBackBizBillInfo)getObject(key);
    }
    public void set(int index, CcChargeBackBizBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CcChargeBackBizBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CcChargeBackBizBillInfo item)
    {
        return super.indexOf(item);
    }
}