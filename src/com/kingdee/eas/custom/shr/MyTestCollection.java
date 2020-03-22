package com.kingdee.eas.custom.shr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MyTestCollection extends AbstractObjectCollection 
{
    public MyTestCollection()
    {
        super(MyTestInfo.class);
    }
    public boolean add(MyTestInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MyTestCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MyTestInfo item)
    {
        return removeObject(item);
    }
    public MyTestInfo get(int index)
    {
        return(MyTestInfo)getObject(index);
    }
    public MyTestInfo get(Object key)
    {
        return(MyTestInfo)getObject(key);
    }
    public void set(int index, MyTestInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MyTestInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MyTestInfo item)
    {
        return super.indexOf(item);
    }
}