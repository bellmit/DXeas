package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SzProdCountCollection extends AbstractObjectCollection 
{
    public SzProdCountCollection()
    {
        super(SzProdCountInfo.class);
    }
    public boolean add(SzProdCountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SzProdCountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SzProdCountInfo item)
    {
        return removeObject(item);
    }
    public SzProdCountInfo get(int index)
    {
        return(SzProdCountInfo)getObject(index);
    }
    public SzProdCountInfo get(Object key)
    {
        return(SzProdCountInfo)getObject(key);
    }
    public void set(int index, SzProdCountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SzProdCountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SzProdCountInfo item)
    {
        return super.indexOf(item);
    }
}