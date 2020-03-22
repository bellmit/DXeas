package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IHatchingBox extends IDataBase
{
    public HatchingBoxInfo getHatchingBoxInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchingBoxInfo getHatchingBoxInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchingBoxInfo getHatchingBoxInfo(String oql) throws BOSException, EASBizException;
    public HatchingBoxCollection getHatchingBoxCollection() throws BOSException;
    public HatchingBoxCollection getHatchingBoxCollection(EntityViewInfo view) throws BOSException;
    public HatchingBoxCollection getHatchingBoxCollection(String oql) throws BOSException;
}