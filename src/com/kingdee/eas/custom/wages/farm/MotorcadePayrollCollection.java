package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MotorcadePayrollCollection extends AbstractObjectCollection 
{
    public MotorcadePayrollCollection()
    {
        super(MotorcadePayrollInfo.class);
    }
    public boolean add(MotorcadePayrollInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MotorcadePayrollCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MotorcadePayrollInfo item)
    {
        return removeObject(item);
    }
    public MotorcadePayrollInfo get(int index)
    {
        return(MotorcadePayrollInfo)getObject(index);
    }
    public MotorcadePayrollInfo get(Object key)
    {
        return(MotorcadePayrollInfo)getObject(key);
    }
    public void set(int index, MotorcadePayrollInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MotorcadePayrollInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MotorcadePayrollInfo item)
    {
        return super.indexOf(item);
    }
}