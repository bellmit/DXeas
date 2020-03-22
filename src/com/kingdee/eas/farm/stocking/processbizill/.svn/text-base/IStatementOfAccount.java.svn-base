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

public interface IStatementOfAccount extends ICoreBillBase
{
    public StatementOfAccountCollection getStatementOfAccountCollection() throws BOSException;
    public StatementOfAccountCollection getStatementOfAccountCollection(EntityViewInfo view) throws BOSException;
    public StatementOfAccountCollection getStatementOfAccountCollection(String oql) throws BOSException;
    public StatementOfAccountInfo getStatementOfAccountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StatementOfAccountInfo getStatementOfAccountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StatementOfAccountInfo getStatementOfAccountInfo(String oql) throws BOSException, EASBizException;
}