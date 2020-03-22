package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BSXBudgetFoodCollection extends AbstractObjectCollection 
{
    public BSXBudgetFoodCollection()
    {
        super(BSXBudgetFoodInfo.class);
    }
    public boolean add(BSXBudgetFoodInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BSXBudgetFoodCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BSXBudgetFoodInfo item)
    {
        return removeObject(item);
    }
    public BSXBudgetFoodInfo get(int index)
    {
        return(BSXBudgetFoodInfo)getObject(index);
    }
    public BSXBudgetFoodInfo get(Object key)
    {
        return(BSXBudgetFoodInfo)getObject(key);
    }
    public void set(int index, BSXBudgetFoodInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BSXBudgetFoodInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BSXBudgetFoodInfo item)
    {
        return super.indexOf(item);
    }
}