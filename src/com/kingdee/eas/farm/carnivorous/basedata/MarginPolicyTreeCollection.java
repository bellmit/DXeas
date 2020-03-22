package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginPolicyTreeCollection extends AbstractObjectCollection 
{
    public MarginPolicyTreeCollection()
    {
        super(MarginPolicyTreeInfo.class);
    }
    public boolean add(MarginPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public MarginPolicyTreeInfo get(int index)
    {
        return(MarginPolicyTreeInfo)getObject(index);
    }
    public MarginPolicyTreeInfo get(Object key)
    {
        return(MarginPolicyTreeInfo)getObject(key);
    }
    public void set(int index, MarginPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}