package com.kingdee.eas.publicdata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CardReaderCollection extends AbstractObjectCollection 
{
    public CardReaderCollection()
    {
        super(CardReaderInfo.class);
    }
    public boolean add(CardReaderInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CardReaderCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CardReaderInfo item)
    {
        return removeObject(item);
    }
    public CardReaderInfo get(int index)
    {
        return(CardReaderInfo)getObject(index);
    }
    public CardReaderInfo get(Object key)
    {
        return(CardReaderInfo)getObject(key);
    }
    public void set(int index, CardReaderInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CardReaderInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CardReaderInfo item)
    {
        return super.indexOf(item);
    }
}