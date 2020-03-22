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

public interface IDrugReceiveBill extends ICoreBillBase
{
    public DrugReceiveBillCollection getDrugReceiveBillCollection() throws BOSException;
    public DrugReceiveBillCollection getDrugReceiveBillCollection(EntityViewInfo view) throws BOSException;
    public DrugReceiveBillCollection getDrugReceiveBillCollection(String oql) throws BOSException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DrugReceiveBillInfo getDrugReceiveBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(DrugReceiveBillInfo model) throws BOSException, EASBizException;
    public void unAudit(DrugReceiveBillInfo model) throws BOSException, EASBizException;
    public void chkVoucherAll(DrugReceiveBillInfo model) throws BOSException;
    public void chkVoucherFlag(DrugReceiveBillInfo model) throws BOSException;
    public void close(DrugReceiveBillInfo model) throws BOSException, EASBizException;
    public void unClose(DrugReceiveBillInfo model) throws BOSException, EASBizException;
}