package com.kingdee.eas.custom.taihe.weight;

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

public interface IInWgtBill extends ICoreBillBase
{
    public InWgtBillCollection getInWgtBillCollection() throws BOSException;
    public InWgtBillCollection getInWgtBillCollection(EntityViewInfo view) throws BOSException;
    public InWgtBillCollection getInWgtBillCollection(String oql) throws BOSException;
    public InWgtBillInfo getInWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InWgtBillInfo getInWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InWgtBillInfo getInWgtBillInfo(String oql) throws BOSException, EASBizException;
}