package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface ICKCloseAccountFacade extends IBizCtrl
{
    public boolean checkIsClosed(String companyID, String periodID) throws BOSException, EASBizException;
    public void closeAccount(String companyID, String periodID) throws BOSException, EASBizException;
    public void unCloseAccount(String companyID, String periodID) throws BOSException, EASBizException;
}