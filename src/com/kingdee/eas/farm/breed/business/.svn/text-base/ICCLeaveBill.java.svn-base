package com.kingdee.eas.farm.breed.business;

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

public interface ICCLeaveBill extends ICoreBillBase
{
    public CCLeaveBillCollection getCCLeaveBillCollection() throws BOSException;
    public CCLeaveBillCollection getCCLeaveBillCollection(EntityViewInfo view) throws BOSException;
    public CCLeaveBillCollection getCCLeaveBillCollection(String oql) throws BOSException;
    public CCLeaveBillInfo getCCLeaveBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCLeaveBillInfo getCCLeaveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCLeaveBillInfo getCCLeaveBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CCLeaveBillInfo model) throws BOSException;
    public void unAudit(CCLeaveBillInfo model) throws BOSException;
}