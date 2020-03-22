package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CompanyInvTreeCollection extends AbstractObjectCollection 
{
    public CompanyInvTreeCollection()
    {
        super(CompanyInvTreeInfo.class);
    }
    public boolean add(CompanyInvTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CompanyInvTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CompanyInvTreeInfo item)
    {
        return removeObject(item);
    }
    public CompanyInvTreeInfo get(int index)
    {
        return(CompanyInvTreeInfo)getObject(index);
    }
    public CompanyInvTreeInfo get(Object key)
    {
        return(CompanyInvTreeInfo)getObject(key);
    }
    public void set(int index, CompanyInvTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CompanyInvTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CompanyInvTreeInfo item)
    {
        return super.indexOf(item);
    }
}