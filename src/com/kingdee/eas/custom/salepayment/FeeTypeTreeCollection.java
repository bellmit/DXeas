package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeeTypeTreeCollection extends AbstractObjectCollection 
{
    public FeeTypeTreeCollection()
    {
        super(FeeTypeTreeInfo.class);
    }
    public boolean add(FeeTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeeTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeeTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public FeeTypeTreeInfo get(int index)
    {
        return(FeeTypeTreeInfo)getObject(index);
    }
    public FeeTypeTreeInfo get(Object key)
    {
        return(FeeTypeTreeInfo)getObject(key);
    }
    public void set(int index, FeeTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeeTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeeTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}