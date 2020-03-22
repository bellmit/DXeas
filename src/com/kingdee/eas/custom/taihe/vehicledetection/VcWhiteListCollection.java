package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VcWhiteListCollection extends AbstractObjectCollection 
{
    public VcWhiteListCollection()
    {
        super(VcWhiteListInfo.class);
    }
    public boolean add(VcWhiteListInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VcWhiteListCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VcWhiteListInfo item)
    {
        return removeObject(item);
    }
    public VcWhiteListInfo get(int index)
    {
        return(VcWhiteListInfo)getObject(index);
    }
    public VcWhiteListInfo get(Object key)
    {
        return(VcWhiteListInfo)getObject(key);
    }
    public void set(int index, VcWhiteListInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VcWhiteListInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VcWhiteListInfo item)
    {
        return super.indexOf(item);
    }
}