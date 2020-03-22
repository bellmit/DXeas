package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class PersonFarmerRelationInfo extends AbstractPersonFarmerRelationInfo implements Serializable 
{
    public PersonFarmerRelationInfo()
    {
        super();
    }
    protected PersonFarmerRelationInfo(String pkField)
    {
        super(pkField);
    }
}