package com.kingdee.eas.WSInterface.basedataFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseResultInfo
    implements Serializable
{

    public BaseResultInfo()
    {
        status = 0;
        errorMsgs = new ArrayList();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public List getErrorMsgs()
    {
        return errorMsgs;
    }

    public void setErrorMsgs(List errorMsgs)
    {
        this.errorMsgs = errorMsgs;
    }

    private static final long serialVersionUID = 5294630789487058618L;
    private String id;
    private String number;
    private int status;
    private List errorMsgs;
}
