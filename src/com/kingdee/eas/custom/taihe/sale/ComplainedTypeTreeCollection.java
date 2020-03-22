package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ComplainedTypeTreeCollection extends AbstractObjectCollection 
{
    public ComplainedTypeTreeCollection()
    {
        super(ComplainedTypeTreeInfo.class);
    }
    public boolean add(ComplainedTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ComplainedTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ComplainedTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public ComplainedTypeTreeInfo get(int index)
    {
        return(ComplainedTypeTreeInfo)getObject(index);
    }
    public ComplainedTypeTreeInfo get(Object key)
    {
        return(ComplainedTypeTreeInfo)getObject(key);
    }
    public void set(int index, ComplainedTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ComplainedTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ComplainedTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}