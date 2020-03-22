package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class GrossProfitInfoCollection extends AbstractObjectCollection 
{
    public GrossProfitInfoCollection()
    {
        super(GrossProfitInfoInfo.class);
    }
    public boolean add(GrossProfitInfoInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(GrossProfitInfoCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(GrossProfitInfoInfo item)
    {
        return removeObject(item);
    }
    public GrossProfitInfoInfo get(int index)
    {
        return(GrossProfitInfoInfo)getObject(index);
    }
    public GrossProfitInfoInfo get(Object key)
    {
        return(GrossProfitInfoInfo)getObject(key);
    }
    public void set(int index, GrossProfitInfoInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(GrossProfitInfoInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(GrossProfitInfoInfo item)
    {
        return super.indexOf(item);
    }
}