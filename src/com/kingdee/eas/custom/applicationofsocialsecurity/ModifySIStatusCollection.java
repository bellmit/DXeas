package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ModifySIStatusCollection extends AbstractObjectCollection 
{
    public ModifySIStatusCollection()
    {
        super(ModifySIStatusInfo.class);
    }
    public boolean add(ModifySIStatusInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ModifySIStatusCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ModifySIStatusInfo item)
    {
        return removeObject(item);
    }
    public ModifySIStatusInfo get(int index)
    {
        return(ModifySIStatusInfo)getObject(index);
    }
    public ModifySIStatusInfo get(Object key)
    {
        return(ModifySIStatusInfo)getObject(key);
    }
    public void set(int index, ModifySIStatusInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ModifySIStatusInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ModifySIStatusInfo item)
    {
        return super.indexOf(item);
    }
}