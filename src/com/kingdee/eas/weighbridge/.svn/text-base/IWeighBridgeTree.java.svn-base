package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IWeighBridgeTree extends ITreeBase
{
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(String oql) throws BOSException, EASBizException;
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection() throws BOSException;
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection(EntityViewInfo view) throws BOSException;
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection(String oql) throws BOSException;
}