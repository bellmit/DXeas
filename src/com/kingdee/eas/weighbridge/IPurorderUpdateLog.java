package com.kingdee.eas.weighbridge;

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

public interface IPurorderUpdateLog extends IDataBase
{
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(String oql) throws BOSException, EASBizException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection() throws BOSException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(EntityViewInfo view) throws BOSException;
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(String oql) throws BOSException;
}