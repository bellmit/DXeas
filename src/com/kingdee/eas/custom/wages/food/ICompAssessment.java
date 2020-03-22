package com.kingdee.eas.custom.wages.food;

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

public interface ICompAssessment extends IDataBase
{
    public CompAssessmentInfo getCompAssessmentInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompAssessmentInfo getCompAssessmentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompAssessmentInfo getCompAssessmentInfo(String oql) throws BOSException, EASBizException;
    public CompAssessmentCollection getCompAssessmentCollection() throws BOSException;
    public CompAssessmentCollection getCompAssessmentCollection(EntityViewInfo view) throws BOSException;
    public CompAssessmentCollection getCompAssessmentCollection(String oql) throws BOSException;
}