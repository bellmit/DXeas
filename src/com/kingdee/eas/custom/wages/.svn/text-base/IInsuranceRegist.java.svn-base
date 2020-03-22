package com.kingdee.eas.custom.wages;

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

public interface IInsuranceRegist extends ICoreBillBase
{
    public InsuranceRegistCollection getInsuranceRegistCollection() throws BOSException;
    public InsuranceRegistCollection getInsuranceRegistCollection(EntityViewInfo view) throws BOSException;
    public InsuranceRegistCollection getInsuranceRegistCollection(String oql) throws BOSException;
    public InsuranceRegistInfo getInsuranceRegistInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InsuranceRegistInfo getInsuranceRegistInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InsuranceRegistInfo getInsuranceRegistInfo(String oql) throws BOSException, EASBizException;
    public void audit(InsuranceRegistInfo model) throws BOSException;
    public void unaudit(InsuranceRegistInfo model) throws BOSException;
}