package com.kingdee.eas.bdm.bdapply;

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

public interface IMaterialInfoReq extends ICoreBillBase
{
    public MaterialInfoReqCollection getMaterialInfoReqCollection() throws BOSException;
    public MaterialInfoReqCollection getMaterialInfoReqCollection(EntityViewInfo view) throws BOSException;
    public MaterialInfoReqCollection getMaterialInfoReqCollection(String oql) throws BOSException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaterialInfoReqInfo getMaterialInfoReqInfo(String oql) throws BOSException, EASBizException;
    public void materialInfoAudit(MaterialInfoReqInfo model) throws BOSException;
    public void basenotby(MaterialInfoReqInfo model) throws BOSException;
    public void allAudit(MaterialInfoReqInfo model) throws BOSException;
}