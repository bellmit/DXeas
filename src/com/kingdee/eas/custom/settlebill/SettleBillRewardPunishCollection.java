package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleBillRewardPunishCollection extends AbstractObjectCollection 
{
    public SettleBillRewardPunishCollection()
    {
        super(SettleBillRewardPunishInfo.class);
    }
    public boolean add(SettleBillRewardPunishInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleBillRewardPunishCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleBillRewardPunishInfo item)
    {
        return removeObject(item);
    }
    public SettleBillRewardPunishInfo get(int index)
    {
        return(SettleBillRewardPunishInfo)getObject(index);
    }
    public SettleBillRewardPunishInfo get(Object key)
    {
        return(SettleBillRewardPunishInfo)getObject(key);
    }
    public void set(int index, SettleBillRewardPunishInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleBillRewardPunishInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleBillRewardPunishInfo item)
    {
        return super.indexOf(item);
    }
}