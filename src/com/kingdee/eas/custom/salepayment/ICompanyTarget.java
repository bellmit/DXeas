package com.kingdee.eas.custom.salepayment;

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

public interface ICompanyTarget extends IDataBase
{
    public CompanyTargetInfo getCompanyTargetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyTargetInfo getCompanyTargetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyTargetInfo getCompanyTargetInfo(String oql) throws BOSException, EASBizException;
    public CompanyTargetCollection getCompanyTargetCollection() throws BOSException;
    public CompanyTargetCollection getCompanyTargetCollection(EntityViewInfo view) throws BOSException;
    public CompanyTargetCollection getCompanyTargetCollection(String oql) throws BOSException;
    public void audit(CompanyTargetInfo model) throws BOSException;
    public void unAudit(CompanyTargetInfo model) throws BOSException;
}