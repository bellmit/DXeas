package com.kingdee.eas.farm.feemanager.basedata;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IOilStandPrice extends IDataBase
{
    public OilStandPriceInfo getOilStandPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OilStandPriceInfo getOilStandPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OilStandPriceInfo getOilStandPriceInfo(String oql) throws BOSException, EASBizException;
    public OilStandPriceCollection getOilStandPriceCollection() throws BOSException;
    public OilStandPriceCollection getOilStandPriceCollection(EntityViewInfo view) throws BOSException;
    public OilStandPriceCollection getOilStandPriceCollection(String oql) throws BOSException;
    public void review(OilStandPriceInfo model) throws BOSException;
    public void unreview(OilStandPriceInfo model) throws BOSException;
}