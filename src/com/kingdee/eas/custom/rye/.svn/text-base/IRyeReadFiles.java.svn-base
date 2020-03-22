package com.kingdee.eas.custom.rye;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IRyeReadFiles extends ICoreBillBase
{
    public RyeReadFilesCollection getRyeReadFilesCollection() throws BOSException;
    public RyeReadFilesCollection getRyeReadFilesCollection(EntityViewInfo view) throws BOSException;
    public RyeReadFilesCollection getRyeReadFilesCollection(String oql) throws BOSException;
    public RyeReadFilesInfo getRyeReadFilesInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RyeReadFilesInfo getRyeReadFilesInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RyeReadFilesInfo getRyeReadFilesInfo(String oql) throws BOSException, EASBizException;
}