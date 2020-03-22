package com.kingdee.eas.farm.stocking.basedata;

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

public interface ICheckItem extends IDataBase
{
    public CheckItemInfo getCheckItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckItemInfo getCheckItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckItemInfo getCheckItemInfo(String oql) throws BOSException, EASBizException;
    public CheckItemCollection getCheckItemCollection() throws BOSException;
    public CheckItemCollection getCheckItemCollection(EntityViewInfo view) throws BOSException;
    public CheckItemCollection getCheckItemCollection(String oql) throws BOSException;
    public void audit(CheckItemInfo model) throws BOSException, EASBizException;
    public void unAudit(CheckItemInfo model) throws BOSException, EASBizException;
}