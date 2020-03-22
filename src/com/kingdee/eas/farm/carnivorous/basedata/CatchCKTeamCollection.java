package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CatchCKTeamCollection extends AbstractObjectCollection 
{
    public CatchCKTeamCollection()
    {
        super(CatchCKTeamInfo.class);
    }
    public boolean add(CatchCKTeamInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CatchCKTeamCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CatchCKTeamInfo item)
    {
        return removeObject(item);
    }
    public CatchCKTeamInfo get(int index)
    {
        return(CatchCKTeamInfo)getObject(index);
    }
    public CatchCKTeamInfo get(Object key)
    {
        return(CatchCKTeamInfo)getObject(key);
    }
    public void set(int index, CatchCKTeamInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CatchCKTeamInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CatchCKTeamInfo item)
    {
        return super.indexOf(item);
    }
}