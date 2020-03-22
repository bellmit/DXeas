package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchAssessEntryCollection extends AbstractObjectCollection 
{
    public HatchAssessEntryCollection()
    {
        super(HatchAssessEntryInfo.class);
    }
    public boolean add(HatchAssessEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchAssessEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchAssessEntryInfo item)
    {
        return removeObject(item);
    }
    public HatchAssessEntryInfo get(int index)
    {
        return(HatchAssessEntryInfo)getObject(index);
    }
    public HatchAssessEntryInfo get(Object key)
    {
        return(HatchAssessEntryInfo)getObject(key);
    }
    public void set(int index, HatchAssessEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchAssessEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchAssessEntryInfo item)
    {
        return super.indexOf(item);
    }
}