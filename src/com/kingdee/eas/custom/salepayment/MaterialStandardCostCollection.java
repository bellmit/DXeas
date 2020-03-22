package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialStandardCostCollection extends AbstractObjectCollection 
{
    public MaterialStandardCostCollection()
    {
        super(MaterialStandardCostInfo.class);
    }
    public boolean add(MaterialStandardCostInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialStandardCostCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialStandardCostInfo item)
    {
        return removeObject(item);
    }
    public MaterialStandardCostInfo get(int index)
    {
        return(MaterialStandardCostInfo)getObject(index);
    }
    public MaterialStandardCostInfo get(Object key)
    {
        return(MaterialStandardCostInfo)getObject(key);
    }
    public void set(int index, MaterialStandardCostInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialStandardCostInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialStandardCostInfo item)
    {
        return super.indexOf(item);
    }
}