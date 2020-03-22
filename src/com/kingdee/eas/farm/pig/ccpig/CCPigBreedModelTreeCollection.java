package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigBreedModelTreeCollection extends AbstractObjectCollection 
{
    public CCPigBreedModelTreeCollection()
    {
        super(CCPigBreedModelTreeInfo.class);
    }
    public boolean add(CCPigBreedModelTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigBreedModelTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigBreedModelTreeInfo item)
    {
        return removeObject(item);
    }
    public CCPigBreedModelTreeInfo get(int index)
    {
        return(CCPigBreedModelTreeInfo)getObject(index);
    }
    public CCPigBreedModelTreeInfo get(Object key)
    {
        return(CCPigBreedModelTreeInfo)getObject(key);
    }
    public void set(int index, CCPigBreedModelTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigBreedModelTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigBreedModelTreeInfo item)
    {
        return super.indexOf(item);
    }
}