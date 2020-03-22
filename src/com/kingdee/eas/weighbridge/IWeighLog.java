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

public interface IWeighLog extends IDataBase
{
    public WeighLogInfo getWeighLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WeighLogInfo getWeighLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WeighLogInfo getWeighLogInfo(String oql) throws BOSException, EASBizException;
    public WeighLogCollection getWeighLogCollection() throws BOSException;
    public WeighLogCollection getWeighLogCollection(EntityViewInfo view) throws BOSException;
    public WeighLogCollection getWeighLogCollection(String oql) throws BOSException;
}