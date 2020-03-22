package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedingBoarBreedModelCollection extends AbstractObjectCollection 
{
    public BreedingBoarBreedModelCollection()
    {
        super(BreedingBoarBreedModelInfo.class);
    }
    public boolean add(BreedingBoarBreedModelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedingBoarBreedModelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedingBoarBreedModelInfo item)
    {
        return removeObject(item);
    }
    public BreedingBoarBreedModelInfo get(int index)
    {
        return(BreedingBoarBreedModelInfo)getObject(index);
    }
    public BreedingBoarBreedModelInfo get(Object key)
    {
        return(BreedingBoarBreedModelInfo)getObject(key);
    }
    public void set(int index, BreedingBoarBreedModelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedingBoarBreedModelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedingBoarBreedModelInfo item)
    {
        return super.indexOf(item);
    }
}