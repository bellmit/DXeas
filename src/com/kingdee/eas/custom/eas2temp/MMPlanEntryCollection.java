package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MMPlanEntryCollection extends AbstractObjectCollection 
{
    public MMPlanEntryCollection()
    {
        super(MMPlanEntryInfo.class);
    }
    public boolean add(MMPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MMPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MMPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public MMPlanEntryInfo get(int index)
    {
        return(MMPlanEntryInfo)getObject(index);
    }
    public MMPlanEntryInfo get(Object key)
    {
        return(MMPlanEntryInfo)getObject(key);
    }
    public void set(int index, MMPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MMPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MMPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}