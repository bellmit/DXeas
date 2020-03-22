package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderApplyBillCollection extends AbstractObjectCollection 
{
    public FodderApplyBillCollection()
    {
        super(FodderApplyBillInfo.class);
    }
    public boolean add(FodderApplyBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderApplyBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderApplyBillInfo item)
    {
        return removeObject(item);
    }
    public FodderApplyBillInfo get(int index)
    {
        return(FodderApplyBillInfo)getObject(index);
    }
    public FodderApplyBillInfo get(Object key)
    {
        return(FodderApplyBillInfo)getObject(key);
    }
    public void set(int index, FodderApplyBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderApplyBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderApplyBillInfo item)
    {
        return super.indexOf(item);
    }
}