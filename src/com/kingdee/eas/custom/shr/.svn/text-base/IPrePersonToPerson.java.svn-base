package com.kingdee.eas.custom.shr;

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

public interface IPrePersonToPerson extends ICoreBillBase
{
    public PrePersonToPersonCollection getPrePersonToPersonCollection() throws BOSException;
    public PrePersonToPersonCollection getPrePersonToPersonCollection(EntityViewInfo view) throws BOSException;
    public PrePersonToPersonCollection getPrePersonToPersonCollection(String oql) throws BOSException;
    public PrePersonToPersonInfo getPrePersonToPersonInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PrePersonToPersonInfo getPrePersonToPersonInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PrePersonToPersonInfo getPrePersonToPersonInfo(String oql) throws BOSException, EASBizException;
}