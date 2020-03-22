package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginGetPolicyEntryCollection extends AbstractObjectCollection 
{
    public MarginGetPolicyEntryCollection()
    {
        super(MarginGetPolicyEntryInfo.class);
    }
    public boolean add(MarginGetPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginGetPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginGetPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public MarginGetPolicyEntryInfo get(int index)
    {
        return(MarginGetPolicyEntryInfo)getObject(index);
    }
    public MarginGetPolicyEntryInfo get(Object key)
    {
        return(MarginGetPolicyEntryInfo)getObject(key);
    }
    public void set(int index, MarginGetPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginGetPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginGetPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}