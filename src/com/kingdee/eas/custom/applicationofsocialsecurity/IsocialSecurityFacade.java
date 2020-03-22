package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IsocialSecurityFacade extends IBizCtrl
{
    public HashMap getInfoOfPersonBaseOnNumberOrName(String personNum, String personName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException;
    public ArrayList getSHRSIStatus(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException;
    public String getSIStatusIDBaseOnHisName(String SIStatusName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException;
    public String updateSIStatusBaseOnPersonNumAndSIStatusID(String SIStatusID, String personNum, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException;
    public ArrayList getCompanyNameFromSHR(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException;
    public ArrayList getPersonInfoByFilterItem(Date dateBegin, Date dateEnd, DataBaseConnectionInfo dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException;
}