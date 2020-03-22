package com.kingdee.eas.wlhlcomm.function;

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

public interface ITobeUpdateBills extends ICoreBillBase
{
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection() throws BOSException;
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection(EntityViewInfo view) throws BOSException;
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection(String oql) throws BOSException;
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(String oql) throws BOSException, EASBizException;
}