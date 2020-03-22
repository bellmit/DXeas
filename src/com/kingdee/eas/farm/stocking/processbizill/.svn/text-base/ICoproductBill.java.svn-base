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

public interface ICoproductBill extends ICoreBillBase
{
    public CoproductBillCollection getCoproductBillCollection() throws BOSException;
    public CoproductBillCollection getCoproductBillCollection(EntityViewInfo view) throws BOSException;
    public CoproductBillCollection getCoproductBillCollection(String oql) throws BOSException;
    public CoproductBillInfo getCoproductBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CoproductBillInfo getCoproductBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CoproductBillInfo getCoproductBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CoproductBillInfo model) throws BOSException;
    public void unAudit(CoproductBillInfo model) throws BOSException;
}