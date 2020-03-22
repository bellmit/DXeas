package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettleBillCompanyEntryCollection extends AbstractObjectCollection 
{
    public EggSettleBillCompanyEntryCollection()
    {
        super(EggSettleBillCompanyEntryInfo.class);
    }
    public boolean add(EggSettleBillCompanyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettleBillCompanyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettleBillCompanyEntryInfo item)
    {
        return removeObject(item);
    }
    public EggSettleBillCompanyEntryInfo get(int index)
    {
        return(EggSettleBillCompanyEntryInfo)getObject(index);
    }
    public EggSettleBillCompanyEntryInfo get(Object key)
    {
        return(EggSettleBillCompanyEntryInfo)getObject(key);
    }
    public void set(int index, EggSettleBillCompanyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettleBillCompanyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettleBillCompanyEntryInfo item)
    {
        return super.indexOf(item);
    }
}