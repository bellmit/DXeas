package com.kingdee.eas.farm.stocking.hatch;

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

public interface IEggSettleBillCompany extends ICoreBillBase
{
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection() throws BOSException;
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection(EntityViewInfo view) throws BOSException;
    public EggSettleBillCompanyCollection getEggSettleBillCompanyCollection(String oql) throws BOSException;
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggSettleBillCompanyInfo getEggSettleBillCompanyInfo(String oql) throws BOSException, EASBizException;
    public void audit(EggSettleBillCompanyInfo model) throws BOSException;
    public void unAudit(EggSettleBillCompanyInfo model) throws BOSException;
    public void showPriceCol(EggSettleBillCompanyInfo model) throws BOSException;
    public void exeSettle(EggSettleBillCompanyInfo model) throws BOSException, EASBizException;
}