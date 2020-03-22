package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettlePolicyTreeCollection extends AbstractObjectCollection 
{
    public EggSettlePolicyTreeCollection()
    {
        super(EggSettlePolicyTreeInfo.class);
    }
    public boolean add(EggSettlePolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettlePolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettlePolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public EggSettlePolicyTreeInfo get(int index)
    {
        return(EggSettlePolicyTreeInfo)getObject(index);
    }
    public EggSettlePolicyTreeInfo get(Object key)
    {
        return(EggSettlePolicyTreeInfo)getObject(key);
    }
    public void set(int index, EggSettlePolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettlePolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettlePolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}