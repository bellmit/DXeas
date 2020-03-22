package com.kingdee.eas.custom.salepayment;

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

public interface IGrossProfitInfo extends ICoreBillBase
{
    public GrossProfitInfoCollection getGrossProfitInfoCollection() throws BOSException;
    public GrossProfitInfoCollection getGrossProfitInfoCollection(EntityViewInfo view) throws BOSException;
    public GrossProfitInfoCollection getGrossProfitInfoCollection(String oql) throws BOSException;
    public GrossProfitInfoInfo getGrossProfitInfoInfo(IObjectPK pk) throws BOSException, EASBizException;
    public GrossProfitInfoInfo getGrossProfitInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public GrossProfitInfoInfo getGrossProfitInfoInfo(String oql) throws BOSException, EASBizException;
}