package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MMPlanCollection extends AbstractObjectCollection 
{
    public MMPlanCollection()
    {
        super(MMPlanInfo.class);
    }
    public boolean add(MMPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MMPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MMPlanInfo item)
    {
        return removeObject(item);
    }
    public MMPlanInfo get(int index)
    {
        return(MMPlanInfo)getObject(index);
    }
    public MMPlanInfo get(Object key)
    {
        return(MMPlanInfo)getObject(key);
    }
    public void set(int index, MMPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MMPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MMPlanInfo item)
    {
        return super.indexOf(item);
    }
}