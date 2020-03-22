package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillViewReqEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillViewReqEntryCollection()
    {
        super(CKSettleBillViewReqEntryInfo.class);
    }
    public boolean add(CKSettleBillViewReqEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillViewReqEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillViewReqEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillViewReqEntryInfo get(int index)
    {
        return(CKSettleBillViewReqEntryInfo)getObject(index);
    }
    public CKSettleBillViewReqEntryInfo get(Object key)
    {
        return(CKSettleBillViewReqEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillViewReqEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillViewReqEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillViewReqEntryInfo item)
    {
        return super.indexOf(item);
    }
}