package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigTypeTreeCollection extends AbstractObjectCollection 
{
    public PigTypeTreeCollection()
    {
        super(PigTypeTreeInfo.class);
    }
    public boolean add(PigTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public PigTypeTreeInfo get(int index)
    {
        return(PigTypeTreeInfo)getObject(index);
    }
    public PigTypeTreeInfo get(Object key)
    {
        return(PigTypeTreeInfo)getObject(key);
    }
    public void set(int index, PigTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}