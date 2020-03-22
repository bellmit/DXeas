package com.kingdee.eas.farm.breed.layegg;

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

public interface ILifeFee extends ICoreBillBase
{
    public LifeFeeCollection getLifeFeeCollection() throws BOSException;
    public LifeFeeCollection getLifeFeeCollection(EntityViewInfo view) throws BOSException;
    public LifeFeeCollection getLifeFeeCollection(String oql) throws BOSException;
    public LifeFeeInfo getLifeFeeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LifeFeeInfo getLifeFeeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LifeFeeInfo getLifeFeeInfo(String oql) throws BOSException, EASBizException;
    public void audit(LifeFeeInfo model) throws BOSException, EASBizException;
    public void unAudit(LifeFeeInfo model) throws BOSException, EASBizException;
}