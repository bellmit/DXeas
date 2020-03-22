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

public interface IBatch extends IDataBase
{
    public BatchInfo getBatchInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchInfo getBatchInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchInfo getBatchInfo(String oql) throws BOSException, EASBizException;
    public BatchCollection getBatchCollection() throws BOSException;
    public BatchCollection getBatchCollection(EntityViewInfo view) throws BOSException;
    public BatchCollection getBatchCollection(String oql) throws BOSException;
    public void audit(BatchInfo model) throws BOSException, EASBizException;
    public void unAudit(BatchInfo model) throws BOSException, EASBizException;
}