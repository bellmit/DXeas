package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKPECostbillCollection extends AbstractObjectCollection 
{
    public CKPECostbillCollection()
    {
        super(CKPECostbillInfo.class);
    }
    public boolean add(CKPECostbillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKPECostbillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKPECostbillInfo item)
    {
        return removeObject(item);
    }
    public CKPECostbillInfo get(int index)
    {
        return(CKPECostbillInfo)getObject(index);
    }
    public CKPECostbillInfo get(Object key)
    {
        return(CKPECostbillInfo)getObject(key);
    }
    public void set(int index, CKPECostbillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKPECostbillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKPECostbillInfo item)
    {
        return super.indexOf(item);
    }
}