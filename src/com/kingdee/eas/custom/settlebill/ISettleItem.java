package com.kingdee.eas.custom.settlebill;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISettleItem extends IDataBase
{
    public SettleItemInfo getSettleItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleItemInfo getSettleItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleItemInfo getSettleItemInfo(String oql) throws BOSException, EASBizException;
    public SettleItemCollection getSettleItemCollection() throws BOSException;
    public SettleItemCollection getSettleItemCollection(EntityViewInfo view) throws BOSException;
    public SettleItemCollection getSettleItemCollection(String oql) throws BOSException;
}