package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CoutBillSettingCollection extends AbstractObjectCollection 
{
    public CoutBillSettingCollection()
    {
        super(CoutBillSettingInfo.class);
    }
    public boolean add(CoutBillSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CoutBillSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CoutBillSettingInfo item)
    {
        return removeObject(item);
    }
    public CoutBillSettingInfo get(int index)
    {
        return(CoutBillSettingInfo)getObject(index);
    }
    public CoutBillSettingInfo get(Object key)
    {
        return(CoutBillSettingInfo)getObject(key);
    }
    public void set(int index, CoutBillSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CoutBillSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CoutBillSettingInfo item)
    {
        return super.indexOf(item);
    }
}