package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HospitalCollection extends AbstractObjectCollection 
{
    public HospitalCollection()
    {
        super(HospitalInfo.class);
    }
    public boolean add(HospitalInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HospitalCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HospitalInfo item)
    {
        return removeObject(item);
    }
    public HospitalInfo get(int index)
    {
        return(HospitalInfo)getObject(index);
    }
    public HospitalInfo get(Object key)
    {
        return(HospitalInfo)getObject(key);
    }
    public void set(int index, HospitalInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HospitalInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HospitalInfo item)
    {
        return super.indexOf(item);
    }
}