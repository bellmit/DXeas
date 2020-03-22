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

public interface IMaiginBill extends ICoreBillBase
{
    public MaiginBillCollection getMaiginBillCollection() throws BOSException;
    public MaiginBillCollection getMaiginBillCollection(EntityViewInfo view) throws BOSException;
    public MaiginBillCollection getMaiginBillCollection(String oql) throws BOSException;
    public MaiginBillInfo getMaiginBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaiginBillInfo getMaiginBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaiginBillInfo getMaiginBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MaiginBillInfo model) throws BOSException, EASBizException;
    public void unAudit(MaiginBillInfo model) throws BOSException, EASBizException;
    public void viewGuaranteeBill(MaiginBillInfo model) throws BOSException;
}