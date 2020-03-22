package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RewardAndPunishProjectCollection extends AbstractObjectCollection 
{
    public RewardAndPunishProjectCollection()
    {
        super(RewardAndPunishProjectInfo.class);
    }
    public boolean add(RewardAndPunishProjectInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RewardAndPunishProjectCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RewardAndPunishProjectInfo item)
    {
        return removeObject(item);
    }
    public RewardAndPunishProjectInfo get(int index)
    {
        return(RewardAndPunishProjectInfo)getObject(index);
    }
    public RewardAndPunishProjectInfo get(Object key)
    {
        return(RewardAndPunishProjectInfo)getObject(key);
    }
    public void set(int index, RewardAndPunishProjectInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RewardAndPunishProjectInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RewardAndPunishProjectInfo item)
    {
        return super.indexOf(item);
    }
}