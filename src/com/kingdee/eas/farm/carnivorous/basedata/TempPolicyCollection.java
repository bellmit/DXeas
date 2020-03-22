package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TempPolicyCollection extends AbstractObjectCollection 
{
    public TempPolicyCollection()
    {
        super(TempPolicyInfo.class);
    }
    public boolean add(TempPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TempPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TempPolicyInfo item)
    {
        return removeObject(item);
    }
    public TempPolicyInfo get(int index)
    {
        return(TempPolicyInfo)getObject(index);
    }
    public TempPolicyInfo get(Object key)
    {
        return(TempPolicyInfo)getObject(key);
    }
    public void set(int index, TempPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TempPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TempPolicyInfo item)
    {
        return super.indexOf(item);
    }
}