package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFodderStd extends IDataBase
{
    public FodderStdInfo getFodderStdInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FodderStdInfo getFodderStdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FodderStdInfo getFodderStdInfo(String oql) throws BOSException, EASBizException;
    public FodderStdCollection getFodderStdCollection() throws BOSException;
    public FodderStdCollection getFodderStdCollection(EntityViewInfo view) throws BOSException;
    public FodderStdCollection getFodderStdCollection(String oql) throws BOSException;
    public void audit(FodderStdInfo model) throws BOSException, EASBizException;
    public void unAudit(FodderStdInfo model) throws BOSException, EASBizException;
}