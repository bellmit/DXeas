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

public interface IFarmersTree extends ITreeBase
{
    public FarmersTreeInfo getFarmersTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmersTreeInfo getFarmersTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmersTreeInfo getFarmersTreeInfo(String oql) throws BOSException, EASBizException;
    public FarmersTreeCollection getFarmersTreeCollection() throws BOSException;
    public FarmersTreeCollection getFarmersTreeCollection(EntityViewInfo view) throws BOSException;
    public FarmersTreeCollection getFarmersTreeCollection(String oql) throws BOSException;
}