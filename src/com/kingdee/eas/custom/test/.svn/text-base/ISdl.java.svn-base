package com.kingdee.eas.custom.test;

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

public interface ISdl extends ICoreBillBase
{
    public SdlCollection getSdlCollection() throws BOSException;
    public SdlCollection getSdlCollection(EntityViewInfo view) throws BOSException;
    public SdlCollection getSdlCollection(String oql) throws BOSException;
    public SdlInfo getSdlInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SdlInfo getSdlInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SdlInfo getSdlInfo(String oql) throws BOSException, EASBizException;
}