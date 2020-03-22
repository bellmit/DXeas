package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FetationCheckTypeTreeCollection extends AbstractObjectCollection 
{
    public FetationCheckTypeTreeCollection()
    {
        super(FetationCheckTypeTreeInfo.class);
    }
    public boolean add(FetationCheckTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FetationCheckTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FetationCheckTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public FetationCheckTypeTreeInfo get(int index)
    {
        return(FetationCheckTypeTreeInfo)getObject(index);
    }
    public FetationCheckTypeTreeInfo get(Object key)
    {
        return(FetationCheckTypeTreeInfo)getObject(key);
    }
    public void set(int index, FetationCheckTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FetationCheckTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FetationCheckTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}