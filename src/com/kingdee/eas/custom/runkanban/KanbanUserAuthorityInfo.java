package com.kingdee.eas.custom.runkanban;

import java.io.Serializable;

public class KanbanUserAuthorityInfo extends AbstractKanbanUserAuthorityInfo implements Serializable 
{
    public KanbanUserAuthorityInfo()
    {
        super();
    }
    protected KanbanUserAuthorityInfo(String pkField)
    {
        super(pkField);
    }
}