package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface ICTransDrugBill extends ICoreBillBase
{
    public CTransDrugBillCollection getCTransDrugBillCollection() throws BOSException;
    public CTransDrugBillCollection getCTransDrugBillCollection(EntityViewInfo view) throws BOSException;
    public CTransDrugBillCollection getCTransDrugBillCollection(String oql) throws BOSException;
    public CTransDrugBillInfo getCTransDrugBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CTransDrugBillInfo getCTransDrugBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CTransDrugBillInfo getCTransDrugBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CTransDrugBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CTransDrugBillInfo model) throws BOSException, EASBizException;
}