package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BabyPigEntryCollection extends AbstractObjectCollection 
{
    public BabyPigEntryCollection()
    {
        super(BabyPigEntryInfo.class);
    }
    public boolean add(BabyPigEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BabyPigEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BabyPigEntryInfo item)
    {
        return removeObject(item);
    }
    public BabyPigEntryInfo get(int index)
    {
        return(BabyPigEntryInfo)getObject(index);
    }
    public BabyPigEntryInfo get(Object key)
    {
        return(BabyPigEntryInfo)getObject(key);
    }
    public void set(int index, BabyPigEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BabyPigEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BabyPigEntryInfo item)
    {
        return super.indexOf(item);
    }
}