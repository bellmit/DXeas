package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchTreeCollection extends AbstractObjectCollection 
{
    public BatchTreeCollection()
    {
        super(BatchTreeInfo.class);
    }
    public boolean add(BatchTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchTreeInfo item)
    {
        return removeObject(item);
    }
    public BatchTreeInfo get(int index)
    {
        return(BatchTreeInfo)getObject(index);
    }
    public BatchTreeInfo get(Object key)
    {
        return(BatchTreeInfo)getObject(key);
    }
    public void set(int index, BatchTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchTreeInfo item)
    {
        return super.indexOf(item);
    }
}