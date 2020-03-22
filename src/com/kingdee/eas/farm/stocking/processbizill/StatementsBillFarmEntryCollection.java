package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StatementsBillFarmEntryCollection extends AbstractObjectCollection 
{
    public StatementsBillFarmEntryCollection()
    {
        super(StatementsBillFarmEntryInfo.class);
    }
    public boolean add(StatementsBillFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StatementsBillFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StatementsBillFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public StatementsBillFarmEntryInfo get(int index)
    {
        return(StatementsBillFarmEntryInfo)getObject(index);
    }
    public StatementsBillFarmEntryInfo get(Object key)
    {
        return(StatementsBillFarmEntryInfo)getObject(key);
    }
    public void set(int index, StatementsBillFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StatementsBillFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StatementsBillFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}