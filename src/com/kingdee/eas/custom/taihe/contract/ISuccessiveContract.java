package com.kingdee.eas.custom.taihe.contract;

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

public interface ISuccessiveContract extends ICoreBillBase
{
    public SuccessiveContractCollection getSuccessiveContractCollection() throws BOSException;
    public SuccessiveContractCollection getSuccessiveContractCollection(EntityViewInfo view) throws BOSException;
    public SuccessiveContractCollection getSuccessiveContractCollection(String oql) throws BOSException;
    public SuccessiveContractInfo getSuccessiveContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SuccessiveContractInfo getSuccessiveContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SuccessiveContractInfo getSuccessiveContractInfo(String oql) throws BOSException, EASBizException;
    public void balanceBond(SuccessiveContractInfo model) throws BOSException;
    public void viewOtherContract(SuccessiveContractInfo model) throws BOSException;
    public void audit(SuccessiveContractInfo model) throws BOSException, EASBizException;
    public void unAudit(SuccessiveContractInfo model) throws BOSException, EASBizException;
}