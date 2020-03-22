package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ContractEntryCollection extends AbstractObjectCollection 
{
    public ContractEntryCollection()
    {
        super(ContractEntryInfo.class);
    }
    public boolean add(ContractEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ContractEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ContractEntryInfo item)
    {
        return removeObject(item);
    }
    public ContractEntryInfo get(int index)
    {
        return(ContractEntryInfo)getObject(index);
    }
    public ContractEntryInfo get(Object key)
    {
        return(ContractEntryInfo)getObject(key);
    }
    public void set(int index, ContractEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ContractEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ContractEntryInfo item)
    {
        return super.indexOf(item);
    }
}