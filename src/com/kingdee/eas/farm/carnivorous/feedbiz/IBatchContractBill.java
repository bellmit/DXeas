package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IBatchContractBill extends ICoreBillBase
{
    public BatchContractBillCollection getBatchContractBillCollection() throws BOSException;
    public BatchContractBillCollection getBatchContractBillCollection(EntityViewInfo view) throws BOSException;
    public BatchContractBillCollection getBatchContractBillCollection(String oql) throws BOSException;
    public BatchContractBillInfo getBatchContractBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchContractBillInfo getBatchContractBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchContractBillInfo getBatchContractBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BatchContractBillInfo model) throws BOSException, EASBizException;
    public void unAudit(BatchContractBillInfo model) throws BOSException, EASBizException;
    public void isTemplate(BatchContractBillInfo model) throws BOSException;
    public void isInit(BatchContractBillInfo model) throws BOSException;
    public void viewGuaranteeBill(BatchContractBillInfo model) throws BOSException;
    public void revoke(BatchContractBillInfo model) throws BOSException, EASBizException;
    public void changeIsFeedBig(IObjectValue model) throws BOSException, EASBizException;
}