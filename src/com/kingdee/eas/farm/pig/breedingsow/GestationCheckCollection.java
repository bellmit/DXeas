package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class GestationCheckCollection extends AbstractObjectCollection 
{
    public GestationCheckCollection()
    {
        super(GestationCheckInfo.class);
    }
    public boolean add(GestationCheckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(GestationCheckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(GestationCheckInfo item)
    {
        return removeObject(item);
    }
    public GestationCheckInfo get(int index)
    {
        return(GestationCheckInfo)getObject(index);
    }
    public GestationCheckInfo get(Object key)
    {
        return(GestationCheckInfo)getObject(key);
    }
    public void set(int index, GestationCheckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(GestationCheckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(GestationCheckInfo item)
    {
        return super.indexOf(item);
    }
}