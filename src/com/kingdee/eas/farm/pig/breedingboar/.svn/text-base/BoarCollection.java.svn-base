package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BoarCollection extends AbstractObjectCollection 
{
    public BoarCollection()
    {
        super(BoarInfo.class);
    }
    public boolean add(BoarInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BoarCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BoarInfo item)
    {
        return removeObject(item);
    }
    public BoarInfo get(int index)
    {
        return(BoarInfo)getObject(index);
    }
    public BoarInfo get(Object key)
    {
        return(BoarInfo)getObject(key);
    }
    public void set(int index, BoarInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BoarInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BoarInfo item)
    {
        return super.indexOf(item);
    }
}