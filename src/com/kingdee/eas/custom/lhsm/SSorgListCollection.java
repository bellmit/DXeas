package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SSorgListCollection extends AbstractObjectCollection 
{
    public SSorgListCollection()
    {
        super(SSorgListInfo.class);
    }
    public boolean add(SSorgListInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SSorgListCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SSorgListInfo item)
    {
        return removeObject(item);
    }
    public SSorgListInfo get(int index)
    {
        return(SSorgListInfo)getObject(index);
    }
    public SSorgListInfo get(Object key)
    {
        return(SSorgListInfo)getObject(key);
    }
    public void set(int index, SSorgListInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SSorgListInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SSorgListInfo item)
    {
        return super.indexOf(item);
    }
}