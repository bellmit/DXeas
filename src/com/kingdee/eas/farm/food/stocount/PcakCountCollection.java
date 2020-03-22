package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PcakCountCollection extends AbstractObjectCollection 
{
    public PcakCountCollection()
    {
        super(PcakCountInfo.class);
    }
    public boolean add(PcakCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PcakCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PcakCountInfo item)
    {
        return removeObject(item);
    }
    public PcakCountInfo get(int index)
    {
        return(PcakCountInfo)getObject(index);
    }
    public PcakCountInfo get(Object key)
    {
        return(PcakCountInfo)getObject(key);
    }
    public void set(int index, PcakCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PcakCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PcakCountInfo item)
    {
        return super.indexOf(item);
    }
}