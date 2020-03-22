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

public interface ICompanyMonthFee extends ICoreBillBase
{
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection() throws BOSException;
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection(EntityViewInfo view) throws BOSException;
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection(String oql) throws BOSException;
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(String oql) throws BOSException, EASBizException;
}