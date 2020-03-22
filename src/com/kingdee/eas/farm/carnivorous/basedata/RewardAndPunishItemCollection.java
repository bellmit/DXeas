package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RewardAndPunishItemCollection extends AbstractObjectCollection 
{
    public RewardAndPunishItemCollection()
    {
        super(RewardAndPunishItemInfo.class);
    }
    public boolean add(RewardAndPunishItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RewardAndPunishItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RewardAndPunishItemInfo item)
    {
        return removeObject(item);
    }
    public RewardAndPunishItemInfo get(int index)
    {
        return(RewardAndPunishItemInfo)getObject(index);
    }
    public RewardAndPunishItemInfo get(Object key)
    {
        return(RewardAndPunishItemInfo)getObject(key);
    }
    public void set(int index, RewardAndPunishItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RewardAndPunishItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RewardAndPunishItemInfo item)
    {
        return super.indexOf(item);
    }
}