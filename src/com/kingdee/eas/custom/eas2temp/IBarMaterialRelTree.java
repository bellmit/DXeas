package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IBarMaterialRelTree extends ITreeBase
{
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(String oql) throws BOSException, EASBizException;
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection() throws BOSException;
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection(EntityViewInfo view) throws BOSException;
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection(String oql) throws BOSException;
}