/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetCollection;
import com.kingdee.eas.farm.food.stocount.CountPositionSetFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetInfo;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryCollection;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryInfo;
import com.kingdee.eas.farm.food.stocount.ISemiProductCount;
import com.kingdee.eas.farm.food.stocount.ProdCountInfo;
import com.kingdee.eas.farm.food.stocount.SemiProductCountCollection;
import com.kingdee.eas.farm.food.stocount.SemiProductCountFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SemiCountOperateWeightUI extends AbstractSemiCountOperateWeightUI
{
    private static final Logger logger = CoreUIObject.getLogger(SemiCountOperateWeightUI.class);
    ArrayList List;
    String countset = null;
    
    /**
     * output class constructor
     */
    public SemiCountOperateWeightUI() throws Exception
    {
        super();
    }
    
    
    
    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 作废功能
	 */
    @Override
	protected void cancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	super.cancel_actionPerformed(e);
    	int row = this.kDTable1.getSelectManager().getActiveRowIndex();
    	System.out.println(row);
    	String sfid = List.get(row).toString();	
		String sql  = "update CT_FM_SemiProductCount set CFStatus = 3 where fid = '"+sfid+"'";
		System.out.println(sql);
		try {
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
			this.onShow();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		
	}
    private void selectedRowChanged(int rowIndex) {
    	
    }
    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 清空按钮功能
	 */
	@Override
	protected void clear_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.clear_actionPerformed(e);
		this.material.setValue(null);
		this.materialunitf7.setValue(null);
		this.weight.setText(null);
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 打印+保存功能
	 */
	@Override
	protected void print_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		this.loadFields();
		BigDecimal w = new BigDecimal(this.weight.getText());
		//岗位判断
		if(countset.equals("0")){
//			//将UI中各值添加在新增的半成品计数上
//				SemiProductCountInfo spinfo = new SemiProductCountInfo();
//				spinfo.setNumber(createSeNumber());
//				spinfo.setBizDate(new Date());
//				spinfo.setPerson((PersonInfo)this.countpersonf7.getUserData());
//				spinfo.setMaterial((MaterialInfo)this.material.getData());
//				spinfo.setSemcount((CountPositionSetInfo)this.countpointf7.getData());
//				spinfo.setMnumber(w);
//				spinfo.setMbaseunit(this.materialunitf7.getText());
//				spinfo.setMaterialtype(this.materialunittypef7.getText());
//				ISemiProductCount isc = SemiProductCountFactory.getRemoteInstance();
//				IObjectPK pk = isc.addnew(spinfo);
//				MsgBox.showWarning("打印完成！");
//				this.onLoad();
				
			}else{
				//成品计数
				ProdCountInfo pinfo = new ProdCountInfo();
				pinfo.setNumber(createSeNumber());
				pinfo.setBizDate(new Date());
				pinfo.setPerson((PersonInfo)this.countpersonf7.getUserData());
//				pinfo.setMaterial((MaterialInfo)this.material.getData());
//				pinfo.setContset((CountPositionSetInfo)this.countpointf7.getData());
//				pinfo.setMnumber(w);
//				pinfo.setMbaseunit(this.materialunitf7.getText());
//				pinfo.setMaterialtype(this.materialunittypef7.getText());
				ISemiProductCount isc = SemiProductCountFactory.getRemoteInstance();
				IObjectPK pk = isc.addnew(pinfo);
				MsgBox.showWarning("打印完成！");
				this.onLoad();
				
				
			}
		
		
		
		
		
		super.print_actionPerformed(e);
	}

	/**
	 * 半成品编码
	 * 创建一个编码,格式为"yyyyMM"+"Seq"
	 * @return 单据编号
	 */
	private String createSeNumber() {
		// TODO Auto-generated method stub
		String str="";
		try {
			int num=1;
			SemiProductCountCollection coll;
			do{
				str=MathUtilsComm.getStringByNumber(3, num);
				str = (new SimpleDateFormat("yyyyMM")).format(new Date())+str;
				coll = SemiProductCountFactory.getRemoteInstance().getSemiProductCountCollection("where number='"+str+"'");
				if(coll.size()==0)
					return str;
				else
					++num;
			}while(1==1);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return str;
	}
	
	
	

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

   

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
    	initUI();
		initUIComp();
		super.onLoad();
	}
    
  @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		//调用出初始化分录
		initTable();
	}



	//初始化分录
	private void initTable() throws BOSException {
		// TODO Auto-generated method stub
		IRowSet rs=getExeQueryRowSet();
		this.kDTable1.removeRows();
		IRow row;
		try {
			while (rs.next()) {
				row = this.kDTable1.addRow();
				row.getCell("column1").setValue(rs.getString("mname"));
				row.getCell("column2").setValue(rs.getString("countname"));
				row.getCell("column3").setValue(rs.getString("person"));
				row.getCell("column4").setValue(rs.getString("mnumber"));
				row.getCell("column5").setValue(rs.getString("mtype"));
				row.getCell("column6").setValue(rs.getString("bizdaste"));	
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @return
	 * @throws BOSException
	 */
	private IRowSet getExeQueryRowSet() throws BOSException {
		StringBuffer sql = new StringBuffer();
		StringBuffer sql1 = new StringBuffer();
		String sp = "\n";
		//sql.append("/*dialect*/").append(sp);
		sql.append("select").append(sp);
		sql.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql.append("SEMCOUNT.fname_l2                   countname,").append(sp);
		sql.append("CREATOR.fnumber                     person,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.cfmnumber          mnumber,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.cfmaterialtype     mtype,").append(sp);
		sql.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql.append("FROM CT_FM_SemiProductCount AS SEMIPRODUCTCOUNT").append(sp);
		sql.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sql.append("LEFT OUTER JOIN CT_FM_SemiProductCountEntry AS ENTRYS").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sql.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sql.append("LEFT OUTER JOIN T_BD_Person AS PERSON").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFPersonID = PERSON.FID").append(sp);
		sql.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS SEMCOUNT").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFSemcountID = SEMCOUNT.FID").append(sp);
		sql.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sql.append("ON SEMIPRODUCTCOUNT.CFMaterialID = MATERIAL.FID").append(sp);
		
		
		//成品计数sql
		sql1.append("select").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fid                fid,").append(sp);
		sql1.append("MATERIAL.fname_l2                   mname,").append(sp);
		sql1.append("CONTSET.fname_l2                    countname,").append(sp);
		sql1.append("CREATOR.fnumber                     person,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.cfmnumber          mnumber,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.cfmaterialtype     mtype,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.CFStatus           status,").append(sp);
		sql1.append("SEMIPRODUCTCOUNT.fbizdate           bizdaste").append(sp);
		sql1.append("FROM CT_FM_ProductCount AS SEMIPRODUCTCOUNT").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS AUDITOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FAuditorID = AUDITOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS CREATOR").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FCreatorID = CREATOR.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS LASTUPDATEUSER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FLastUpdateUserID = LASTUPDATEUSER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_ProductCountEntry AS ENTRYS").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FID = ENTRYS.FParentID").append(sp);
		sql1.append("LEFT OUTER JOIN T_PM_User AS HANDLER").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.FHandlerID = HANDLER.FID").append(sp);
		sql1.append("LEFT OUTER JOIN CT_FM_CountPositionSet AS CONTSET").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFContsetID = CONTSET.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Person AS CONTPERSON").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFContpersonID = CONTPERSON.FID").append(sp);
		sql1.append("LEFT OUTER JOIN T_BD_Material AS MATERIAL").append(sp);
		sql1.append("ON SEMIPRODUCTCOUNT.CFMaterialID = MATERIAL.FID").append(sp);
		sql1.append("where SEMIPRODUCTCOUNT.CFStatus is null").append(sp);
		sql1.append("or SEMIPRODUCTCOUNT.CFStatus = 2").append(sp);
		sql1.append("order by bizdaste desc").append(sp);
		
		System.out.println(sql.toString());
		//IRowSet rs = DbUtil.executeQuery(arg0, arg1)
		if(countset.equals("0")){
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
		}else{
			IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql1.toString()).executeSQL();
			return rs;
		}
		
		
	}
	/**
	 * 得到SQL执行对象
	 * 
	 * @return
	 * @throws BOSException
	 */
	private ICommSqlFacade getSqlInstance() throws BOSException {
		return CommSqlFacadeFactory.getRemoteInstance();
	}
	
	
    
  //界面初始化
  //默认带出当前用户的信息和对应岗位信息
	private void initUI() {
		// TODO Auto-generated method stub
		//user和administrator没有员工内码所以不能进行岗位判断
		if(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("user")||com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getNumber().equals("administrator")){
			MsgBox.showWarning("非企业内用户禁止编辑！");
			SysUtil.abort();
		}
		String userid = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getPerson().getId().toString();
		//com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getId().toString()
		//System.out.println(com.kingdee.eas.common.client.SysContext.getSysContext().getUserName());
		//System.out.println(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getId().toString());
		//System.out.println(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getPerson().getId());
		this.countpersonf7.setValue(SysContext.getSysContext().getCurrentUserInfo() );
		//com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo().getId()
		CountPositionSetOperatorEntryCollection cpso;
		CountPositionSetCollection cp;
		CountPositionSetInfo cpinfo;
		CountPositionSetOperatorEntryInfo  cpsoeinfo;
		try {
			//判断当前用户是否在计数岗位中
			cpso = CountPositionSetOperatorEntryFactory.getRemoteInstance().getCountPositionSetOperatorEntryCollection("where Person = '"+userid+"'");
			
			if(cpso.size()==0){
				MsgBox.showWarning("当前用户没有计数岗位权限，无法进入计数界面！");
				SysUtil.abort();
			}
			//cpinfo = 
			cpsoeinfo = CountPositionSetOperatorEntryFactory.getRemoteInstance().getCountPositionSetOperatorEntryInfo("where Person = '"+userid+"'");
			cpinfo = CountPositionSetFactory.getRemoteInstance().getCountPositionSetInfo("where id = '"+cpsoeinfo.getParent().getId()+"'");
			countset = cpinfo.getCountset().getValue().toString();
			System.out.println(cpinfo.getName());
			this.countpointf7.setValue(cpinfo);
			this.material.setValue(null);
			this.materialunitf7.setValue(null);
			this.weight.setText(null);
			this.materialunittypef7.setValue(null);
			
			
		
		
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void material_Changed() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("prmtmaterial_Changed() Function is executed!");
        //materialtype.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"model")));
		materialunitf7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"baseUnit.name")));
		materialunittypef7.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)material.getData(),"model")));
	}

	/**
	 * F7初始化
	 */
	private void initUIComp() {
		// TODO Auto-generated method stub
		

		this.countpersonf7.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
		this.countpersonf7.setVisible(true);		
		this.countpersonf7.setEditable(true);		
		this.countpersonf7.setDisplayFormat("$name$");		
		this.countpersonf7.setEditFormat("$number$");		
		this.countpersonf7.setCommitFormat("$number$");		
		this.countpersonf7.setRequired(false);
		
		
		
        // prmtsemcount		
        this.countpointf7.setQueryInfo("com.kingdee.eas.farm.food.stocount.app.CountPositionSetQuery");		
        this.countpointf7.setVisible(true);		
        this.countpointf7.setEditable(true);		
        this.countpointf7.setDisplayFormat("$name$");		
        this.countpointf7.setEditFormat("$number$");		
        this.countpointf7.setCommitFormat("$number$");		
        this.countpointf7.setRequired(false);
        
        	countpointf7.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.food.stocount.client.CountPositionSetListUI prmtsemcount_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsemcount_F7ListUI == null) {
					try {
						prmtsemcount_F7ListUI = new com.kingdee.eas.farm.food.stocount.client.CountPositionSetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsemcount_F7ListUI));
					prmtsemcount_F7ListUI.setF7Use(true,ctx);
					countpointf7.setSelector(prmtsemcount_F7ListUI);
				}
			}
		});
					
        // prmtmaterial		
        this.material.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.material.setVisible(true);		
        this.material.setEditable(true);		
        this.material.setDisplayFormat("$name$");		
        this.material.setEditFormat("$number$");		
        this.material.setCommitFormat("$number$");		
        this.material.setRequired(false);
        material.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				material_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});		
		
	}




	/**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

}