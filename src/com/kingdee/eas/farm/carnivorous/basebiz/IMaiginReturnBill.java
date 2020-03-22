package com.kingdee.eas.farm.carnivorous.basebiz;

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

public interface IMaiginReturnBill extends ICoreBillBase
{
    public MaiginReturnBillCollection getMaiginReturnBillCollection() throws BOSException;
    public MaiginReturnBillCollection getMaiginReturnBillCollection(EntityViewInfo view) throws BOSException;
    public MaiginReturnBillCollection getMaiginReturnBillCollection(String oql) throws BOSException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaiginReturnBillInfo getMaiginReturnBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MaiginReturnBillInfo model) throws BOSException, EASBizException;
    public void unAudit(MaiginReturnBillInfo model) throws BOSException, EASBizException;
}