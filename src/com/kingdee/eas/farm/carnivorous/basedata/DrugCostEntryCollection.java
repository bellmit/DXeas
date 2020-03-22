package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugCostEntryCollection extends AbstractObjectCollection 
{
    public DrugCostEntryCollection()
    {
        super(DrugCostEntryInfo.class);
    }
    public boolean add(DrugCostEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugCostEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugCostEntryInfo item)
    {
        return removeObject(item);
    }
    public DrugCostEntryInfo get(int index)
    {
        return(DrugCostEntryInfo)getObject(index);
    }
    public DrugCostEntryInfo get(Object key)
    {
        return(DrugCostEntryInfo)getObject(key);
    }
    public void set(int index, DrugCostEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugCostEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugCostEntryInfo item)
    {
        return super.indexOf(item);
    }
}