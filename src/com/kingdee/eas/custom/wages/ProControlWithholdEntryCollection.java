package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProControlWithholdEntryCollection extends AbstractObjectCollection 
{
    public ProControlWithholdEntryCollection()
    {
        super(ProControlWithholdEntryInfo.class);
    }
    public boolean add(ProControlWithholdEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProControlWithholdEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProControlWithholdEntryInfo item)
    {
        return removeObject(item);
    }
    public ProControlWithholdEntryInfo get(int index)
    {
        return(ProControlWithholdEntryInfo)getObject(index);
    }
    public ProControlWithholdEntryInfo get(Object key)
    {
        return(ProControlWithholdEntryInfo)getObject(key);
    }
    public void set(int index, ProControlWithholdEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProControlWithholdEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProControlWithholdEntryInfo item)
    {
        return super.indexOf(item);
    }
}