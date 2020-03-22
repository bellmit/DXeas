package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface IPreHouseWgtBill extends ICoreBillBase
{
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection() throws BOSException;
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection(EntityViewInfo view) throws BOSException;
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection(String oql) throws BOSException;
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(PreHouseWgtBillInfo model) throws BOSException, EASBizException;
    public void unAudit(PreHouseWgtBillInfo model) throws BOSException, EASBizException;
}