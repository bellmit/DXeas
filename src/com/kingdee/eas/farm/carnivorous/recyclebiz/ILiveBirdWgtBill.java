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

public interface ILiveBirdWgtBill extends ICoreBillBase
{
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection() throws BOSException;
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection(EntityViewInfo view) throws BOSException;
    public LiveBirdWgtBillCollection getLiveBirdWgtBillCollection(String oql) throws BOSException;
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LiveBirdWgtBillInfo getLiveBirdWgtBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(LiveBirdWgtBillInfo model) throws BOSException, EASBizException;
    public void unAudit(LiveBirdWgtBillInfo model) throws BOSException, EASBizException;
}