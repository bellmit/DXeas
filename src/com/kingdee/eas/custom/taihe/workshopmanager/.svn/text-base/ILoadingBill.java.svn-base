package com.kingdee.eas.custom.taihe.workshopmanager;

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

public interface ILoadingBill extends IWlhlBillBase
{
    public LoadingBillCollection getLoadingBillCollection() throws BOSException;
    public LoadingBillCollection getLoadingBillCollection(EntityViewInfo view) throws BOSException;
    public LoadingBillCollection getLoadingBillCollection(String oql) throws BOSException;
    public LoadingBillInfo getLoadingBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LoadingBillInfo getLoadingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LoadingBillInfo getLoadingBillInfo(String oql) throws BOSException, EASBizException;
    public void mobileQuery(LoadingBillInfo model) throws BOSException;
    public void mobifyAddNew(LoadingBillInfo model) throws BOSException;
}