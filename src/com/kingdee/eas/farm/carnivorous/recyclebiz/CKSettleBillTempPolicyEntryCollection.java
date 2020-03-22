package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillTempPolicyEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillTempPolicyEntryCollection()
    {
        super(CKSettleBillTempPolicyEntryInfo.class);
    }
    public boolean add(CKSettleBillTempPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillTempPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillTempPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillTempPolicyEntryInfo get(int index)
    {
        return(CKSettleBillTempPolicyEntryInfo)getObject(index);
    }
    public CKSettleBillTempPolicyEntryInfo get(Object key)
    {
        return(CKSettleBillTempPolicyEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillTempPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillTempPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillTempPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}