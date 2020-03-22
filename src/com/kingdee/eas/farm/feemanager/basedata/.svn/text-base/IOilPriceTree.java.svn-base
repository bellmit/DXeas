package com.kingdee.eas.farm.feemanager.basedata;

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

public interface IOilPriceTree extends ITreeBase
{
    public OilPriceTreeInfo getOilPriceTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OilPriceTreeInfo getOilPriceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OilPriceTreeInfo getOilPriceTreeInfo(String oql) throws BOSException, EASBizException;
    public OilPriceTreeCollection getOilPriceTreeCollection() throws BOSException;
    public OilPriceTreeCollection getOilPriceTreeCollection(EntityViewInfo view) throws BOSException;
    public OilPriceTreeCollection getOilPriceTreeCollection(String oql) throws BOSException;
}