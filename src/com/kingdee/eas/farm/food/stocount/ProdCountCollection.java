package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProdCountCollection extends AbstractObjectCollection 
{
    public ProdCountCollection()
    {
        super(ProdCountInfo.class);
    }
    public boolean add(ProdCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProdCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProdCountInfo item)
    {
        return removeObject(item);
    }
    public ProdCountInfo get(int index)
    {
        return(ProdCountInfo)getObject(index);
    }
    public ProdCountInfo get(Object key)
    {
        return(ProdCountInfo)getObject(key);
    }
    public void set(int index, ProdCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProdCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProdCountInfo item)
    {
        return super.indexOf(item);
    }
}