package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ScoreStandardCollection extends AbstractObjectCollection 
{
    public ScoreStandardCollection()
    {
        super(ScoreStandardInfo.class);
    }
    public boolean add(ScoreStandardInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ScoreStandardCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ScoreStandardInfo item)
    {
        return removeObject(item);
    }
    public ScoreStandardInfo get(int index)
    {
        return(ScoreStandardInfo)getObject(index);
    }
    public ScoreStandardInfo get(Object key)
    {
        return(ScoreStandardInfo)getObject(key);
    }
    public void set(int index, ScoreStandardInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ScoreStandardInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ScoreStandardInfo item)
    {
        return super.indexOf(item);
    }
}