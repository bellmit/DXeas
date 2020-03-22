package com.kingdee.eas.farm.stocking.basedata;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IOtherPaymentType extends IDataBase
{
    public OtherPaymentTypeInfo getOtherPaymentTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OtherPaymentTypeInfo getOtherPaymentTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OtherPaymentTypeInfo getOtherPaymentTypeInfo(String oql) throws BOSException, EASBizException;
    public OtherPaymentTypeCollection getOtherPaymentTypeCollection() throws BOSException;
    public OtherPaymentTypeCollection getOtherPaymentTypeCollection(EntityViewInfo view) throws BOSException;
    public OtherPaymentTypeCollection getOtherPaymentTypeCollection(String oql) throws BOSException;
    public void audit(OtherPaymentTypeInfo model) throws BOSException, EASBizException;
    public void unAudit(OtherPaymentTypeInfo model) throws BOSException, EASBizException;
}