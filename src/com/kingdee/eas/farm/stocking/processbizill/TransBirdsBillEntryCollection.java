package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransBirdsBillEntryCollection extends AbstractObjectCollection 
{
    public TransBirdsBillEntryCollection()
    {
        super(TransBirdsBillEntryInfo.class);
    }
    public boolean add(TransBirdsBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransBirdsBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransBirdsBillEntryInfo item)
    {
        return removeObject(item);
    }
    public TransBirdsBillEntryInfo get(int index)
    {
        return(TransBirdsBillEntryInfo)getObject(index);
    }
    public TransBirdsBillEntryInfo get(Object key)
    {
        return(TransBirdsBillEntryInfo)getObject(key);
    }
    public void set(int index, TransBirdsBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransBirdsBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransBirdsBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}