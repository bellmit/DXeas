package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MotorcadePayrollEntryCollection extends AbstractObjectCollection 
{
    public MotorcadePayrollEntryCollection()
    {
        super(MotorcadePayrollEntryInfo.class);
    }
    public boolean add(MotorcadePayrollEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MotorcadePayrollEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MotorcadePayrollEntryInfo item)
    {
        return removeObject(item);
    }
    public MotorcadePayrollEntryInfo get(int index)
    {
        return(MotorcadePayrollEntryInfo)getObject(index);
    }
    public MotorcadePayrollEntryInfo get(Object key)
    {
        return(MotorcadePayrollEntryInfo)getObject(key);
    }
    public void set(int index, MotorcadePayrollEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MotorcadePayrollEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MotorcadePayrollEntryInfo item)
    {
        return super.indexOf(item);
    }
}