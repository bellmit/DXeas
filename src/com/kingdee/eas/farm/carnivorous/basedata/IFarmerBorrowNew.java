package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFarmerBorrowNew extends ICoreBillBase
{
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection() throws BOSException;
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection(EntityViewInfo view) throws BOSException;
    public FarmerBorrowNewCollection getFarmerBorrowNewCollection(String oql) throws BOSException;
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerBorrowNewInfo getFarmerBorrowNewInfo(String oql) throws BOSException, EASBizException;
    public void audit(FarmerBorrowNewInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerBorrowNewInfo model) throws BOSException, EASBizException;
}