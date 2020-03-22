package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface ICKWeightBill extends ICoreBillBase
{
    public CKWeightBillCollection getCKWeightBillCollection() throws BOSException;
    public CKWeightBillCollection getCKWeightBillCollection(EntityViewInfo view) throws BOSException;
    public CKWeightBillCollection getCKWeightBillCollection(String oql) throws BOSException;
    public CKWeightBillInfo getCKWeightBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKWeightBillInfo getCKWeightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKWeightBillInfo getCKWeightBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CKWeightBillInfo model) throws BOSException;
    public void unAudit(CKWeightBillInfo model) throws BOSException;
    public void updateSourceBill(CKWeightBillInfo model) throws BOSException;
}