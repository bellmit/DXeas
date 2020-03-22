package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AvgWgtSectionEntryCollection extends AbstractObjectCollection 
{
    public AvgWgtSectionEntryCollection()
    {
        super(AvgWgtSectionEntryInfo.class);
    }
    public boolean add(AvgWgtSectionEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AvgWgtSectionEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AvgWgtSectionEntryInfo item)
    {
        return removeObject(item);
    }
    public AvgWgtSectionEntryInfo get(int index)
    {
        return(AvgWgtSectionEntryInfo)getObject(index);
    }
    public AvgWgtSectionEntryInfo get(Object key)
    {
        return(AvgWgtSectionEntryInfo)getObject(key);
    }
    public void set(int index, AvgWgtSectionEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AvgWgtSectionEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AvgWgtSectionEntryInfo item)
    {
        return super.indexOf(item);
    }
}