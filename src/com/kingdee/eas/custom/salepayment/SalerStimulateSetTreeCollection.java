package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalerStimulateSetTreeCollection extends AbstractObjectCollection 
{
    public SalerStimulateSetTreeCollection()
    {
        super(SalerStimulateSetTreeInfo.class);
    }
    public boolean add(SalerStimulateSetTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalerStimulateSetTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalerStimulateSetTreeInfo item)
    {
        return removeObject(item);
    }
    public SalerStimulateSetTreeInfo get(int index)
    {
        return(SalerStimulateSetTreeInfo)getObject(index);
    }
    public SalerStimulateSetTreeInfo get(Object key)
    {
        return(SalerStimulateSetTreeInfo)getObject(key);
    }
    public void set(int index, SalerStimulateSetTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalerStimulateSetTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalerStimulateSetTreeInfo item)
    {
        return super.indexOf(item);
    }
}