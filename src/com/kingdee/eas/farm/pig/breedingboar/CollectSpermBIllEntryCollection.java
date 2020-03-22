package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CollectSpermBIllEntryCollection extends AbstractObjectCollection 
{
    public CollectSpermBIllEntryCollection()
    {
        super(CollectSpermBIllEntryInfo.class);
    }
    public boolean add(CollectSpermBIllEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CollectSpermBIllEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CollectSpermBIllEntryInfo item)
    {
        return removeObject(item);
    }
    public CollectSpermBIllEntryInfo get(int index)
    {
        return(CollectSpermBIllEntryInfo)getObject(index);
    }
    public CollectSpermBIllEntryInfo get(Object key)
    {
        return(CollectSpermBIllEntryInfo)getObject(key);
    }
    public void set(int index, CollectSpermBIllEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CollectSpermBIllEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CollectSpermBIllEntryInfo item)
    {
        return super.indexOf(item);
    }
}