package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IByThePieceBill extends IWlhlBillBase
{
    public ByThePieceBillCollection getByThePieceBillCollection() throws BOSException;
    public ByThePieceBillCollection getByThePieceBillCollection(EntityViewInfo view) throws BOSException;
    public ByThePieceBillCollection getByThePieceBillCollection(String oql) throws BOSException;
    public ByThePieceBillInfo getByThePieceBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ByThePieceBillInfo getByThePieceBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ByThePieceBillInfo getByThePieceBillInfo(String oql) throws BOSException, EASBizException;
}