package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AppraisalclientCollection extends AbstractObjectCollection 
{
    public AppraisalclientCollection()
    {
        super(AppraisalclientInfo.class);
    }
    public boolean add(AppraisalclientInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AppraisalclientCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AppraisalclientInfo item)
    {
        return removeObject(item);
    }
    public AppraisalclientInfo get(int index)
    {
        return(AppraisalclientInfo)getObject(index);
    }
    public AppraisalclientInfo get(Object key)
    {
        return(AppraisalclientInfo)getObject(key);
    }
    public void set(int index, AppraisalclientInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AppraisalclientInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AppraisalclientInfo item)
    {
        return super.indexOf(item);
    }
}