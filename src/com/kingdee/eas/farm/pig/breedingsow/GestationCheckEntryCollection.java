package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class GestationCheckEntryCollection extends AbstractObjectCollection 
{
    public GestationCheckEntryCollection()
    {
        super(GestationCheckEntryInfo.class);
    }
    public boolean add(GestationCheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(GestationCheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(GestationCheckEntryInfo item)
    {
        return removeObject(item);
    }
    public GestationCheckEntryInfo get(int index)
    {
        return(GestationCheckEntryInfo)getObject(index);
    }
    public GestationCheckEntryInfo get(Object key)
    {
        return(GestationCheckEntryInfo)getObject(key);
    }
    public void set(int index, GestationCheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(GestationCheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(GestationCheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}