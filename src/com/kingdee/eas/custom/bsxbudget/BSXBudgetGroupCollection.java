package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BSXBudgetGroupCollection extends AbstractObjectCollection 
{
    public BSXBudgetGroupCollection()
    {
        super(BSXBudgetGroupInfo.class);
    }
    public boolean add(BSXBudgetGroupInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BSXBudgetGroupCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BSXBudgetGroupInfo item)
    {
        return removeObject(item);
    }
    public BSXBudgetGroupInfo get(int index)
    {
        return(BSXBudgetGroupInfo)getObject(index);
    }
    public BSXBudgetGroupInfo get(Object key)
    {
        return(BSXBudgetGroupInfo)getObject(key);
    }
    public void set(int index, BSXBudgetGroupInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BSXBudgetGroupInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BSXBudgetGroupInfo item)
    {
        return super.indexOf(item);
    }
}