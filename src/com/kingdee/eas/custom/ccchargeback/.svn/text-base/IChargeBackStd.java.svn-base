package com.kingdee.eas.custom.ccchargeback;

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

public interface IChargeBackStd extends IDataBase
{
    public ChargeBackStdInfo getChargeBackStdInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ChargeBackStdInfo getChargeBackStdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ChargeBackStdInfo getChargeBackStdInfo(String oql) throws BOSException, EASBizException;
    public ChargeBackStdCollection getChargeBackStdCollection() throws BOSException;
    public ChargeBackStdCollection getChargeBackStdCollection(EntityViewInfo view) throws BOSException;
    public ChargeBackStdCollection getChargeBackStdCollection(String oql) throws BOSException;
    public void audit(ChargeBackStdInfo model) throws BOSException, EASBizException;
    public void unAudit(ChargeBackStdInfo model) throws BOSException, EASBizException;
}