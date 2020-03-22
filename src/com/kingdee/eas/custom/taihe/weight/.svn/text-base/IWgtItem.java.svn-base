package com.kingdee.eas.custom.taihe.weight;

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

public interface IWgtItem extends IDataBase
{
    public WgtItemInfo getWgtItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WgtItemInfo getWgtItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WgtItemInfo getWgtItemInfo(String oql) throws BOSException, EASBizException;
    public WgtItemCollection getWgtItemCollection() throws BOSException;
    public WgtItemCollection getWgtItemCollection(EntityViewInfo view) throws BOSException;
    public WgtItemCollection getWgtItemCollection(String oql) throws BOSException;
}