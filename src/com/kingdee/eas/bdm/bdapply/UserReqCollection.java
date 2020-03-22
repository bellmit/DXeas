package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class UserReqCollection extends AbstractObjectCollection 
{
    public UserReqCollection()
    {
        super(UserReqInfo.class);
    }
    public boolean add(UserReqInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(UserReqCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(UserReqInfo item)
    {
        return removeObject(item);
    }
    public UserReqInfo get(int index)
    {
        return(UserReqInfo)getObject(index);
    }
    public UserReqInfo get(Object key)
    {
        return(UserReqInfo)getObject(key);
    }
    public void set(int index, UserReqInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(UserReqInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(UserReqInfo item)
    {
        return super.indexOf(item);
    }
}