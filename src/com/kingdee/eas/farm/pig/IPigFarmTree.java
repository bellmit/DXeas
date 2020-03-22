package com.kingdee.eas.farm.pig;

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

public interface IPigFarmTree extends ITreeBase
{
    public PigFarmTreeInfo getPigFarmTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigFarmTreeInfo getPigFarmTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigFarmTreeInfo getPigFarmTreeInfo(String oql) throws BOSException, EASBizException;
    public PigFarmTreeCollection getPigFarmTreeCollection() throws BOSException;
    public PigFarmTreeCollection getPigFarmTreeCollection(EntityViewInfo view) throws BOSException;
    public PigFarmTreeCollection getPigFarmTreeCollection(String oql) throws BOSException;
}