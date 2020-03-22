package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICountrycheck extends ICoreBillBase
{
    public CountrycheckCollection getCountrycheckCollection() throws BOSException;
    public CountrycheckCollection getCountrycheckCollection(EntityViewInfo view) throws BOSException;
    public CountrycheckCollection getCountrycheckCollection(String oql) throws BOSException;
    public CountrycheckInfo getCountrycheckInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CountrycheckInfo getCountrycheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CountrycheckInfo getCountrycheckInfo(String oql) throws BOSException, EASBizException;
}