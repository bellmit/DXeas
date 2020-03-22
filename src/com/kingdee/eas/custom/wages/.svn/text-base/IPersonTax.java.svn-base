package com.kingdee.eas.custom.wages;

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

public interface IPersonTax extends IDataBase
{
    public PersonTaxInfo getPersonTaxInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonTaxInfo getPersonTaxInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonTaxInfo getPersonTaxInfo(String oql) throws BOSException, EASBizException;
    public PersonTaxCollection getPersonTaxCollection() throws BOSException;
    public PersonTaxCollection getPersonTaxCollection(EntityViewInfo view) throws BOSException;
    public PersonTaxCollection getPersonTaxCollection(String oql) throws BOSException;
    public void approve(PersonTaxInfo model) throws BOSException;
    public void unApprove(PersonTaxInfo model) throws BOSException;
}