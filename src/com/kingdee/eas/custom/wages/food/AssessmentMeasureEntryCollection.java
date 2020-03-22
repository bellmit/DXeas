package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AssessmentMeasureEntryCollection extends AbstractObjectCollection 
{
    public AssessmentMeasureEntryCollection()
    {
        super(AssessmentMeasureEntryInfo.class);
    }
    public boolean add(AssessmentMeasureEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AssessmentMeasureEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AssessmentMeasureEntryInfo item)
    {
        return removeObject(item);
    }
    public AssessmentMeasureEntryInfo get(int index)
    {
        return(AssessmentMeasureEntryInfo)getObject(index);
    }
    public AssessmentMeasureEntryInfo get(Object key)
    {
        return(AssessmentMeasureEntryInfo)getObject(key);
    }
    public void set(int index, AssessmentMeasureEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AssessmentMeasureEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AssessmentMeasureEntryInfo item)
    {
        return super.indexOf(item);
    }
}