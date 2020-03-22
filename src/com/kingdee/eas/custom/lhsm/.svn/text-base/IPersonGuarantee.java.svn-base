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

public interface IPersonGuarantee extends IDataBase
{
    public PersonGuaranteeInfo getPersonGuaranteeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonGuaranteeInfo getPersonGuaranteeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonGuaranteeInfo getPersonGuaranteeInfo(String oql) throws BOSException, EASBizException;
    public PersonGuaranteeCollection getPersonGuaranteeCollection() throws BOSException;
    public PersonGuaranteeCollection getPersonGuaranteeCollection(EntityViewInfo view) throws BOSException;
    public PersonGuaranteeCollection getPersonGuaranteeCollection(String oql) throws BOSException;
}