package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TempPolicyEntryCollection extends AbstractObjectCollection 
{
    public TempPolicyEntryCollection()
    {
        super(TempPolicyEntryInfo.class);
    }
    public boolean add(TempPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TempPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TempPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public TempPolicyEntryInfo get(int index)
    {
        return(TempPolicyEntryInfo)getObject(index);
    }
    public TempPolicyEntryInfo get(Object key)
    {
        return(TempPolicyEntryInfo)getObject(key);
    }
    public void set(int index, TempPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TempPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TempPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}