package com.kingdee.eas.custom.lhsm;

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

public interface ICompanyInv extends IDataBase
{
    public CompanyInvInfo getCompanyInvInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyInvInfo getCompanyInvInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyInvInfo getCompanyInvInfo(String oql) throws BOSException, EASBizException;
    public CompanyInvCollection getCompanyInvCollection() throws BOSException;
    public CompanyInvCollection getCompanyInvCollection(EntityViewInfo view) throws BOSException;
    public CompanyInvCollection getCompanyInvCollection(String oql) throws BOSException;
}