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

public interface IHatchAssess extends ICoreBillBase
{
    public HatchAssessCollection getHatchAssessCollection() throws BOSException;
    public HatchAssessCollection getHatchAssessCollection(EntityViewInfo view) throws BOSException;
    public HatchAssessCollection getHatchAssessCollection(String oql) throws BOSException;
    public HatchAssessInfo getHatchAssessInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchAssessInfo getHatchAssessInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchAssessInfo getHatchAssessInfo(String oql) throws BOSException, EASBizException;
    public void audit(HatchAssessInfo model) throws BOSException;
    public void unaudit(HatchAssessInfo model) throws BOSException;
}