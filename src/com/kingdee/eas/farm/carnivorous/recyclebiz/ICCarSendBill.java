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

public interface ICCarSendBill extends ICoreBillBase
{
    public CCarSendBillCollection getCCarSendBillCollection() throws BOSException;
    public CCarSendBillCollection getCCarSendBillCollection(EntityViewInfo view) throws BOSException;
    public CCarSendBillCollection getCCarSendBillCollection(String oql) throws BOSException;
    public CCarSendBillInfo getCCarSendBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCarSendBillInfo getCCarSendBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCarSendBillInfo getCCarSendBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CCarSendBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CCarSendBillInfo model) throws BOSException, EASBizException;
    public void manageSendCar(CCarSendBillInfo model, Map map) throws BOSException, EASBizException;
}