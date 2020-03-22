package com.kingdee.eas.farm.breed;

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

public interface IMaterialApplyBill extends ICoreBillBase
{
    public MaterialApplyBillCollection getMaterialApplyBillCollection() throws BOSException;
    public MaterialApplyBillCollection getMaterialApplyBillCollection(EntityViewInfo view) throws BOSException;
    public MaterialApplyBillCollection getMaterialApplyBillCollection(String oql) throws BOSException;
    public MaterialApplyBillInfo getMaterialApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaterialApplyBillInfo getMaterialApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaterialApplyBillInfo getMaterialApplyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MaterialApplyBillInfo model) throws BOSException;
    public void unAudit(MaterialApplyBillInfo model) throws BOSException;
}