package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialConversionCollection extends AbstractObjectCollection 
{
    public MaterialConversionCollection()
    {
        super(MaterialConversionInfo.class);
    }
    public boolean add(MaterialConversionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialConversionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialConversionInfo item)
    {
        return removeObject(item);
    }
    public MaterialConversionInfo get(int index)
    {
        return(MaterialConversionInfo)getObject(index);
    }
    public MaterialConversionInfo get(Object key)
    {
        return(MaterialConversionInfo)getObject(key);
    }
    public void set(int index, MaterialConversionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialConversionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialConversionInfo item)
    {
        return super.indexOf(item);
    }
}