package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VcWhiteListTreeCollection extends AbstractObjectCollection 
{
    public VcWhiteListTreeCollection()
    {
        super(VcWhiteListTreeInfo.class);
    }
    public boolean add(VcWhiteListTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VcWhiteListTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VcWhiteListTreeInfo item)
    {
        return removeObject(item);
    }
    public VcWhiteListTreeInfo get(int index)
    {
        return(VcWhiteListTreeInfo)getObject(index);
    }
    public VcWhiteListTreeInfo get(Object key)
    {
        return(VcWhiteListTreeInfo)getObject(key);
    }
    public void set(int index, VcWhiteListTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VcWhiteListTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VcWhiteListTreeInfo item)
    {
        return super.indexOf(item);
    }
}