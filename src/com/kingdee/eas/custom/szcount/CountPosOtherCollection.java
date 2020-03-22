package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountPosOtherCollection extends AbstractObjectCollection 
{
    public CountPosOtherCollection()
    {
        super(CountPosOtherInfo.class);
    }
    public boolean add(CountPosOtherInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountPosOtherCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountPosOtherInfo item)
    {
        return removeObject(item);
    }
    public CountPosOtherInfo get(int index)
    {
        return(CountPosOtherInfo)getObject(index);
    }
    public CountPosOtherInfo get(Object key)
    {
        return(CountPosOtherInfo)getObject(key);
    }
    public void set(int index, CountPosOtherInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountPosOtherInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountPosOtherInfo item)
    {
        return super.indexOf(item);
    }
}