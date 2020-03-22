package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AdjustCauseCollection extends AbstractObjectCollection 
{
    public AdjustCauseCollection()
    {
        super(AdjustCauseInfo.class);
    }
    public boolean add(AdjustCauseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AdjustCauseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AdjustCauseInfo item)
    {
        return removeObject(item);
    }
    public AdjustCauseInfo get(int index)
    {
        return(AdjustCauseInfo)getObject(index);
    }
    public AdjustCauseInfo get(Object key)
    {
        return(AdjustCauseInfo)getObject(key);
    }
    public void set(int index, AdjustCauseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AdjustCauseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AdjustCauseInfo item)
    {
        return super.indexOf(item);
    }
}