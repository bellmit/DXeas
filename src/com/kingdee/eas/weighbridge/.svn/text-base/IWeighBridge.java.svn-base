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

public interface IWeighBridge extends IDataBase
{
    public WeighBridgeInfo getWeighBridgeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WeighBridgeInfo getWeighBridgeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WeighBridgeInfo getWeighBridgeInfo(String oql) throws BOSException, EASBizException;
    public WeighBridgeCollection getWeighBridgeCollection() throws BOSException;
    public WeighBridgeCollection getWeighBridgeCollection(EntityViewInfo view) throws BOSException;
    public WeighBridgeCollection getWeighBridgeCollection(String oql) throws BOSException;
}