package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmersTreeCollection extends AbstractObjectCollection 
{
    public FarmersTreeCollection()
    {
        super(FarmersTreeInfo.class);
    }
    public boolean add(FarmersTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmersTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmersTreeInfo item)
    {
        return removeObject(item);
    }
    public FarmersTreeInfo get(int index)
    {
        return(FarmersTreeInfo)getObject(index);
    }
    public FarmersTreeInfo get(Object key)
    {
        return(FarmersTreeInfo)getObject(key);
    }
    public void set(int index, FarmersTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmersTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmersTreeInfo item)
    {
        return super.indexOf(item);
    }
}