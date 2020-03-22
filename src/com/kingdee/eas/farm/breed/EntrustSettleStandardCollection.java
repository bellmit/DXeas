package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EntrustSettleStandardCollection extends AbstractObjectCollection 
{
    public EntrustSettleStandardCollection()
    {
        super(EntrustSettleStandardInfo.class);
    }
    public boolean add(EntrustSettleStandardInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EntrustSettleStandardCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EntrustSettleStandardInfo item)
    {
        return removeObject(item);
    }
    public EntrustSettleStandardInfo get(int index)
    {
        return(EntrustSettleStandardInfo)getObject(index);
    }
    public EntrustSettleStandardInfo get(Object key)
    {
        return(EntrustSettleStandardInfo)getObject(key);
    }
    public void set(int index, EntrustSettleStandardInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EntrustSettleStandardInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EntrustSettleStandardInfo item)
    {
        return super.indexOf(item);
    }
}