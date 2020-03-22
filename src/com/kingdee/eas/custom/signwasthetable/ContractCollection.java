package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ContractCollection extends AbstractObjectCollection 
{
    public ContractCollection()
    {
        super(ContractInfo.class);
    }
    public boolean add(ContractInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ContractCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ContractInfo item)
    {
        return removeObject(item);
    }
    public ContractInfo get(int index)
    {
        return(ContractInfo)getObject(index);
    }
    public ContractInfo get(Object key)
    {
        return(ContractInfo)getObject(key);
    }
    public void set(int index, ContractInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ContractInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ContractInfo item)
    {
        return super.indexOf(item);
    }
}