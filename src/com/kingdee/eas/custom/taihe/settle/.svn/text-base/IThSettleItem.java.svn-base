package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IThSettleItem extends IWlhlDataBase
{
    public ThSettleItemInfo getThSettleItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ThSettleItemInfo getThSettleItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ThSettleItemInfo getThSettleItemInfo(String oql) throws BOSException, EASBizException;
    public ThSettleItemCollection getThSettleItemCollection() throws BOSException;
    public ThSettleItemCollection getThSettleItemCollection(EntityViewInfo view) throws BOSException;
    public ThSettleItemCollection getThSettleItemCollection(String oql) throws BOSException;
}