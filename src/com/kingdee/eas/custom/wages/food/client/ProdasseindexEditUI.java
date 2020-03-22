/**
 * output package name
 */
package com.kingdee.eas.custom.wages.food.client;

import java.awt.event.*;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.custom.wages.BasicStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class ProdasseindexEditUI extends AbstractProdasseindexEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ProdasseindexEditUI.class);
    
    /**
     * output class constructor
     */
    public ProdasseindexEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.food.ProdasseindexFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.food.ProdasseindexInfo objectValue = new com.kingdee.eas.custom.wages.food.ProdasseindexInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.EditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		if(this.editData.getBaseStatus() == BasicStatus.open) {
			this.btnCancel.setEnabled(true);
			this.btnCancelCancel.setEnabled(false);
    	}else{
    		this.btnCancelCancel.setEnabled(true);
    		this.btnCancel.setEnabled(false);
    	}
//		prmtExaminPerson.addDataChangeListener(new DataChangeListener(){
//
//			
//			public void dataChanged(DataChangeEvent arg0) {
//				// TODO Auto-generated method stub
//				prmtExaminPerson_change();
//			}
//			
//		});
		
		
		
		
		 this.prmtExaminPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.F7PersonQuery");		
	        this.prmtExaminPerson.setVisible(true);		
	        this.prmtExaminPerson.setEditable(true);		
	        this.prmtExaminPerson.setDisplayFormat("$name$");		
	        this.prmtExaminPerson.setEditFormat("$number$");		
	        this.prmtExaminPerson.setCommitFormat("$number$");		
	        this.prmtExaminPerson.setRequired(false);
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.EditUI#actionCancel_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		this.editData.setBaseStatus(BasicStatus.open);
    	this.loadData();
        super.actionCancel_actionPerformed(e);
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.EditUI#actionCancelCancel_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		this.editData.setBaseStatus(BasicStatus.close);
    	this.loadData();
        super.actionCancelCancel_actionPerformed(e);
	}
	private void prmtExaminPerson_change() {
		// TODO Auto-generated method stub
		PersonInfo person  = (PersonInfo) prmtExaminPerson.getValue();
		String pseronid = person.getId().toString();
					
	}
	//用户名获取用户id
	private String getPersonNumber(String personid) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FNumber from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FID ='").append(personid).append("'").append(sp);
		//System.out.println("获取用户id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FNumber");
		}
		return personID;
	}

}