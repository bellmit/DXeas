package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFarmerTree extends ITreeBase
{
    public FarmerTreeInfo getFarmerTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerTreeInfo getFarmerTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerTreeInfo getFarmerTreeInfo(String oql) throws BOSException, EASBizException;
    public FarmerTreeCollection getFarmerTreeCollection() throws BOSException;
    public FarmerTreeCollection getFarmerTreeCollection(EntityViewInfo view) throws BOSException;
    public FarmerTreeCollection getFarmerTreeCollection(String oql) throws BOSException;
}