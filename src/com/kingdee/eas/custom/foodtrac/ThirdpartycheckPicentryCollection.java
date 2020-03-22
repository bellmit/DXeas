package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ThirdpartycheckPicentryCollection extends AbstractObjectCollection 
{
    public ThirdpartycheckPicentryCollection()
    {
        super(ThirdpartycheckPicentryInfo.class);
    }
    public boolean add(ThirdpartycheckPicentryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ThirdpartycheckPicentryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ThirdpartycheckPicentryInfo item)
    {
        return removeObject(item);
    }
    public ThirdpartycheckPicentryInfo get(int index)
    {
        return(ThirdpartycheckPicentryInfo)getObject(index);
    }
    public ThirdpartycheckPicentryInfo get(Object key)
    {
        return(ThirdpartycheckPicentryInfo)getObject(key);
    }
    public void set(int index, ThirdpartycheckPicentryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ThirdpartycheckPicentryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ThirdpartycheckPicentryInfo item)
    {
        return super.indexOf(item);
    }
}