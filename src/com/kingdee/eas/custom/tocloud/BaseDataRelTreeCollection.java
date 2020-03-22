package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BaseDataRelTreeCollection extends AbstractObjectCollection 
{
    public BaseDataRelTreeCollection()
    {
        super(BaseDataRelTreeInfo.class);
    }
    public boolean add(BaseDataRelTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BaseDataRelTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BaseDataRelTreeInfo item)
    {
        return removeObject(item);
    }
    public BaseDataRelTreeInfo get(int index)
    {
        return(BaseDataRelTreeInfo)getObject(index);
    }
    public BaseDataRelTreeInfo get(Object key)
    {
        return(BaseDataRelTreeInfo)getObject(key);
    }
    public void set(int index, BaseDataRelTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BaseDataRelTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BaseDataRelTreeInfo item)
    {
        return super.indexOf(item);
    }
}