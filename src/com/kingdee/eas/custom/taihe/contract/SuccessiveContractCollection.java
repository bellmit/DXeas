package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SuccessiveContractCollection extends AbstractObjectCollection 
{
    public SuccessiveContractCollection()
    {
        super(SuccessiveContractInfo.class);
    }
    public boolean add(SuccessiveContractInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SuccessiveContractCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SuccessiveContractInfo item)
    {
        return removeObject(item);
    }
    public SuccessiveContractInfo get(int index)
    {
        return(SuccessiveContractInfo)getObject(index);
    }
    public SuccessiveContractInfo get(Object key)
    {
        return(SuccessiveContractInfo)getObject(key);
    }
    public void set(int index, SuccessiveContractInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SuccessiveContractInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SuccessiveContractInfo item)
    {
        return super.indexOf(item);
    }
}