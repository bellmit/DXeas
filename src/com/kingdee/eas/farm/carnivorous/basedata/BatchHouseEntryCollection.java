package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchHouseEntryCollection extends AbstractObjectCollection 
{
    public BatchHouseEntryCollection()
    {
        super(BatchHouseEntryInfo.class);
    }
    public boolean add(BatchHouseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchHouseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchHouseEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchHouseEntryInfo get(int index)
    {
        return(BatchHouseEntryInfo)getObject(index);
    }
    public BatchHouseEntryInfo get(Object key)
    {
        return(BatchHouseEntryInfo)getObject(key);
    }
    public void set(int index, BatchHouseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchHouseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchHouseEntryInfo item)
    {
        return super.indexOf(item);
    }
}