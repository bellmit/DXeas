package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IFarmerconfirm extends ICoreBillBase
{
    public FarmerconfirmCollection getFarmerconfirmCollection() throws BOSException;
    public FarmerconfirmCollection getFarmerconfirmCollection(EntityViewInfo view) throws BOSException;
    public FarmerconfirmCollection getFarmerconfirmCollection(String oql) throws BOSException;
    public FarmerconfirmInfo getFarmerconfirmInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerconfirmInfo getFarmerconfirmInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerconfirmInfo getFarmerconfirmInfo(String oql) throws BOSException, EASBizException;
}