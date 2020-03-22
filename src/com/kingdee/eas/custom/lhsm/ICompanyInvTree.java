package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICompanyInvTree extends ITreeBase
{
    public CompanyInvTreeInfo getCompanyInvTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyInvTreeInfo getCompanyInvTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyInvTreeInfo getCompanyInvTreeInfo(String oql) throws BOSException, EASBizException;
    public CompanyInvTreeCollection getCompanyInvTreeCollection() throws BOSException;
    public CompanyInvTreeCollection getCompanyInvTreeCollection(EntityViewInfo view) throws BOSException;
    public CompanyInvTreeCollection getCompanyInvTreeCollection(String oql) throws BOSException;
}