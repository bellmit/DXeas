package com.kingdee.eas.farm.pig.breedingsow;

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

public interface ISowAbortion extends ICoreBillBase
{
    public SowAbortionCollection getSowAbortionCollection() throws BOSException;
    public SowAbortionCollection getSowAbortionCollection(EntityViewInfo view) throws BOSException;
    public SowAbortionCollection getSowAbortionCollection(String oql) throws BOSException;
    public SowAbortionInfo getSowAbortionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SowAbortionInfo getSowAbortionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SowAbortionInfo getSowAbortionInfo(String oql) throws BOSException, EASBizException;
}