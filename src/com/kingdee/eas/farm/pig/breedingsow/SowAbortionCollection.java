package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowAbortionCollection extends AbstractObjectCollection 
{
    public SowAbortionCollection()
    {
        super(SowAbortionInfo.class);
    }
    public boolean add(SowAbortionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowAbortionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowAbortionInfo item)
    {
        return removeObject(item);
    }
    public SowAbortionInfo get(int index)
    {
        return(SowAbortionInfo)getObject(index);
    }
    public SowAbortionInfo get(Object key)
    {
        return(SowAbortionInfo)getObject(key);
    }
    public void set(int index, SowAbortionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowAbortionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowAbortionInfo item)
    {
        return super.indexOf(item);
    }
}