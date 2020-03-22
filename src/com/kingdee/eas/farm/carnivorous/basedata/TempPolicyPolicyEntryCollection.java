package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TempPolicyPolicyEntryCollection extends AbstractObjectCollection 
{
    public TempPolicyPolicyEntryCollection()
    {
        super(TempPolicyPolicyEntryInfo.class);
    }
    public boolean add(TempPolicyPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TempPolicyPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TempPolicyPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public TempPolicyPolicyEntryInfo get(int index)
    {
        return(TempPolicyPolicyEntryInfo)getObject(index);
    }
    public TempPolicyPolicyEntryInfo get(Object key)
    {
        return(TempPolicyPolicyEntryInfo)getObject(key);
    }
    public void set(int index, TempPolicyPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TempPolicyPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TempPolicyPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}