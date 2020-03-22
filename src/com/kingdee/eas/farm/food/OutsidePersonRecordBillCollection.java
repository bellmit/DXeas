package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OutsidePersonRecordBillCollection extends AbstractObjectCollection 
{
    public OutsidePersonRecordBillCollection()
    {
        super(OutsidePersonRecordBillInfo.class);
    }
    public boolean add(OutsidePersonRecordBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OutsidePersonRecordBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OutsidePersonRecordBillInfo item)
    {
        return removeObject(item);
    }
    public OutsidePersonRecordBillInfo get(int index)
    {
        return(OutsidePersonRecordBillInfo)getObject(index);
    }
    public OutsidePersonRecordBillInfo get(Object key)
    {
        return(OutsidePersonRecordBillInfo)getObject(key);
    }
    public void set(int index, OutsidePersonRecordBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OutsidePersonRecordBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OutsidePersonRecordBillInfo item)
    {
        return super.indexOf(item);
    }
}