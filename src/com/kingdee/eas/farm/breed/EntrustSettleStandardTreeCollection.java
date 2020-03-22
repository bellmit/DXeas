package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EntrustSettleStandardTreeCollection extends AbstractObjectCollection 
{
    public EntrustSettleStandardTreeCollection()
    {
        super(EntrustSettleStandardTreeInfo.class);
    }
    public boolean add(EntrustSettleStandardTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EntrustSettleStandardTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EntrustSettleStandardTreeInfo item)
    {
        return removeObject(item);
    }
    public EntrustSettleStandardTreeInfo get(int index)
    {
        return(EntrustSettleStandardTreeInfo)getObject(index);
    }
    public EntrustSettleStandardTreeInfo get(Object key)
    {
        return(EntrustSettleStandardTreeInfo)getObject(key);
    }
    public void set(int index, EntrustSettleStandardTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EntrustSettleStandardTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EntrustSettleStandardTreeInfo item)
    {
        return super.indexOf(item);
    }
}