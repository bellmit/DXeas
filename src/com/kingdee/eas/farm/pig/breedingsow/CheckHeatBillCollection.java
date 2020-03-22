package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckHeatBillCollection extends AbstractObjectCollection 
{
    public CheckHeatBillCollection()
    {
        super(CheckHeatBillInfo.class);
    }
    public boolean add(CheckHeatBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckHeatBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckHeatBillInfo item)
    {
        return removeObject(item);
    }
    public CheckHeatBillInfo get(int index)
    {
        return(CheckHeatBillInfo)getObject(index);
    }
    public CheckHeatBillInfo get(Object key)
    {
        return(CheckHeatBillInfo)getObject(key);
    }
    public void set(int index, CheckHeatBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckHeatBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckHeatBillInfo item)
    {
        return super.indexOf(item);
    }
}