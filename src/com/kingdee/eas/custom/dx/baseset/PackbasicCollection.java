package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PackbasicCollection extends AbstractObjectCollection 
{
    public PackbasicCollection()
    {
        super(PackbasicInfo.class);
    }
    public boolean add(PackbasicInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PackbasicCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PackbasicInfo item)
    {
        return removeObject(item);
    }
    public PackbasicInfo get(int index)
    {
        return(PackbasicInfo)getObject(index);
    }
    public PackbasicInfo get(Object key)
    {
        return(PackbasicInfo)getObject(key);
    }
    public void set(int index, PackbasicInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PackbasicInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PackbasicInfo item)
    {
        return super.indexOf(item);
    }
}