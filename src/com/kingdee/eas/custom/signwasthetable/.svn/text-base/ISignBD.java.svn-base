package com.kingdee.eas.custom.signwasthetable;

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

public interface ISignBD extends IDataBase
{
    public SignBDInfo getSignBDInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignBDInfo getSignBDInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignBDInfo getSignBDInfo(String oql) throws BOSException, EASBizException;
    public SignBDCollection getSignBDCollection() throws BOSException;
    public SignBDCollection getSignBDCollection(EntityViewInfo view) throws BOSException;
    public SignBDCollection getSignBDCollection(String oql) throws BOSException;
    public void audit(SignBDInfo model) throws BOSException;
    public void unAudit(SignBDInfo model) throws BOSException;
}