package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IChickenRecBill extends ICoreBillBase
{
    public ChickenRecBillCollection getChickenRecBillCollection() throws BOSException;
    public ChickenRecBillCollection getChickenRecBillCollection(EntityViewInfo view) throws BOSException;
    public ChickenRecBillCollection getChickenRecBillCollection(String oql) throws BOSException;
    public ChickenRecBillInfo getChickenRecBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ChickenRecBillInfo getChickenRecBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ChickenRecBillInfo getChickenRecBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(ChickenRecBillInfo model) throws BOSException, EASBizException;
    public void unAudit(ChickenRecBillInfo model) throws BOSException, EASBizException;
    public void manageCarSeq(ChickenRecBillInfo model, Map map) throws BOSException, EASBizException;
}