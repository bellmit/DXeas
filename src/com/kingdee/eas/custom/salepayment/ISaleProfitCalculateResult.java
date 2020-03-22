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

public interface ISaleProfitCalculateResult extends ICoreBillBase
{
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection() throws BOSException;
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection(EntityViewInfo view) throws BOSException;
    public SaleProfitCalculateResultCollection getSaleProfitCalculateResultCollection(String oql) throws BOSException;
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleProfitCalculateResultInfo getSaleProfitCalculateResultInfo(String oql) throws BOSException, EASBizException;
}