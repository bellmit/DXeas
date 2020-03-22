package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PurBudgetCollection extends AbstractObjectCollection 
{
    public PurBudgetCollection()
    {
        super(PurBudgetInfo.class);
    }
    public boolean add(PurBudgetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PurBudgetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PurBudgetInfo item)
    {
        return removeObject(item);
    }
    public PurBudgetInfo get(int index)
    {
        return(PurBudgetInfo)getObject(index);
    }
    public PurBudgetInfo get(Object key)
    {
        return(PurBudgetInfo)getObject(key);
    }
    public void set(int index, PurBudgetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PurBudgetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PurBudgetInfo item)
    {
        return super.indexOf(item);
    }
}