package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleStandardCollection extends AbstractObjectCollection 
{
    public SettleStandardCollection()
    {
        super(SettleStandardInfo.class);
    }
    public boolean add(SettleStandardInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleStandardCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleStandardInfo item)
    {
        return removeObject(item);
    }
    public SettleStandardInfo get(int index)
    {
        return(SettleStandardInfo)getObject(index);
    }
    public SettleStandardInfo get(Object key)
    {
        return(SettleStandardInfo)getObject(key);
    }
    public void set(int index, SettleStandardInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleStandardInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleStandardInfo item)
    {
        return super.indexOf(item);
    }
}