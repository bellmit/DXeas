package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProControlWithholdCollection extends AbstractObjectCollection 
{
    public ProControlWithholdCollection()
    {
        super(ProControlWithholdInfo.class);
    }
    public boolean add(ProControlWithholdInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProControlWithholdCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProControlWithholdInfo item)
    {
        return removeObject(item);
    }
    public ProControlWithholdInfo get(int index)
    {
        return(ProControlWithholdInfo)getObject(index);
    }
    public ProControlWithholdInfo get(Object key)
    {
        return(ProControlWithholdInfo)getObject(key);
    }
    public void set(int index, ProControlWithholdInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProControlWithholdInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProControlWithholdInfo item)
    {
        return super.indexOf(item);
    }
}