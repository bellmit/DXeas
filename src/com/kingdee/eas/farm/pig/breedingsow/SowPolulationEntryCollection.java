package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowPolulationEntryCollection extends AbstractObjectCollection 
{
    public SowPolulationEntryCollection()
    {
        super(SowPolulationEntryInfo.class);
    }
    public boolean add(SowPolulationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowPolulationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowPolulationEntryInfo item)
    {
        return removeObject(item);
    }
    public SowPolulationEntryInfo get(int index)
    {
        return(SowPolulationEntryInfo)getObject(index);
    }
    public SowPolulationEntryInfo get(Object key)
    {
        return(SowPolulationEntryInfo)getObject(key);
    }
    public void set(int index, SowPolulationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowPolulationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowPolulationEntryInfo item)
    {
        return super.indexOf(item);
    }
}