package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ApplicationOfSocialSecurityCollection extends AbstractObjectCollection 
{
    public ApplicationOfSocialSecurityCollection()
    {
        super(ApplicationOfSocialSecurityInfo.class);
    }
    public boolean add(ApplicationOfSocialSecurityInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ApplicationOfSocialSecurityCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ApplicationOfSocialSecurityInfo item)
    {
        return removeObject(item);
    }
    public ApplicationOfSocialSecurityInfo get(int index)
    {
        return(ApplicationOfSocialSecurityInfo)getObject(index);
    }
    public ApplicationOfSocialSecurityInfo get(Object key)
    {
        return(ApplicationOfSocialSecurityInfo)getObject(key);
    }
    public void set(int index, ApplicationOfSocialSecurityInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ApplicationOfSocialSecurityInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ApplicationOfSocialSecurityInfo item)
    {
        return super.indexOf(item);
    }
}