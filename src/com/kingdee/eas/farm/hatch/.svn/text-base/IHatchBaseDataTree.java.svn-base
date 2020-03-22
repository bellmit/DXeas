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

public interface IHatchBaseDataTree extends ITreeBase
{
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(String oql) throws BOSException, EASBizException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection() throws BOSException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(EntityViewInfo view) throws BOSException;
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(String oql) throws BOSException;
}