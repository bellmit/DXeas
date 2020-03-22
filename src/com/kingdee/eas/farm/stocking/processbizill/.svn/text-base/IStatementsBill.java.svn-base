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

public interface IStatementsBill extends ICoreBillBase
{
    public StatementsBillCollection getStatementsBillCollection() throws BOSException;
    public StatementsBillCollection getStatementsBillCollection(EntityViewInfo view) throws BOSException;
    public StatementsBillCollection getStatementsBillCollection(String oql) throws BOSException;
    public StatementsBillInfo getStatementsBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StatementsBillInfo getStatementsBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StatementsBillInfo getStatementsBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(StatementsBillInfo model) throws BOSException;
    public void unAudit(StatementsBillInfo model) throws BOSException;
    public Object btnExeCal(StatementsBillInfo model) throws BOSException, EASBizException;
    public Object exeAllCal(Object param) throws BOSException, EASBizException;
    public void multiSubmit(StatementsBillInfo model) throws BOSException;
    public void breateBill(StatementsBillInfo model) throws BOSException;
    public void calYC(StatementsBillInfo model) throws BOSException;
    public void carryover(StatementsBillInfo model) throws BOSException;
}