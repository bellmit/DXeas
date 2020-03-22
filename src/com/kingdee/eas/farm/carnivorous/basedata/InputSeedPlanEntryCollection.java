package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InputSeedPlanEntryCollection extends AbstractObjectCollection 
{
    public InputSeedPlanEntryCollection()
    {
        super(InputSeedPlanEntryInfo.class);
    }
    public boolean add(InputSeedPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InputSeedPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InputSeedPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public InputSeedPlanEntryInfo get(int index)
    {
        return(InputSeedPlanEntryInfo)getObject(index);
    }
    public InputSeedPlanEntryInfo get(Object key)
    {
        return(InputSeedPlanEntryInfo)getObject(key);
    }
    public void set(int index, InputSeedPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InputSeedPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InputSeedPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}