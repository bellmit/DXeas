package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchPlanCollection extends AbstractObjectCollection 
{
    public BatchPlanCollection()
    {
        super(BatchPlanInfo.class);
    }
    public boolean add(BatchPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchPlanInfo item)
    {
        return removeObject(item);
    }
    public BatchPlanInfo get(int index)
    {
        return(BatchPlanInfo)getObject(index);
    }
    public BatchPlanInfo get(Object key)
    {
        return(BatchPlanInfo)getObject(key);
    }
    public void set(int index, BatchPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchPlanInfo item)
    {
        return super.indexOf(item);
    }
}