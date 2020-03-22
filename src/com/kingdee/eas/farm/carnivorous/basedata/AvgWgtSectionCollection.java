package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AvgWgtSectionCollection extends AbstractObjectCollection 
{
    public AvgWgtSectionCollection()
    {
        super(AvgWgtSectionInfo.class);
    }
    public boolean add(AvgWgtSectionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AvgWgtSectionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AvgWgtSectionInfo item)
    {
        return removeObject(item);
    }
    public AvgWgtSectionInfo get(int index)
    {
        return(AvgWgtSectionInfo)getObject(index);
    }
    public AvgWgtSectionInfo get(Object key)
    {
        return(AvgWgtSectionInfo)getObject(key);
    }
    public void set(int index, AvgWgtSectionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AvgWgtSectionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AvgWgtSectionInfo item)
    {
        return super.indexOf(item);
    }
}