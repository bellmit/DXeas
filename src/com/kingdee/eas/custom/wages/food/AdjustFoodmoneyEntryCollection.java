package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AdjustFoodmoneyEntryCollection extends AbstractObjectCollection 
{
    public AdjustFoodmoneyEntryCollection()
    {
        super(AdjustFoodmoneyEntryInfo.class);
    }
    public boolean add(AdjustFoodmoneyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AdjustFoodmoneyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AdjustFoodmoneyEntryInfo item)
    {
        return removeObject(item);
    }
    public AdjustFoodmoneyEntryInfo get(int index)
    {
        return(AdjustFoodmoneyEntryInfo)getObject(index);
    }
    public AdjustFoodmoneyEntryInfo get(Object key)
    {
        return(AdjustFoodmoneyEntryInfo)getObject(key);
    }
    public void set(int index, AdjustFoodmoneyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AdjustFoodmoneyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AdjustFoodmoneyEntryInfo item)
    {
        return super.indexOf(item);
    }
}