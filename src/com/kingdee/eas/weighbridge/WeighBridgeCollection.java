package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WeighBridgeCollection extends AbstractObjectCollection 
{
    public WeighBridgeCollection()
    {
        super(WeighBridgeInfo.class);
    }
    public boolean add(WeighBridgeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WeighBridgeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WeighBridgeInfo item)
    {
        return removeObject(item);
    }
    public WeighBridgeInfo get(int index)
    {
        return(WeighBridgeInfo)getObject(index);
    }
    public WeighBridgeInfo get(Object key)
    {
        return(WeighBridgeInfo)getObject(key);
    }
    public void set(int index, WeighBridgeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WeighBridgeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WeighBridgeInfo item)
    {
        return super.indexOf(item);
    }
}