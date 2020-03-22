package com.kingdee.eas.farm.stocking.basedata;

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

public interface ICoProductPriceTree extends ITreeBase
{
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(String oql) throws BOSException, EASBizException;
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection() throws BOSException;
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection(EntityViewInfo view) throws BOSException;
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection(String oql) throws BOSException;
}