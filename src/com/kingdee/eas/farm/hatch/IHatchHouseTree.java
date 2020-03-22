package com.kingdee.eas.farm.hatch;

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

public interface IHatchHouseTree extends ITreeBase
{
    public HatchHouseTreeInfo getHatchHouseTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchHouseTreeInfo getHatchHouseTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchHouseTreeInfo getHatchHouseTreeInfo(String oql) throws BOSException, EASBizException;
    public HatchHouseTreeCollection getHatchHouseTreeCollection() throws BOSException;
    public HatchHouseTreeCollection getHatchHouseTreeCollection(EntityViewInfo view) throws BOSException;
    public HatchHouseTreeCollection getHatchHouseTreeCollection(String oql) throws BOSException;
}