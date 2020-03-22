package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class YieldDataBaseTreeCollection extends AbstractObjectCollection 
{
    public YieldDataBaseTreeCollection()
    {
        super(YieldDataBaseTreeInfo.class);
    }
    public boolean add(YieldDataBaseTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(YieldDataBaseTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(YieldDataBaseTreeInfo item)
    {
        return removeObject(item);
    }
    public YieldDataBaseTreeInfo get(int index)
    {
        return(YieldDataBaseTreeInfo)getObject(index);
    }
    public YieldDataBaseTreeInfo get(Object key)
    {
        return(YieldDataBaseTreeInfo)getObject(key);
    }
    public void set(int index, YieldDataBaseTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(YieldDataBaseTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(YieldDataBaseTreeInfo item)
    {
        return super.indexOf(item);
    }
}