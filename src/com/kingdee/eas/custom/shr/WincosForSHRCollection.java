package com.kingdee.eas.custom.shr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WincosForSHRCollection extends AbstractObjectCollection 
{
    public WincosForSHRCollection()
    {
        super(WincosForSHRInfo.class);
    }
    public boolean add(WincosForSHRInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WincosForSHRCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WincosForSHRInfo item)
    {
        return removeObject(item);
    }
    public WincosForSHRInfo get(int index)
    {
        return(WincosForSHRInfo)getObject(index);
    }
    public WincosForSHRInfo get(Object key)
    {
        return(WincosForSHRInfo)getObject(key);
    }
    public void set(int index, WincosForSHRInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WincosForSHRInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WincosForSHRInfo item)
    {
        return super.indexOf(item);
    }
}