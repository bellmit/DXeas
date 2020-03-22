package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class MaterialConversionInfo extends AbstractMaterialConversionInfo implements Serializable 
{
    public MaterialConversionInfo()
    {
        super();
    }
    protected MaterialConversionInfo(String pkField)
    {
        super(pkField);
    }
}