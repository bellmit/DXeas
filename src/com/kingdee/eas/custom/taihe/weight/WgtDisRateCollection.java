package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WgtDisRateCollection extends AbstractObjectCollection 
{
    public WgtDisRateCollection()
    {
        super(WgtDisRateInfo.class);
    }
    public boolean add(WgtDisRateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WgtDisRateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WgtDisRateInfo item)
    {
        return removeObject(item);
    }
    public WgtDisRateInfo get(int index)
    {
        return(WgtDisRateInfo)getObject(index);
    }
    public WgtDisRateInfo get(Object key)
    {
        return(WgtDisRateInfo)getObject(key);
    }
    public void set(int index, WgtDisRateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WgtDisRateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WgtDisRateInfo item)
    {
        return super.indexOf(item);
    }
}