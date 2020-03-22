package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransBirdsBillCollection extends AbstractObjectCollection 
{
    public TransBirdsBillCollection()
    {
        super(TransBirdsBillInfo.class);
    }
    public boolean add(TransBirdsBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransBirdsBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransBirdsBillInfo item)
    {
        return removeObject(item);
    }
    public TransBirdsBillInfo get(int index)
    {
        return(TransBirdsBillInfo)getObject(index);
    }
    public TransBirdsBillInfo get(Object key)
    {
        return(TransBirdsBillInfo)getObject(key);
    }
    public void set(int index, TransBirdsBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransBirdsBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransBirdsBillInfo item)
    {
        return super.indexOf(item);
    }
}