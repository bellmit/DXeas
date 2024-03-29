package com.kingdee.eas.custom.tocloud;

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

public interface ISynDateLog extends ICoreBillBase
{
    public SynDateLogCollection getSynDateLogCollection() throws BOSException;
    public SynDateLogCollection getSynDateLogCollection(EntityViewInfo view) throws BOSException;
    public SynDateLogCollection getSynDateLogCollection(String oql) throws BOSException;
    public SynDateLogInfo getSynDateLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SynDateLogInfo getSynDateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SynDateLogInfo getSynDateLogInfo(String oql) throws BOSException, EASBizException;
    public void deleteEntry(SynDateLogInfo model) throws BOSException;
}