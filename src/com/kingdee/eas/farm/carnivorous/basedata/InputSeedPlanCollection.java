package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InputSeedPlanCollection extends AbstractObjectCollection 
{
    public InputSeedPlanCollection()
    {
        super(InputSeedPlanInfo.class);
    }
    public boolean add(InputSeedPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InputSeedPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InputSeedPlanInfo item)
    {
        return removeObject(item);
    }
    public InputSeedPlanInfo get(int index)
    {
        return(InputSeedPlanInfo)getObject(index);
    }
    public InputSeedPlanInfo get(Object key)
    {
        return(InputSeedPlanInfo)getObject(key);
    }
    public void set(int index, InputSeedPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InputSeedPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InputSeedPlanInfo item)
    {
        return super.indexOf(item);
    }
}