package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StrainTreeCollection extends AbstractObjectCollection 
{
    public StrainTreeCollection()
    {
        super(StrainTreeInfo.class);
    }
    public boolean add(StrainTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StrainTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StrainTreeInfo item)
    {
        return removeObject(item);
    }
    public StrainTreeInfo get(int index)
    {
        return(StrainTreeInfo)getObject(index);
    }
    public StrainTreeInfo get(Object key)
    {
        return(StrainTreeInfo)getObject(key);
    }
    public void set(int index, StrainTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StrainTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StrainTreeInfo item)
    {
        return super.indexOf(item);
    }
}