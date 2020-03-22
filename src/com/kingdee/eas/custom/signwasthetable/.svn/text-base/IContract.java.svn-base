package com.kingdee.eas.custom.signwasthetable;

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

public interface IContract extends ICoreBillBase
{
    public ContractCollection getContractCollection() throws BOSException;
    public ContractCollection getContractCollection(EntityViewInfo view) throws BOSException;
    public ContractCollection getContractCollection(String oql) throws BOSException;
    public ContractInfo getContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ContractInfo getContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ContractInfo getContractInfo(String oql) throws BOSException, EASBizException;
    public void audit(ContractInfo model) throws BOSException, EASBizException;
    public void unAudit(ContractInfo model) throws BOSException, EASBizException;
    public void cmChange(ContractInfo model) throws BOSException;
    public void upVersion(ContractInfo model) throws BOSException;
    public void toPayReq(ContractInfo model) throws BOSException;
    public void viewHistory(ContractInfo model) throws BOSException;
    public void initial(ContractInfo model) throws BOSException;
    public void refresh(ContractInfo model) throws BOSException;
    public void setBailDays(ContractInfo model) throws BOSException;
    public void overPay(ContractInfo model) throws BOSException;
    public void overView(ContractInfo model) throws BOSException;
}