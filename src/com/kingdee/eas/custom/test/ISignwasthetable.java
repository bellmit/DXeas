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

public interface ISignwasthetable extends ICoreBillBase
{
    public SignwasthetableCollection getSignwasthetableCollection() throws BOSException;
    public SignwasthetableCollection getSignwasthetableCollection(EntityViewInfo view) throws BOSException;
    public SignwasthetableCollection getSignwasthetableCollection(String oql) throws BOSException;
    public SignwasthetableInfo getSignwasthetableInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignwasthetableInfo getSignwasthetableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignwasthetableInfo getSignwasthetableInfo(String oql) throws BOSException, EASBizException;
    public void check(SignwasthetableInfo model) throws BOSException;
    public void deleteLine(SignwasthetableInfo model) throws BOSException;
    public void listener(SignwasthetableInfo model) throws BOSException;
    public void unAudit(SignwasthetableInfo model) throws BOSException;
    public void btnRefresh(SignwasthetableInfo model) throws BOSException;
}