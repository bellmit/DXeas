package com.kingdee.eas.custom.salepayment;

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

public interface IAreaTargetTree extends ITreeBase
{
    public AreaTargetTreeInfo getAreaTargetTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AreaTargetTreeInfo getAreaTargetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AreaTargetTreeInfo getAreaTargetTreeInfo(String oql) throws BOSException, EASBizException;
    public AreaTargetTreeCollection getAreaTargetTreeCollection() throws BOSException;
    public AreaTargetTreeCollection getAreaTargetTreeCollection(EntityViewInfo view) throws BOSException;
    public AreaTargetTreeCollection getAreaTargetTreeCollection(String oql) throws BOSException;
}