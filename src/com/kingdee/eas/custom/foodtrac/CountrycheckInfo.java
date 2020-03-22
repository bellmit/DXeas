package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;

public class CountrycheckInfo extends AbstractCountrycheckInfo implements Serializable 
{
    public CountrycheckInfo()
    {
        super();
    }
    protected CountrycheckInfo(String pkField)
    {
        super(pkField);
    }
}