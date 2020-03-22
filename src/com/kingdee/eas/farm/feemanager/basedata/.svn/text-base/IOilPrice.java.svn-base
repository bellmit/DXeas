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

public interface IOilPrice extends IDataBase
{
    public OilPriceInfo getOilPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OilPriceInfo getOilPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OilPriceInfo getOilPriceInfo(String oql) throws BOSException, EASBizException;
    public OilPriceCollection getOilPriceCollection() throws BOSException;
    public OilPriceCollection getOilPriceCollection(EntityViewInfo view) throws BOSException;
    public OilPriceCollection getOilPriceCollection(String oql) throws BOSException;
    public void review(OilPriceInfo model) throws BOSException;
    public void unreview(OilPriceInfo model) throws BOSException;
}