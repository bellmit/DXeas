package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IPersonFarmerRange extends IDataBase
{
    public PersonFarmerRangeInfo getPersonFarmerRangeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonFarmerRangeInfo getPersonFarmerRangeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonFarmerRangeInfo getPersonFarmerRangeInfo(String oql) throws BOSException, EASBizException;
    public PersonFarmerRangeCollection getPersonFarmerRangeCollection() throws BOSException;
    public PersonFarmerRangeCollection getPersonFarmerRangeCollection(EntityViewInfo view) throws BOSException;
    public PersonFarmerRangeCollection getPersonFarmerRangeCollection(String oql) throws BOSException;
    public void audit(PersonFarmerRangeInfo model) throws BOSException, EASBizException;
    public void unAudit(PersonFarmerRangeInfo model) throws BOSException, EASBizException;
}