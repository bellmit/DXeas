package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderApplyRelationCollection extends AbstractObjectCollection 
{
    public FodderApplyRelationCollection()
    {
        super(FodderApplyRelationInfo.class);
    }
    public boolean add(FodderApplyRelationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderApplyRelationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderApplyRelationInfo item)
    {
        return removeObject(item);
    }
    public FodderApplyRelationInfo get(int index)
    {
        return(FodderApplyRelationInfo)getObject(index);
    }
    public FodderApplyRelationInfo get(Object key)
    {
        return(FodderApplyRelationInfo)getObject(key);
    }
    public void set(int index, FodderApplyRelationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderApplyRelationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderApplyRelationInfo item)
    {
        return super.indexOf(item);
    }
}