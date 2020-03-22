package com.kingdee.eas.farm.stocking.assistfunction;

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

public interface ISettleBillPrintCount extends ICoreBillBase
{
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection() throws BOSException;
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(EntityViewInfo view) throws BOSException;
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(String oql) throws BOSException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(String oql) throws BOSException, EASBizException;
}