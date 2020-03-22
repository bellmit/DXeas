package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialApplyBillCollection extends AbstractObjectCollection 
{
    public MaterialApplyBillCollection()
    {
        super(MaterialApplyBillInfo.class);
    }
    public boolean add(MaterialApplyBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialApplyBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialApplyBillInfo item)
    {
        return removeObject(item);
    }
    public MaterialApplyBillInfo get(int index)
    {
        return(MaterialApplyBillInfo)getObject(index);
    }
    public MaterialApplyBillInfo get(Object key)
    {
        return(MaterialApplyBillInfo)getObject(key);
    }
    public void set(int index, MaterialApplyBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialApplyBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialApplyBillInfo item)
    {
        return super.indexOf(item);
    }
}