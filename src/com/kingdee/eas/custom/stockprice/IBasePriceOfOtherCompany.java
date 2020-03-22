package com.kingdee.eas.custom.stockprice;

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

public interface IBasePriceOfOtherCompany extends ICoreBillBase
{
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection() throws BOSException;
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(EntityViewInfo view) throws BOSException;
    public BasePriceOfOtherCompanyCollection getBasePriceOfOtherCompanyCollection(String oql) throws BOSException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BasePriceOfOtherCompanyInfo getBasePriceOfOtherCompanyInfo(String oql) throws BOSException, EASBizException;
    public void getAllMaterial(BasePriceOfOtherCompanyInfo model) throws BOSException;
    public void impExcel(BasePriceOfOtherCompanyInfo model) throws BOSException;
    public void expModel(BasePriceOfOtherCompanyInfo model) throws BOSException;
    public void audit(BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException;
    public void unAudit(BasePriceOfOtherCompanyInfo model) throws BOSException, EASBizException;
}