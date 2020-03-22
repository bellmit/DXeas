package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicyTreeCollection extends AbstractObjectCollection 
{
    public SettlePolicyTreeCollection()
    {
        super(SettlePolicyTreeInfo.class);
    }
    public boolean add(SettlePolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicyTreeInfo get(int index)
    {
        return(SettlePolicyTreeInfo)getObject(index);
    }
    public SettlePolicyTreeInfo get(Object key)
    {
        return(SettlePolicyTreeInfo)getObject(key);
    }
    public void set(int index, SettlePolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}