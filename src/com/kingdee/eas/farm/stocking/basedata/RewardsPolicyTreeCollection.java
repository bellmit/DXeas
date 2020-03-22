package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RewardsPolicyTreeCollection extends AbstractObjectCollection 
{
    public RewardsPolicyTreeCollection()
    {
        super(RewardsPolicyTreeInfo.class);
    }
    public boolean add(RewardsPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RewardsPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RewardsPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public RewardsPolicyTreeInfo get(int index)
    {
        return(RewardsPolicyTreeInfo)getObject(index);
    }
    public RewardsPolicyTreeInfo get(Object key)
    {
        return(RewardsPolicyTreeInfo)getObject(key);
    }
    public void set(int index, RewardsPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RewardsPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RewardsPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}