package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialStandardCostCostDetailEntryCollection extends AbstractObjectCollection 
{
    public MaterialStandardCostCostDetailEntryCollection()
    {
        super(MaterialStandardCostCostDetailEntryInfo.class);
    }
    public boolean add(MaterialStandardCostCostDetailEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialStandardCostCostDetailEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialStandardCostCostDetailEntryInfo item)
    {
        return removeObject(item);
    }
    public MaterialStandardCostCostDetailEntryInfo get(int index)
    {
        return(MaterialStandardCostCostDetailEntryInfo)getObject(index);
    }
    public MaterialStandardCostCostDetailEntryInfo get(Object key)
    {
        return(MaterialStandardCostCostDetailEntryInfo)getObject(key);
    }
    public void set(int index, MaterialStandardCostCostDetailEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialStandardCostCostDetailEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialStandardCostCostDetailEntryInfo item)
    {
        return super.indexOf(item);
    }
}