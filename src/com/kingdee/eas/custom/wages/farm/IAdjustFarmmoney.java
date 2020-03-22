package com.kingdee.eas.custom.wages.farm;

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

public interface IAdjustFarmmoney extends ICoreBillBase
{
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection() throws BOSException;
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection(EntityViewInfo view) throws BOSException;
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection(String oql) throws BOSException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(String oql) throws BOSException, EASBizException;
    public void audit(AdjustFarmmoneyInfo model) throws BOSException;
    public void unaudit(AdjustFarmmoneyInfo model) throws BOSException;
}