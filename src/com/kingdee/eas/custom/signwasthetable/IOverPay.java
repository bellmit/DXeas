package com.kingdee.eas.custom.signwasthetable;

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

public interface IOverPay extends ICoreBillBase
{
    public OverPayCollection getOverPayCollection() throws BOSException;
    public OverPayCollection getOverPayCollection(EntityViewInfo view) throws BOSException;
    public OverPayCollection getOverPayCollection(String oql) throws BOSException;
    public OverPayInfo getOverPayInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OverPayInfo getOverPayInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OverPayInfo getOverPayInfo(String oql) throws BOSException, EASBizException;
    public void viewSrcBill(OverPayInfo model) throws BOSException;
    public void audit(OverPayInfo model) throws BOSException;
    public void unAudit(OverPayInfo model) throws BOSException;
}