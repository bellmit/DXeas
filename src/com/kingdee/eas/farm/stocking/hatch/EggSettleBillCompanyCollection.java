package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettleBillCompanyCollection extends AbstractObjectCollection 
{
    public EggSettleBillCompanyCollection()
    {
        super(EggSettleBillCompanyInfo.class);
    }
    public boolean add(EggSettleBillCompanyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettleBillCompanyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettleBillCompanyInfo item)
    {
        return removeObject(item);
    }
    public EggSettleBillCompanyInfo get(int index)
    {
        return(EggSettleBillCompanyInfo)getObject(index);
    }
    public EggSettleBillCompanyInfo get(Object key)
    {
        return(EggSettleBillCompanyInfo)getObject(key);
    }
    public void set(int index, EggSettleBillCompanyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettleBillCompanyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettleBillCompanyInfo item)
    {
        return super.indexOf(item);
    }
}