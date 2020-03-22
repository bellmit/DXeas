package com.kingdee.eas.custom.foodtrac;

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

public interface ICompanyinfo extends ICoreBillBase
{
    public CompanyinfoCollection getCompanyinfoCollection() throws BOSException;
    public CompanyinfoCollection getCompanyinfoCollection(EntityViewInfo view) throws BOSException;
    public CompanyinfoCollection getCompanyinfoCollection(String oql) throws BOSException;
    public CompanyinfoInfo getCompanyinfoInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyinfoInfo getCompanyinfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyinfoInfo getCompanyinfoInfo(String oql) throws BOSException, EASBizException;
}