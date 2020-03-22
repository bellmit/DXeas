package com.kingdee.eas.custom.eas2temp;

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

public interface IMMPlan extends ICoreBillBase
{
    public MMPlanCollection getMMPlanCollection() throws BOSException;
    public MMPlanCollection getMMPlanCollection(EntityViewInfo view) throws BOSException;
    public MMPlanCollection getMMPlanCollection(String oql) throws BOSException;
    public MMPlanInfo getMMPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MMPlanInfo getMMPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MMPlanInfo getMMPlanInfo(String oql) throws BOSException, EASBizException;
    public void audit(MMPlanInfo model) throws BOSException;
    public void unAudit(MMPlanInfo model) throws BOSException;
    public void mmPlanOPUI(MMPlanInfo model) throws BOSException;
}