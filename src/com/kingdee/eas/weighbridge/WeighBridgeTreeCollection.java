package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WeighBridgeTreeCollection extends AbstractObjectCollection 
{
    public WeighBridgeTreeCollection()
    {
        super(WeighBridgeTreeInfo.class);
    }
    public boolean add(WeighBridgeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WeighBridgeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WeighBridgeTreeInfo item)
    {
        return removeObject(item);
    }
    public WeighBridgeTreeInfo get(int index)
    {
        return(WeighBridgeTreeInfo)getObject(index);
    }
    public WeighBridgeTreeInfo get(Object key)
    {
        return(WeighBridgeTreeInfo)getObject(key);
    }
    public void set(int index, WeighBridgeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WeighBridgeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WeighBridgeTreeInfo item)
    {
        return super.indexOf(item);
    }
}