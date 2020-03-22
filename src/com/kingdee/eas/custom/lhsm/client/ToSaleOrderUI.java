/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTMergeManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.CellCheckBoxRenderer;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.ctrl.swing.KDTextArea;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.lhsm.CompanyInvInfo;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo;
import com.kingdee.eas.custom.lhsm.SaleForecastFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastInfo;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderEditUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.IToolFacade;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.UuidException;

/**
 * 执行销售预报单转订单
 * 不需要显示
 */
public class ToSaleOrderUI extends AbstractToSaleOrderUI{
	private static final Logger logger = CoreUIObject.getLogger(ToSaleOrderUI.class);
	public String cuid;
	public String id;
	public String entryid;
	public String customerid;
	public String materialid;
	public String unitid;
	public String fseq;
	public BigDecimal qtybc=BigDecimal.ZERO;
	public BigDecimal qty=BigDecimal.ZERO;
	public BigDecimal price=BigDecimal.ZERO;
	public BigDecimal fqtytotal=BigDecimal.ZERO;
	// 当前的财务组织
	protected CompanyOrgUnitInfo currOrgUnitInfo;
	public String materialids;
	public Set materialsID;

	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	/**
	 * output class constructor
	 */
	public ToSaleOrderUI() throws Exception
	{
		super();
		Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension((int)(dd.getWidth()*0.8),(int)(dd.getHeight()*0.8)));
		id="";
	}

	public void onLoad() throws Exception {
		super.onLoad();
		this.btAddOrder.setText("生成订单");
		// 当前组织
		currOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
		cuid = currOrgUnitInfo.getId().toString().trim();
		if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
			SysUtil.abort();
		}
		if(!currOrgUnitInfo.getNumber().equals("10100")){
			//MsgBox.showInfo("不能登录！");
			//SysUtil.abort();
		}

		this.btSaveOrders.setVisible(false);  
		//三个方法
		inittblOrders(this.kdtOrdersTable);
		inittblForecast(this.kdtForecastTable);
		initAction();
		//得到表单的id
		if(getUIContext().get("FID")!=null){
			id = (String)getUIContext().get("FID");
			ObjectUuidPK pk = new ObjectUuidPK(id);
			SaleForecastInfo salefinfo = SaleForecastFactory.getRemoteInstance().getSaleForecastInfo(pk);
			String baseStatus = salefinfo.getState().getValue().toString();
			//如果是审核状态 不做处理， 否则  插入,删除分录按钮不能用，只有全选可以用
			if(baseStatus.equals("3")){

			}else{
				this.btnRemove.setEnabled(false);
				this.btnInsert.setEnabled(false);
				this.btnAllInsert.setEnabled(true);
			}
			customerid = salefinfo.getCustomer().getId().toString();

			pk = new ObjectUuidPK(customerid);
			CustomerInfo customerinfo=CustomerFactory.getRemoteInstance().getCustomerInfo(pk);
			this.prmtCustomer.setValue(customerinfo);

			if(salefinfo.getSalePerson()!=null){
				String personid=salefinfo.getSalePerson().getId().toString();
				pk=new ObjectUuidPK(personid);
				PersonInfo persinfo=PersonFactory.getRemoteInstance().getPersonInfo(pk);
				this.prmtSalePerson.setValue(persinfo);
			}
			this.inittblForecastData(this.kdtForecastTable);
			initTableDataOrders(this.kdtOrdersTable);
			materialsID = new LinkedHashSet(salefinfo.getEntrys().size());
			for (int m= 0; m < salefinfo.getEntrys().size(); m++) {
				materialsID.add(salefinfo.getEntrys().get(m).getMaterialNumber().getId().toString());
			}
			setorgF7();
		}
		//重新解析预报表分录，填充数据
		kdtForecastTable.checkParsed();
		kdtForecastTable.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);

		String companyID=null;
		if(prmtCompany.getValue()!=null) {
			companyID=((IObjectValue) prmtCompany.getValue()).getString("id");
		}else {
			prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
			companyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		}

		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(companyID));
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizCustomerF7((KDBizPromptBox) kdtOrdersTable.getColumn("customer").getEditor().getComponent(),
				kdtOrdersTable.getColumn("customer"), "com.kingdee.eas.scm.sd.sale.app.SaleOrderQuery", orgInfo, OrgType.Company, true);


		if(SysContext.getSysContext().getCurrentFIUnit().getName().indexOf("食品有限公司") >= 0){
			prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
			companyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		}else
			prmtCompany.setValue(null);


		btnViewPrice.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				detailMouseClickGetQtyAndNewPrice();
			}});
		btnOpenOrderBill.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				int[] selectedRows = KDTableUtil.getSelectedRows(kdtOrdersTable);
				if(selectedRows.length > 0){
					int seq = selectedRows[0];
					String orderNum = UIRuleUtil.getString(kdtOrdersTable.getCell(seq, "saleOrder").getValue());
					if(StringUtils.isNotEmpty(orderNum)){
						try {
							IRowSet rs = SQLExecutorFactory.getRemoteInstance("select FID from T_SD_SaleOrder where Fnumber='"+orderNum+"'").executeSQL();
							if(rs.next()){
								String orderID = rs.getString("fid");
								HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
								hashMap.put("ID",orderID);
								ClientUtils.openChildUIFromParentUI(UIFactoryName.NEWWIN, SaleOrderEditUI.class.getName(), hashMap, null, OprtState.VIEW);
							}else{
								commUtils.giveUserTipsAndRetire("当前订单已被手工删除，请重新计算预报单后重试");
							}
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						commUtils.giveUserTipsAndRetire("当前行并没有生成订单");
					}
				}else{
					commUtils.giveUserTipsAndRetire("请选择一行已生成分录的行");
				}
			}});


		kDTable1.addColumns(9);

		kDTable1.addHeadRow();

		kDTable1.getColumn(0).setKey("materialNum");
		kDTable1.getHeadRow(0).getCell("materialNum").setValue("物料编码");

		kDTable1.getColumn(1).setKey("materialName");
		kDTable1.getHeadRow(0).getCell("materialName").setValue("物料名称");

		kDTable1.getColumn(2).setKey("company");
		kDTable1.getHeadRow(0).getCell("company").setValue("公司");

		kDTable1.getColumn(3).setKey("warehouse");
		kDTable1.getHeadRow(0).getCell("warehouse").setValue("仓库");

		kDTable1.getColumn(4).setKey("curQty");
		kDTable1.getHeadRow(0).getCell("curQty").setValue("当前库存");

		kDTable1.getColumn(5).setKey("yubaoQty");
		kDTable1.getHeadRow(0).getCell("yubaoQty").setValue("库存预报");

		kDTable1.getColumn(6).setKey("totalQty");
		kDTable1.getHeadRow(0).getCell("totalQty").setValue("库存合计");

		kDTable1.getColumn(7).setKey("dingdanQty");
		kDTable1.getHeadRow(0).getCell("dingdanQty").setValue("未出库");

		kDTable1.getColumn(8).setKey("canUseQty");
		kDTable1.getHeadRow(0).getCell("canUseQty").setValue("可用库存");


	}
	public void setorgF7()throws Exception{
		Set materialsID = new LinkedHashSet();
		id=(String)getUIContext().get("FID");
		StringBuffer sql=new StringBuffer();
		String materialid="";
		sql=new StringBuffer();
		sql.append("select distinct t1.cfmaterialnumberid fid  ");
		sql.append(" from ct_lhs_saleForecastentry t1 ");
		sql.append(" where t1.fparentid='"+id+"' ");
		IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		while(rs.next()){
			String  materialid1 =rs.getString("fid");
			materialsID.add(materialid1);
		}
		FilterInfo filterInfo=new FilterInfo();
		//filterInfo.getFilterItems().add(new FilterItemInfo("parent.id",cuid,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);

		prmtMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		prmtMaterial.setVisible(true);
		prmtMaterial.setEditable(true);
		prmtMaterial.setDisplayFormat("$name$");
		prmtMaterial.setEditFormat("$number$");
		prmtMaterial.setCommitFormat("$name$");
		if(!this.materialids.equals("")){
			filterInfo=new FilterInfo();
			filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
			evi=new EntityViewInfo();
			evi.setFilter(filterInfo);
			prmtMaterial.setEntityViewInfo(evi);
		}
		prmtMaterial.setEnabledMultiSelection(true);

		//LinkedHashSet也是一个 有序  集合
		materialsID = new LinkedHashSet();
		sql=new StringBuffer();
		sql=new StringBuffer();
		sql.append(" select fnumber,cforgidid fid from T_LHS_SSorgList ");
		rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
		}
		filterInfo=new FilterInfo();
		//filterInfo.getFilterItems().add(new FilterItemInfo("parent.id",cuid,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		evi=new EntityViewInfo();
		evi.setFilter(filterInfo);	
		//公司 F7
		prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
		prmtCompany.setVisible(true);		
		prmtCompany.setEditable(true);		
		prmtCompany.setDisplayFormat("$name$");		
		prmtCompany.setEditFormat("$number$");		
		prmtCompany.setCommitFormat("$number$");		
		prmtCompany.setRequired(false);
		prmtCompany.setEntityViewInfo(evi);
		prmtCompany.setSelector(new CompanyF7());

		// 购货客户	F7
		this.prmtCustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
		this.prmtCustomer.setVisible(true);		
		this.prmtCustomer.setEditable(true);		
		this.prmtCustomer.setDisplayFormat("$name$");		
		this.prmtCustomer.setEditFormat("$number$");		
		this.prmtCustomer.setCommitFormat("$number$");		
		this.prmtCustomer.setRequired(false);	

		// 销售员  F7
		this.prmtSalePerson.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7SalePersonQuery");		
		//this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
		this.prmtSalePerson.setCommitFormat("$person.number$");		
		this.prmtSalePerson.setEditFormat("$number$");		
		this.prmtSalePerson.setDisplayFormat("$name$");		
		this.prmtSalePerson.setEditable(true);		
		this.prmtSalePerson.setRequired(true);

		// 表格融合
		this.kdtForecastTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_ROW_MERGE);
		this.kdtOrdersTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_ROW_MERGE);
		// 自动换行
		//        this.kdtForecastTable.getStyleAttributes().setWrapText(true);
		//        this.kdtOrdersTable.getStyleAttributes().setWrapText(true);
		// 精度设置
		this.kdtForecastTable.getColumn("qty").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtForecastTable.getColumn("qtya").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtForecastTable.getColumn("qtyb").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtForecastTable.getColumn("companyqty").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtForecastTable.getColumn("companyqty").getStyleAttributes().setHided(true);
		//this.kdtForecastTable.getColumn("company").getStyleAttributes().setHided(true);

	}
	public void initAction() throws Exception{
		this.kdtForecastTable.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
			public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
				try {
					kdtForecastTable_Changed(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});

		this.kDTable1.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
			public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
				try {
					KDTable1_Changed(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});
		this.kdtOrdersTable.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtOrdersTable_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});

		kdtForecastTable.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				kdteForecastEditStopped(e);
			}});
		this.btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionInsert_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});

		this.btnAllInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionAllInsert_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});

		this.btnRemove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionRemove_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});

		this.btnQuery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					//					actionQuery_actionPerformed(e);
					actionQueryMaterialInventory(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});

	}


	/**
	 * 查询库存
	 * @param e
	 */
	protected void actionQueryMaterialInventory(ActionEvent e) {
		// TODO Auto-generated method stub
		kDTable1.removeRows();

		String companyID = null ;
		if(prmtCompany.getValue()!=null)
			companyID = ((IPropertyContainer)prmtCompany.getValue()).getString("id");


		String materialID = null;
		if(prmtMaterial.getValue()!=null && ((Object[])prmtMaterial.getValue()).length >0 && ((Object[])prmtMaterial.getValue())[0] != null)
			materialID = ((IPropertyContainer)((Object[]) prmtMaterial.getValue())[0]).getString("id");

		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/").append("\n")
		.append("SELECT companyName,materialNum,materialName,wareHouse,sum(FCurStoreQty) FCurStoreQty,sum(XianPin) XianPin,sum(yubaoQty) yubaoQty,sum(dingDanQty) dingDanQty,sum(chuKuQty) chukuQty").append("\n")
		.append(" from(").append("\n")
		.append("SELECT").append("\n")
		.append(" t2.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum,").append("\n")
		.append(" t4.FName_l2                    materialName,").append("\n")
		.append(" sum(t1.FBaseQty)               FCurStoreQty,").append("\n")
		.append(" t3.FName_l2                    wareHouse,").append("\n")
		.append(" 0                              yubaoQty,").append("\n")
		.append(" 0                              dingDanQty,").append("\n")
		.append(" 0                              chuKuQty,").append("\n")
		.append(" 0                              XianPin").append("\n")
		.append("FROM").append("\n")
		.append("T_IM_Inventory                  t1").append("\n")
		.append("inner join T_ORG_Company        t2 on t2.FID=t1.FCompanyOrgUnitID").append("\n")
		.append("inner join T_DB_WAREHOUSE       t3 on t3.FID=t1.FWarehouseID").append("\n")
		.append("inner join T_BD_Material        t4 on t4.FID=t1.FMaterialID").append("\n")
		.append("inner join T_BD_MaterialGroup   t5 on t5.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t2.FID in ('").append(companyID).append("')").append("\n");
		sb.append("      and t5.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%'  or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("Group by t2.FName_l2,t4.FNumber,t4.FName_l2,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append(" t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" sum(t2.CFBaseQty)                    CFBaseQty,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("CT_LHS_SaleForecast              t1").append("\n")
		.append("inner join CT_LHS_SaleForecastEntry t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Company          t3 on t3.FID=t1.CFCompanyID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.CFMaterialNumberID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n")
		.append("      and t1.FID not in (select fparentid from CT_LHS_SALEFORECASTENTRY2)").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append("  t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" 0                               CFBaseQty,").append("\n")
		.append(" sum(t2.FBaseQty),").append("\n")
		.append(" 0,").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("T_SD_SaleOrder                     t1").append("\n")
		.append("inner join T_SD_SaleOrderEntry    t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Sale             t3 on t3.FID=t1.FSaleOrgUnitID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.FMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("left  join T_BOT_Relation         t7 on t1.FID=t7.FSrcObjectID").append("\n")
		.append("left  join T_IM_SaleIssueBill     t8 on t8.FID=t7.FDestObjectID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n")
		.append("--      and (t2.FTotalIssueBaseQty is null or t2.FTotalIssueBaseQty=0)").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t8.FID is null").append("\n")
		.append("      and t2.FBaseStatus<>3").append("\n")
		.append("      and t1.FBaseStatus not in (4,7)").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append("  t3.FName_l2                    companyName,").append("\n")
		.append(" t4.FNumber                     materialNum, ").append("\n")
		.append(" t4.FName_l2                     materialName,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2                     houseName,").append("\n")
		.append(" 0                               CFBaseQty,").append("\n")
		.append(" 0,").append("\n")
		.append(" sum(t2.FBaseQty),").append("\n")
		.append(" 0").append("\n")
		.append("from ").append("\n")
		.append("T_IM_SaleIssueBill                t1").append("\n")
		.append("inner join T_IM_SaleIssueEntry    t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Storage          t3 on t3.FID=t1.FStorageOrgUnitID").append("\n")
		.append("inner join T_BD_Material          t4 on t4.FID=t2.FMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE         t5 on t5.FID=t2.FwareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t1.FBaseStatus not in (4,7)").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("union all").append("\n")
		.append("").append("\n")
		.append("select").append("\n")
		.append(" t3.FName_l2,").append("\n")
		.append(" t4.FNumber,").append("\n")
		.append(" t4.FName_l2,").append("\n")
		.append(" 0,").append("\n")
		.append(" t5.FName_l2,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" 0,").append("\n")
		.append(" sum(t2.CFWeight)").append("\n")
		.append("from ").append("\n")
		.append("CT_SZC_SzSemiProduct                 t1").append("\n")
		.append("inner join CT_SZC_SzSemiProductEntry t2 on t1.FID=t2.FParentID").append("\n")
		.append("inner join T_ORG_Company             t3 on t3.FID=t1.CFCompanyID").append("\n")
		.append("inner join T_BD_Material             t4 on t4.FID=t2.CFMaterialID").append("\n")
		.append("inner join T_DB_WAREHOUSE            t5 on t5.FID=t2.CFWareHouseID").append("\n")
		.append("inner join T_BD_MaterialGroup     t6 on t6.FID=t4.FMaterialGroupID").append("\n")
		.append("where 1=1 ").append("\n");
		if(StringUtils.isNotEmpty(companyID))
			sb.append(" and t3.FID in ('").append(companyID).append("')").append("\n");
		//		.append("where t3.FID in ('75QAAAAAAeTM567U', '75QAAAAAMlLM567U', '75QAAAAAMorM567U', '75QAAAAAMsLM567U')").append("\n")
		sb.append("      and t6.FLongNumber like '02!0204!%'").append("\n");
		//		.append("      and (t4.FName_l2 like '%%' or t4.FNumber like '%%' or null is null)").append("\n")
		if(StringUtils.isNotEmpty(materialID))
			sb.append(" and t4.FID in ('").append(materialID).append("')").append("\n");
		sb.append("      and t1.CFStatus  in (4,7)").append("\n")
		.append("       and to_char(t1.FBizDate,'yyyyMMdd')=to_char(sysdate-1,'yyyyMMdd')").append("\n")
		.append("group by t4.FName_l2,t5.FName_l2,t4.FNumber,t3.FName_l2").append("\n")
		.append("").append("\n")
		.append("").append("\n")
		.append(")").append("\n")
		.append("group by materialNum,materialName,wareHouse,companyName").append("\n")
		.append("      having (sum(FCurStoreQty)<>0 or sum(XianPin)<>0 or sum(dingDanQty)<>0 or sum(chukuQty)<>0)").append("\n")
		.append("order by materialNum").append("\n");


		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			IRow row;
			while(rs.next()){
				row = kDTable1.addRow();
				row.getCell("materialNum").setValue(rs.getObject("materialNum"));
				row.getCell("materialName").setValue(rs.getObject("materialName"));
				row.getCell("company").setValue(rs.getObject("companyName"));
				row.getCell("warehouse").setValue(rs.getObject("wareHouse"));
				row.getCell("curQty").setValue(rs.getObject("FCurStoreQty"));
				row.getCell("yubaoQty").setValue(rs.getObject("XianPin"));
				row.getCell("dingdanQty").setValue(UIRuleUtil.getBigDecimal(rs.getObject("dingDanQty")).add(UIRuleUtil.getBigDecimal(rs.getObject("chukuQty"))));
				row.getCell("totalQty").setValue(UIRuleUtil.getBigDecimal(row.getCell("curQty").getValue()).add(UIRuleUtil.getBigDecimal(row.getCell("yubaoQty").getValue())));
				row.getCell("canUseQty").setValue(UIRuleUtil.getBigDecimal(row.getCell("totalQty").getValue()).subtract(UIRuleUtil.getBigDecimal(row.getCell("dingdanQty").getValue())));
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * 数量和单价可以变更
	 * @param e
	 */
	protected void kdteForecastEditStopped(KDTEditEvent e) {
		// TODO Auto-generated method stub
		String fieldName = kdtForecastTable.getColumnKey(e.getColIndex());
		if(fieldName.equals("qty")||fieldName.equals("price")){
			kdtForecastTable.getCell(e.getRowIndex(), "amount").setValue(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "price").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "qty").getValue())).setScale(2,RoundingMode.HALF_UP));
			kdtForecastTable.getCell(e.getRowIndex(), "qtyb").setValue(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "qty").getValue()).subtract(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "qtya").getValue())).setScale(2,RoundingMode.HALF_UP));
		}
	}

	public void kdtOrdersTable_Changed(int rowIndex, int colIndex) throws Exception {
		String fieldName = kdtOrdersTable.getColumnKey(colIndex);
		if("qty".equalsIgnoreCase(fieldName)){
			calEntryAmount(rowIndex,colIndex,kdtOrdersTable);
		}else if("price".equalsIgnoreCase(fieldName)){
			calEntryAmount(rowIndex,colIndex,kdtOrdersTable);
		}else if("companyInv".equalsIgnoreCase(fieldName)){
			if(kdtOrdersTable.getCell(rowIndex, "companyInv").getValue() != null){
				CompanyInvInfo cinvinfo = (CompanyInvInfo)kdtOrdersTable.getCell(rowIndex, "companyInv").getValue();
				ObjectUuidPK pk = new ObjectUuidPK(cinvinfo.getCompany().getId());
				CompanyOrgUnitInfo companyinfo=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(pk);
				kdtOrdersTable.getCell(rowIndex, "company").setValue(companyinfo);	
			}
		}
	}
	private void calEntryAmount(int rowIndex, int colIndex,KDTable kdtable) {
		int amtPrecision=2;
		BigDecimal qty = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "qty");
		if(qty == null)
			qty =BigDecimal.ZERO ;
		BigDecimal price = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "price");
		if(price == null)
			price =BigDecimal.ZERO ;
		BigDecimal amount = qty.multiply(price);
		amount = amount.setScale(amtPrecision, 4);
		kdtable.getCell(rowIndex, "amount").setValue(amount);

	}
	protected void KDTable1_Changed(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws EASBizException, BOSException, UuidException, SQLException {
		if (e.getClickCount() == 1) {
			int rowIndex = e.getRowIndex();
			int colIndex = e.getColIndex();
			if(colIndex>=2){
				String fieldName = this.kDTable1.getHeadRow(0).getCell(colIndex).getValue().toString();
				StringBuffer sql=new StringBuffer();
				sql.append(" select * from t_org_company ");
				sql.append(" where fname_l2='"+fieldName+"'  ");
				IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
				if(rs.next()){
					String fcuid=rs.getString("fid");
					if(this.kdtOrdersTable.getBody().size()==0){
						int nrowA=this.kdtForecastTable.getBody().size();
						for (int i= 0; i<nrowA-1; i++) {

							String id=(String)kdtForecastTable.getRow(i).getCell("id").getValue();
							String seq=kdtForecastTable.getRow(i).getCell("seq").getValue().toString();
							entryid=(String)kdtForecastTable.getRow(i).getCell("entryID").getValue();
							materialid=(String)kdtForecastTable.getRow(i).getCell("materialID").getValue();
							//customerid=kdtForecastTable.getRow(rowIndex).getCell("customerID").getValue().toString();
							unitid=kdtForecastTable.getRow(i).getCell("unitID").getValue().toString();

							qtybc= BigDecimal.ZERO;
							if(this.kdtForecastTable.getCell(i, "qtyb").getValue() != null){
								qtybc = new BigDecimal(this.kdtForecastTable.getCell(i, "qtyb").getValue().toString());
							}

							qty= BigDecimal.ZERO;
							if(this.kdtForecastTable.getCell(i, "qty").getValue() != null){
								qty = new BigDecimal(this.kdtForecastTable.getCell(i, "qty").getValue().toString());
							}
							price= BigDecimal.ZERO;
							if(this.kdtForecastTable.getCell(i, "price").getValue() != null){
								price = new BigDecimal(this.kdtForecastTable.getCell(i, "price").getValue().toString());
							}

							InsertOrdersTablecol(i,seq,entryid, materialid, unitid, customerid, fcuid,qtybc,price);
						}
					}
				}
				System.out.println(fieldName);
			}
		}  
	}

	//	protected void KDTable1_Changed(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws EASBizException, BOSException, UuidException, SQLException {
	//		if (e.getClickCount() == 1) {
	//			int rowIndex = e.getRowIndex();
	//			int colIndex = e.getColIndex();
	//			if(colIndex>=2){
	//				String fieldName = this.kDTable1.getHeadRow(0).getCell(colIndex).getValue().toString();
	//				StringBuffer sql=new StringBuffer();
	//				sql.append(" select * from t_org_company ");
	//				sql.append(" where fname_l2='"+fieldName+"'  ");
	//				IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
	//				if(rs.next()){
	//					String fcuid=rs.getString("fid");
	//					if(this.kdtOrdersTable.getBody().size()==0){
	//						int nrowA=this.kdtForecastTable.getBody().size();
	//						for (int i= 0; i<nrowA-1; i++) {
	//
	//							String id=(String)kdtForecastTable.getRow(i).getCell("id").getValue();
	//							String seq=kdtForecastTable.getRow(i).getCell("seq").getValue().toString();
	//							entryid=(String)kdtForecastTable.getRow(i).getCell("entryID").getValue();
	//							materialid=(String)kdtForecastTable.getRow(i).getCell("materialID").getValue();
	//							//customerid=kdtForecastTable.getRow(rowIndex).getCell("customerID").getValue().toString();
	//							unitid=kdtForecastTable.getRow(i).getCell("unitID").getValue().toString();
	//
	//							qtybc= BigDecimal.ZERO;
	//							if(this.kdtForecastTable.getCell(i, "qtyb").getValue() != null){
	//								qtybc = new BigDecimal(this.kdtForecastTable.getCell(i, "qtyb").getValue().toString());
	//							}
	//
	//							qty= BigDecimal.ZERO;
	//							if(this.kdtForecastTable.getCell(i, "qty").getValue() != null){
	//								qty = new BigDecimal(this.kdtForecastTable.getCell(i, "qty").getValue().toString());
	//							}
	//							price= BigDecimal.ZERO;
	//							if(this.kdtForecastTable.getCell(i, "price").getValue() != null){
	//								price = new BigDecimal(this.kdtForecastTable.getCell(i, "price").getValue().toString());
	//							}
	//
	//							InsertOrdersTablecol(i,seq,entryid, materialid, unitid, customerid, fcuid,qtybc,price);
	//						}
	//					}
	//				}
	//				System.out.println(fieldName);
	//			}
	//		}  
	//	}
	protected void kdtForecastTable_Changed(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws EASBizException, BOSException, UuidException, SQLException {
		if (e.getClickCount() == 1) {
			int rowIndex = e.getRowIndex();
			int colIndex = e.getColIndex();
			String id=(String)kdtForecastTable.getRow(rowIndex).getCell("id").getValue();
			if(id!=null){
				entryid=(String)kdtForecastTable.getRow(rowIndex).getCell("entryID").getValue();
				materialid=(String)kdtForecastTable.getRow(rowIndex).getCell("materialID").getValue();


				if(StringUtils.isNotEmpty(materialid)){
					prmtMaterial.setValue(new Object[]{MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materialid))});
				}
				//customerid=kdtForecastTable.getRow(rowIndex).getCell("customerID").getValue().toString();
				if(kdtForecastTable.getRow(rowIndex).getCell("unitID").getValue()!=null){
					unitid=kdtForecastTable.getRow(rowIndex).getCell("unitID").getValue().toString();
				}else{
					unitid="";
				}
				fseq=kdtForecastTable.getRow(rowIndex).getCell("seq").getValue().toString();

				qtybc= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue() != null){
					qtybc = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue().toString());
				}

				qty= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qty").getValue() != null){
					qty = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qty").getValue().toString());
				}
				price= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "price").getValue() != null){
					price = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "price").getValue().toString());
				}
			}
			//initTableDataOrders(this.kdtOrdersTable,entryid,false);
		}  
	}
	/**
	 * 
	 * <p>Title: forecastTableCellChanged</p>
	 * <p>Description: </p>
	 * 焦点变化事件
	 * @param e
	 */
	private void forecastTableCellChanged(KDTEditEvent e){
		int rowIndex = e.getRowIndex();
		int colIndex = e.getColIndex();

		String fieldName = kdtForecastTable.getColumnKey(colIndex);
		if("companyqty".equalsIgnoreCase(fieldName)){
			try{
				BigDecimal companyqty = BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "companyqty").getValue() != null){
					companyqty = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "companyqty").getValue().toString());
				}
				//数量
				BigDecimal qty = BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qty").getValue() != null){
					qty = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qty").getValue().toString());
				}

				//可分配数量
				BigDecimal  qtya= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qtya").getValue() != null){
					qtya = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qtya").getValue().toString());
				}
				//可分配数量
				BigDecimal  qtyb= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue() != null){
					qtyb = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue().toString());
				}

				if(companyqty.compareTo(BigDecimal.ZERO) < 0){
					MsgBox.showInfo("数量必须大于0.");
					//					this.kdtForecastTable.getCell(preRowIndex, preColIndex).setValue(null);
					this.kdtForecastTable.getSelectManager().select(rowIndex,colIndex);
					SysUtil.abort();
				}
				if(companyqty.compareTo(qtyb) > 0){
					MsgBox.showInfo("数量不能大于可分配数.");
					//					this.kdtForecastTable.getCell(preRowIndex, preColIndex).setValue(null);
					this.kdtForecastTable.getSelectManager().select(rowIndex,colIndex);
					SysUtil.abort();

				}
				// 更新可分配数量和已分配数量
				this.kdtForecastTable.getCell(rowIndex, "qtya").setValue((qtya.add(companyqty)).toPlainString());
				this.kdtForecastTable.getCell(rowIndex, "qtyb").setValue((qtyb.subtract(companyqty)).toPlainString());

			}catch(Exception ex){
				SysUtil.abort();
			}
		}
	}

	/**
	 * 
	 * <p>Title: btQuery_actionPerformed</p>
	 * <p>Description:  查询待转换预报单</p>
	 * <p>继承方法</p>
	 * @param e
	 * @throws Exception
	 */

	protected void actionQuery_actionPerformed(ActionEvent e) throws Exception {
		displayData(this.kDTable1);
	}
	public void inittblOrders(KDTable kdTable) throws EASBizException, BOSException, SQLException{
		kdTable.checkParsed();


		// 订单不可编辑
		kdTable.setEditable(true);
		// 选中模式为 行选中 
		kdTable.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		// 订单  客户
		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdTable.getColumn("status").setEditor(kdtEntrys_Status_CellEditor); 

		final KDBizPromptBox kdtEntrys_customer_PromptBox = new KDBizPromptBox();
		kdtEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
		kdtEntrys_customer_PromptBox.setVisible(true);		
		kdtEntrys_customer_PromptBox.setEditable(true);		
		kdtEntrys_customer_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_customer_PromptBox.setEditFormat("$number$");		
		kdtEntrys_customer_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_customer_PromptBox.setRequired(false);
		KDTDefaultCellEditor kdtEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_customer_PromptBox);
		kdTable.getColumn("customer").setEditor(kdtEntrys_customer_CellEditor);
		ObjectValueRender kdtEntrys_customer_OVR = new ObjectValueRender();
		kdtEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("customer").setRenderer(kdtEntrys_customer_OVR);
		//        kdTable.getColumn("customer").getStyleAttributes().setHided(true);
		//        final KDBizPromptBox prmtCompanyInv = new KDBizPromptBox();
		//        prmtCompanyInv.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7CompanyInvQuery");		
		//        prmtCompanyInv.setVisible(true);		
		//        prmtCompanyInv.setEditable(true);		
		//        prmtCompanyInv.setDisplayFormat("$company.number$");		
		//        prmtCompanyInv.setEditFormat("$company.number$");		
		//        prmtCompanyInv.setCommitFormat("$company.number$");		
		//        prmtCompanyInv.setRequired(false);
		//        KDTDefaultCellEditor prmtCompanyInvCellEditor = new KDTDefaultCellEditor(prmtCompanyInv);
		//        kdTable.getColumn("companyInv").setEditor(prmtCompanyInvCellEditor);
		//        ObjectValueRender prmtCompanyInvOVR = new ObjectValueRender();
		//        prmtCompanyInvOVR.setFormat(new BizDataFormat("$name$"));
		//        kdTable.getColumn("companyInv").setRenderer(prmtCompanyInvOVR);
		kdTable.getColumn("companyInv").getStyleAttributes().setHided(true);

		// 订单  发货组织
		final KDBizPromptBox kdtEntrys_deliveryOrg_PromptBox = new KDBizPromptBox();
		kdtEntrys_deliveryOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
		kdtEntrys_deliveryOrg_PromptBox.setVisible(true);		
		kdtEntrys_deliveryOrg_PromptBox.setEditable(true);		
		kdtEntrys_deliveryOrg_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setEditFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setRequired(false);
		Set materialsID = new LinkedHashSet();
		StringBuffer sql=new StringBuffer();
		String materialid="";
		sql=new StringBuffer();
		sql.append("select fnumber,cforgidid fid from T_LHS_SSorgList ");
		IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
		}
		FilterInfo filterInfo=new FilterInfo();
		//filterInfo.getFilterItems().add(new FilterItemInfo("parent.id",cuid,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);	
		kdtEntrys_deliveryOrg_PromptBox.setEntityViewInfo(evi);
		KDTDefaultCellEditor kdtEntrys_deliveryOrg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_deliveryOrg_PromptBox);
		kdTable.getColumn("company").setEditor(kdtEntrys_deliveryOrg_CellEditor);
		ObjectValueRender kdtEntrys_deliveryOrg_OVR = new ObjectValueRender();
		kdtEntrys_deliveryOrg_OVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("company").setRenderer(kdtEntrys_deliveryOrg_OVR);
		// 订单 物料
		final KDBizPromptBox kdtEntrys_materialName_PromptBox = new KDBizPromptBox();
		kdtEntrys_materialName_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");		
		kdtEntrys_materialName_PromptBox.setVisible(true);		
		kdtEntrys_materialName_PromptBox.setEditable(true);		
		kdtEntrys_materialName_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_materialName_PromptBox.setEditFormat("$number$");		
		kdtEntrys_materialName_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_materialName_PromptBox.setRequired(false);

		KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_PromptBox);
		kdTable.getColumn("material").setEditor(kdtEntrys_materialName_CellEditor);
		ObjectValueRender kdtEntrys_materialName_OVR = new ObjectValueRender();
		kdtEntrys_materialName_OVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("material").setRenderer(kdtEntrys_materialName_OVR);

		// 订单 单位
		final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
		kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
		kdtEntrys_unit_PromptBox.setVisible(true);		
		kdtEntrys_unit_PromptBox.setEditable(true);		
		kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_unit_PromptBox.setEditFormat("$number$");		
		kdtEntrys_unit_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_unit_PromptBox.setRequired(false);

		KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
		kdTable.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
		ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
		kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);

		KDFormattedTextField kdtForecastTable_qty_TextField = new KDFormattedTextField();
		kdtForecastTable_qty_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_qty_TextField.setVisible(true);
		kdtForecastTable_qty_TextField.setEditable(true);
		kdtForecastTable_qty_TextField.setHorizontalAlignment(2);
		kdtForecastTable_qty_TextField.setDataType(1);
		kdtForecastTable_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_qty_TextField.setPrecision(4);
		KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_qty_TextField);
		kdTable.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);

		KDFormattedTextField kdtForecastTable_price_TextField = new KDFormattedTextField();
		kdtForecastTable_price_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_price_TextField.setVisible(true);
		kdtForecastTable_price_TextField.setEditable(true);
		kdtForecastTable_price_TextField.setHorizontalAlignment(2);
		kdtForecastTable_price_TextField.setDataType(1);
		kdtForecastTable_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_price_TextField.setPrecision(6);
		KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_price_TextField);
		kdTable.getColumn("price").setEditor(kdtEntrys_price_CellEditor);


		KDFormattedTextField amount_TextField = new KDFormattedTextField();
		amount_TextField.setName("amount_TextField");
		amount_TextField.setVisible(true);
		amount_TextField.setEditable(true);
		amount_TextField.setHorizontalAlignment(2);
		amount_TextField.setDataType(1);
		amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		amount_TextField.setPrecision(2);
		KDTDefaultCellEditor amount_CellEditor = new KDTDefaultCellEditor(amount_TextField);
		kdTable.getColumn("amount").setEditor(amount_CellEditor);
	}

	public void inittblForecast(KDTable kdTable) throws EASBizException, BOSException, SQLException{
		this.kdtForecastTable.checkParsed();

		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdTable.getColumn("status").setRenderer(new CellCheckBoxRenderer());

		// 设置发货组织编辑样式
		final KDBizPromptBox kdtEntrys_senderCompany_PromptBox = new KDBizPromptBox();
		kdtEntrys_senderCompany_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
		kdtEntrys_senderCompany_PromptBox.setVisible(true);		
		kdtEntrys_senderCompany_PromptBox.setEditable(true);		
		kdtEntrys_senderCompany_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setEditFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setRequired(false);
		Set materialsID = new LinkedHashSet();
		StringBuffer sql=new StringBuffer();
		String materialid="";
		sql=new StringBuffer();
		sql.append("select fnumber,cforgidid fid from T_LHS_SSorgList ");
		IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
		}
		FilterInfo filterInfo=new FilterInfo();
		//filterInfo.getFilterItems().add(new FilterItemInfo("parent.id",cuid,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id",materialsID,CompareType.INCLUDE));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);	
		kdtEntrys_senderCompany_PromptBox.setEntityViewInfo(evi);
		KDTDefaultCellEditor kdtEntrys_materialNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_senderCompany_PromptBox);
		this.kdtForecastTable.getColumn("company").setEditor(kdtEntrys_materialNumber_CellEditor);
		ObjectValueRender kdtEntrys_materialNumber_OVR = new ObjectValueRender();
		kdtEntrys_materialNumber_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtForecastTable.getColumn("company").setRenderer(kdtEntrys_materialNumber_OVR);
		this.kdtForecastTable.getColumn("company").getStyleAttributes().setHided(false);
		// 数量编辑
		KDFormattedTextField kdtForecastTable_deliveryAccount_TextField = new KDFormattedTextField();
		kdtForecastTable_deliveryAccount_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_deliveryAccount_TextField.setVisible(true);
		kdtForecastTable_deliveryAccount_TextField.setEditable(true);
		kdtForecastTable_deliveryAccount_TextField.setHorizontalAlignment(2);
		kdtForecastTable_deliveryAccount_TextField.setDataType(1);
		kdtForecastTable_deliveryAccount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setPrecision(4);
		KDTDefaultCellEditor kdtEntrys_measureUnitAccount_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_deliveryAccount_TextField);
		this.kdtForecastTable.getColumn("qty").setEditor(kdtEntrys_measureUnitAccount_CellEditor);


		KDFormattedTextField kdtForecastTable_price_TextField = new KDFormattedTextField();
		kdtForecastTable_price_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_price_TextField.setVisible(true);
		kdtForecastTable_price_TextField.setEditable(true);
		kdtForecastTable_price_TextField.setHorizontalAlignment(2);
		kdtForecastTable_price_TextField.setDataType(1);
		kdtForecastTable_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_price_TextField.setPrecision(6);
		KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_price_TextField);
		kdTable.getColumn("price").setEditor(kdtEntrys_price_CellEditor);


		KDFormattedTextField amount_TextField = new KDFormattedTextField();
		amount_TextField.setName("amount_TextField");
		amount_TextField.setVisible(true);
		amount_TextField.setEditable(true);
		amount_TextField.setHorizontalAlignment(2);
		amount_TextField.setDataType(1);
		amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		amount_TextField.setPrecision(2);
		KDTDefaultCellEditor amount_CellEditor = new KDTDefaultCellEditor(amount_TextField);
		kdTable.getColumn("amount").setEditor(amount_CellEditor);

	}
	public void inittblForecastData(KDTable kdTable) throws EASBizException, BOSException, SQLException{
		// 清理界面项目
		kdTable.removeRows();
		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdTable.getColumn("status").setRenderer(new CellCheckBoxRenderer());
		ObjectUuidPK pk =null;// 需要修改
		materialids="";
		StringBuilder sql =  new StringBuilder();
		sql.append(" select t1.*,t2.fid fentryid  ");
		sql.append(" from CT_LHS_SALEFORECAST t1");
		sql.append(" inner join ct_lhs_saleForecastentry t2 on t2.fparentid=t1.fid ");
		sql.append(" where  t1.fid='"+id+"' ");
		sql.append(" order by t2.fseq");
		ICell cell;
		IRow row;
		IRowSet rs = ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());

		if(rs != null && rs.size() > 0){
			int m=0;
			BigDecimal baseqtyt=BigDecimal.ZERO;
			BigDecimal qtyat=BigDecimal.ZERO;
			BigDecimal qtybt=BigDecimal.ZERO;
			BigDecimal amountt=BigDecimal.ZERO;
			while(rs.next()){
				SaleForecastEntryInfo currEntry = SaleForecastEntryFactory.getRemoteInstance().getSaleForecastEntryInfo(new ObjectUuidPK(rs.getString("fentryid")));
				row = kdTable.addRow();

				cell = row.getCell("status");
				kdtEntrys_Status_CellEditor.setValue(false);
				cell.setEditor(kdtEntrys_Status_CellEditor);

				cell = row.getCell("seq");
				cell.setValue(currEntry.getSeq());

				cell = row.getCell("entryID");
				cell.setValue(currEntry.getId().toString());

				cell = row.getCell("id");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("FID"));

				materialid=currEntry.getMaterialNumber().getId().toString();
				if(materialids.equals("")){
					materialids="'"+materialid+"'";
				}else{
					materialids=materialids+",'"+materialid+"'";
				}

				cell = row.getCell("materialID");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(materialid);

				cell = row.getCell("materialName");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(currEntry.getMaterialName());
				if(currEntry.getCompany()!=null){
					pk=new ObjectUuidPK(currEntry.getCompany().getId());
					SaleOrgUnitInfo orgunitInfo=SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(pk);
					cell = row.getCell("company");
					cell.getStyleAttributes().setLocked(true);
					cell.setValue(orgunitInfo);
				}
				// 单位
				if(currEntry.getBaseUnit()!=null){
					MeasureUnitInfo unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(currEntry.getBaseUnit().getId()));
					if(unit != null){
						cell = row.getCell("unit");
						cell.getStyleAttributes().setLocked(true);
						cell.setValue(unit.getName());

						cell= row.getCell("unitID");
						cell.getStyleAttributes().setLocked(true);
						cell.setValue(unit.getId().toString());
					}
				}
				//  总数量
				BigDecimal baseqty = BigDecimal.ZERO;
				baseqty.setScale(2);
				cell = row.getCell("qty");
				cell.getStyleAttributes().setLocked(true);
				if(currEntry.getBaseQty()!= null){
					baseqty = currEntry.getBaseQty();
					fqtytotal=fqtytotal.add(baseqty);
					baseqtyt=baseqtyt.add(baseqty);
				}
				cell.setValue(baseqty.toPlainString());

				cell = row.getCell("price");
				cell.setValue(currEntry.getBasePrice());//id

				amountt=amountt.add(currEntry.getAmount());
				cell = row.getCell("amount");
				cell.setValue(currEntry.getAmount());//id

				// 已分配数量
				BigDecimal qtya = BigDecimal.ZERO;
				qtya.setScale(2);
				cell = row.getCell("qtya");
				cell.getStyleAttributes().setLocked(true);
				if(currEntry.getQtya()!= null){
					qtya = currEntry.getQtya();	
					qtyat=qtyat.add(qtya);
				}
				cell.setValue(qtya);
				if(qtya.compareTo(BigDecimal.ZERO) == 0){
					row.getCell("qty").getStyleAttributes().setLocked(false);
				}



				// 可用数量
				BigDecimal qtyb = BigDecimal.ZERO;
				qtyb.setScale(2);
				cell= row.getCell("qtyb");
				cell.getStyleAttributes().setLocked(true);
				if(currEntry.getQtyb()!= null){
					qtyb = currEntry.getQtyb();	
					qtybt=qtybt.add(qtyb);
				}
				cell.setValue(qtyb);

				cell= row.getCell("remark");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(currEntry.getRemark());
				m=m+1;
			}

			row = kdTable.addRow(m);
			cell = row.getCell("qty");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(baseqtyt);

			cell = row.getCell("amount");
			cell.setValue(amountt);//id

			// 已分配数量
			cell = row.getCell("qtya");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(qtyat);

			// 可用数量
			cell= row.getCell("qtyb");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(qtybt);
			java.awt.Color rowColor=new Color(255,128,0);
			kdTable.getRow(m).getStyleAttributes().setBackground(rowColor);
			kdTable.getRow(m).getStyleAttributes().setLocked(true);

		}
		//this.kdtForecastTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_MERGE);
	}
	public void initTableDataOrders(KDTable kdTable) throws BOSException, EASBizException, UuidException, SQLException
	{
		kdTable.removeRows();

		IRow row;
		ICell cell;
		ObjectUuidPK pk=null;
		StringBuffer sql =new StringBuffer();

		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdTable.getColumn("status").setRenderer(new CellCheckBoxRenderer());

		sql =new StringBuffer();
		sql.append(" Select t1.*,isnull(t2.fnumber,'') fsalenumber ");
		sql.append(" from CT_LHS_SALEFORECASTENTRY2 t1 ");
		sql.append(" left join t_sd_saleorder t2 on t2.fid=t1.fsaleorderid ");
		sql.append(" where t1.fparentid='"+this.id+"'");
		sql.append(" order by t1.fseq ");
		IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		int m= 0;
		while(rs.next()){
			row = kdTable.addRow(m);

			row.getStyleAttributes().setBackground(Color.green);

			cell = row.getCell("seq");
			cell.setValue(rs.getString("fseq"));//id

			cell = row.getCell(kdTable.getColumnIndex("id"));
			cell.setValue(rs.getString("fid"));//id

			cell = row.getCell(kdTable.getColumnIndex("entryid"));
			cell.setValue(rs.getString("fentryid"));//id

			pk = new ObjectUuidPK(rs.getString("fmaterialid"));
			MaterialInfo minfo=MaterialFactory.getRemoteInstance().getMaterialInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("material"));
			cell.setValue(minfo);//id

			pk = new ObjectUuidPK(rs.getString("fcustomerid"));
			CustomerInfo cinfo=CustomerFactory.getRemoteInstance().getCustomerInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("customer"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(cinfo);//id


			pk = new ObjectUuidPK(rs.getString("fcompanyid"));
			SaleOrgUnitInfo coinfo=SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("company"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(coinfo);//id

			pk = new ObjectUuidPK(rs.getString("funitid"));
			MeasureUnitInfo unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("unit"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(unit);//id

			cell = row.getCell("qty");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getBigDecimal("fqty"));//id

			cell = row.getCell("price");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getBigDecimal("fprice"));//id

			cell = row.getCell("amount");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getBigDecimal("famount"));//id

			cell = row.getCell(kdTable.getColumnIndex("companyInv"));
			cell.getStyleAttributes().setLocked(true);

			//if(rs.getString("fsaleorderid")!=null){
			//pk = new ObjectUuidPK(rs.getString("fsaleorderid"));
			//SaleOrderInfo saleorderinfo =SaleOrderFactory.getRemoteInstance().getSaleOrderInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("saleOrder"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getString("fsalenumber"));//id
			//}
			kdTable.getRow(m).getCell("id").getStyleAttributes().setHided(true);
			kdTable.getRow(m).getCell("status").getStyleAttributes().setLocked(true);
			kdTable.getRow(m).getCell("status").setEditor(kdtEntrys_Status_CellEditor);
			m=m+1;
		}

	}

	public void InsertOrdersTablecol(int rowindex,String seq,String entryid,
			String materialid,String unitid,String customerid,String fcuid,
			BigDecimal qty,BigDecimal price) throws EASBizException, BOSException{
		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		if(!entryid.equals("")){
			Date date=new Date();
			this.kdtOrdersTable.addRow(rowindex);

			kdtOrdersTable.getRow(rowindex).getCell("seq").setValue(seq);

			kdtOrdersTable.getRow(rowindex).getCell("entryid").setValue(entryid);

			ObjectUuidPK pk = new ObjectUuidPK(materialid);
			MaterialInfo minfo=MaterialFactory.getRemoteInstance().getMaterialInfo(pk);
			kdtOrdersTable.getRow(rowindex).getCell("material").setValue(minfo);

			pk = new ObjectUuidPK(unitid);
			MeasureUnitInfo unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(pk);
			kdtOrdersTable.getRow(rowindex).getCell("unit").setValue(unit);

			pk = new ObjectUuidPK(customerid);
			CustomerInfo cinfo=CustomerFactory.getRemoteInstance().getCustomerInfo(pk);
			kdtOrdersTable.getRow(rowindex).getCell("customer").setValue(cinfo);

			if(!fcuid.equals("")){
				pk=new ObjectUuidPK(fcuid);
				SaleOrgUnitInfo saleorgInfo=SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(pk);
				kdtOrdersTable.getRow(rowindex).getCell("company").setValue(saleorgInfo);
			}
			kdtOrdersTable.getRow(rowindex).getCell("price").setValue(price);
			kdtOrdersTable.getRow(rowindex).getCell("qty").setValue(qty);
			BigDecimal amount=qty.multiply(price);
			amount=amount.setScale(2,4);
			kdtOrdersTable.getRow(rowindex).getCell("amount").setValue(amount);

			kdtOrdersTable.getRow(rowindex).getCell("status").getStyleAttributes().setLocked(false);
			kdtOrdersTable.getRow(rowindex).getCell("status").setEditor(kdtEntrys_Status_CellEditor);
		}
	}
	protected void actionAllInsert_actionPerformed(ActionEvent e) {
		int nrowA=this.kdtForecastTable.getBody().size();
		for (int i= 0; i<nrowA; i++) {
			kdtForecastTable.getRow(i).getCell("status").setValue(true);
		}
	}
	public void actionInsert_actionPerformed(ActionEvent e) throws Exception {
		int nrowA=this.kdtForecastTable.getBody().size();
		int m=this.kdtOrdersTable.getBody().size();
		String fcuid="";
		for (int i= 0; i<nrowA-1; i++) {

			String id=(String)kdtForecastTable.getRow(i).getCell("id").getValue();
			String seq=(String)kdtForecastTable.getRow(i).getCell("seq").getValue().toString();
			entryid=(String)kdtForecastTable.getRow(i).getCell("entryID").getValue();
			materialid=kdtForecastTable.getRow(i).getCell("materialID").getValue().toString();
			//customerid=kdtForecastTable.getRow(rowIndex).getCell("customerID").getValue().toString();
			unitid=kdtForecastTable.getRow(i).getCell("unitID").getValue().toString();

			qtybc= BigDecimal.ZERO;
			if(this.kdtForecastTable.getCell(i, "qtyb").getValue() != null){
				qtybc = new BigDecimal(this.kdtForecastTable.getCell(i, "qtyb").getValue().toString());
			}

			qty= BigDecimal.ZERO;
			if(this.kdtForecastTable.getCell(i, "qty").getValue() != null){
				qty = new BigDecimal(this.kdtForecastTable.getCell(i, "qty").getValue().toString());
			}
			price= BigDecimal.ZERO;
			if(this.kdtForecastTable.getCell(i, "price").getValue() != null){
				price = new BigDecimal(this.kdtForecastTable.getCell(i, "price").getValue().toString());
			}
			fcuid="";
			if(this.kdtForecastTable.getCell(i, "company").getValue() != null){
				SaleOrgUnitInfo orgunitinfo=(SaleOrgUnitInfo)this.kdtForecastTable.getCell(i, "company").getValue();
				fcuid=orgunitinfo.getId().toString();
			}
			Boolean FStatus;
			//ICellEditor aa=(ICellEditor).getEditor();
			FStatus =(Boolean)kdtForecastTable.getRow(i).getCell("status").getValue();
			if(FStatus!=null){
				if(FStatus.booleanValue()==true){
					InsertOrdersTablecol(m,seq,entryid, materialid, unitid, customerid, fcuid,qtybc,price);
					m=m+1;
				}
			}
		}
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		/*int nrowA=this.kdtOrdersTable.getBody().size();
		for (int i= 0; i<nrowA; i++) {
        	Boolean FStatus;
        	ICellEditor aa=(ICellEditor)kdtOrdersTable.getRow(i).getCell("status").getEditor();
			FStatus =(Boolean)aa.getValue();
			if(FStatus!=null){
				if(FStatus.booleanValue()==true){
					kdtOrdersTable.removeRow(i);
				}
			}
		}*/
		int[] ss = KDTableUtil.getSelectedRows(kdtOrdersTable);
		for(int i=0;i<ss.length;i++) {
			kdtOrdersTable.removeRow(i);
		}
	}
	/**
	 * 转换成订单
	 * <p>Title: btAddOrder_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btAddOrder_actionPerformed(ActionEvent e) throws Exception {

		StringBuffer sql=new StringBuffer();
		HashMap hp=new HashMap();
		int nrowA=this.kdtOrdersTable.getBody().size();
		BigDecimal qtya =new BigDecimal("0");

		String remarks="";
		remarks=this.txtRemark.getText();
		if(remarks==null)remarks="";
		sql=new StringBuffer();
		int m=0;

		/*// 校验当前单据数量是否超标
		HashMap<Object, BigDecimal> materialMap = new HashMap<Object, BigDecimal>();
		HashMap<Object, BigDecimal> actualMaterialMap = new HashMap<Object, BigDecimal>();

		for(int i=0;i<kdtForecastTable.getRowCount();i++){
			if(!materialMap.containsKey(kdtForecastTable.getCell(i, "materialID").getValue()))
				materialMap.put(kdtForecastTable.getCell(i, "materialID").getValue(),UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(i, "qty").getValue()));
			else
				materialMap.put(kdtForecastTable.getCell(i, "materialID").getValue(),UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(i, "qty").getValue()).add(materialMap.get(kdtForecastTable.getCell(i, "materialID").getValue())));
		}
		for(int i=0;i<kdtOrdersTable.getRowCount();i++){
			if(!actualMaterialMap.containsKey(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id")))
				actualMaterialMap.put(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id"),UIRuleUtil.getBigDecimal(kdtOrdersTable.getCell(i, "qty").getValue()));
			else
				actualMaterialMap.put(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id"),UIRuleUtil.getBigDecimal(kdtOrdersTable.getCell(i, "qty").getValue()).add(actualMaterialMap.get(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id"))));			
			if(actualMaterialMap.get(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id")).compareTo(materialMap.get(((MaterialInfo)kdtOrdersTable.getCell(i, "material").getValue()).getString("id"))) >0){
				commUtils.giveUserTipsAndRetire("订单数量不能大于预报单数量");
			}
		}*/


		for (int i= 0; i<nrowA; i++) {
			String id="";
			if(this.kdtOrdersTable.getCell(i, "id").getValue()!=null){
				id=this.kdtOrdersTable.getCell(i, "id").getValue().toString();
			}




			String seq=this.kdtOrdersTable.getCell(i, "seq").getValue().toString();

			String entryid=this.kdtOrdersTable.getCell(i, "entryid").getValue().toString();

			CustomerInfo cinfo=(CustomerInfo)this.kdtOrdersTable.getCell(i, "customer").getValue();
			if(cinfo==null){
				MsgBox.showError("客户不能为空");
				SysUtil.abort();
			}

			MaterialInfo minfo=(MaterialInfo)this.kdtOrdersTable.getCell(i, "material").getValue();
			if(minfo==null){
				MsgBox.showError("物料不能为空");
				SysUtil.abort();
			}

			MeasureUnitInfo unitinfo=(MeasureUnitInfo)this.kdtOrdersTable.getCell(i, "unit").getValue();
			if(minfo==null){
				MsgBox.showError("计量单位不能为空");
				SysUtil.abort();
			}

			SaleOrgUnitInfo corginfo=(SaleOrgUnitInfo)this.kdtOrdersTable.getCell(i, "company").getValue();
			if(corginfo==null){
				MsgBox.showError("公司不能为空");
				SysUtil.abort();
			}
			//kdtResolve.getRow(i).getCell("date").setValue(getServerDate());
			BigDecimal qty = SCMClientUtils.castToBigDecimalForCell(kdtOrdersTable, i, "qty");
			if(qty==null){
				qty=BigDecimal.ZERO;
			}

			BigDecimal price = SCMClientUtils.castToBigDecimalForCell(kdtOrdersTable, i, "price");
			if(price==null){
				price=BigDecimal.ZERO;
			}

			BigDecimal amount = SCMClientUtils.castToBigDecimalForCell(kdtOrdersTable, i, "amount");
			if(amount==null){
				amount=BigDecimal.ZERO;
			}

			int val=qty.compareTo(new BigDecimal("0"));
			if(val==0||val==-1){
				MsgBox.showError("合同分解第"+String.valueOf(i+1)+"行数量必须大于0");
				SysUtil.abort();
			}else{
				qtya=qtya.add(qty);
			}

			if(id.equals("")){
				sql=new StringBuffer();
				sql.append("");
				sql.append("insert into CT_LHS_SALEFORECASTENTRY2(");
				sql.append(" FID,FParentID,fseq,Fentryid,FCustomerID,");
				sql.append(" FMaterialID,FCompanyID,FSaleOrderID,");
				sql.append(" funitid,");
				sql.append(" FQty,FPrice,famount,");
				sql.append(" FRemarks");
				sql.append(" )values( ");
				sql.append(" dbo.newbosid('6777A21D'),'"+this.id+"','"+seq+"','"+entryid+"','"+cinfo.getId().toString()+"',");
				sql.append(" '"+minfo.getId().toString()+"','"+corginfo.getId().toString()+"','',");
				sql.append(" '"+unitinfo.getId().toString()+"',");
				sql.append(" '"+String.valueOf(qty)+"','"+String.valueOf(price)+"','"+String.valueOf(amount)+"',");
				sql.append(" '"+remarks+"' ");
				sql.append(" );");
				hp.put(m, sql.toString());
				m=m+1;
			}else{

			}
		}

		IToolFacade is = ToolFacadeFactory.getRemoteInstance();

		int val=qtya.compareTo(fqtytotal);
		/*	if(val>0){
			MsgBox.showError("合同分解数量必须小于合同数量！");
			SysUtil.abort();
		}else{
			for(m=0;m<hp.size();m++){
				sql=new StringBuffer();
				sql.append(hp.get(m));
				is.execute(sql.toString());
			}
		}*/
		for(m=0;m<hp.size();m++){
			sql=new StringBuffer();
			sql.append(hp.get(m));
			is.execute(sql.toString());
		}
		sql=new StringBuffer();
		sql.append(" /*dialect*/update CT_LHS_SALEFORECASTENTRY t1 set t1.cfqtya=(");
		sql.append(" select t2.fqty from (");
		sql.append(" select sum(fqty) fqty ,fentryid from CT_LHS_SALEFORECASTENTRY2 group by fentryid ");
		sql.append(" ) t2 where t2.fentryid=t1.fid ");
		sql.append(" ) ");
		sql.append(" where t1.fparentid='"+this.id+"' ");
		is.execute(sql.toString());

		sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECASTENTRY set cfqtyb=cfbaseqty-isnull(cfqtya,0) ");
		sql.append(" where fparentid='"+this.id+"' ");
		is.execute(sql.toString());

		sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set cfstate=5 ");//分配完毕
		sql.append(" where fid='"+this.id+"' ");
		sql.append(" and fid not in(");
		sql.append(" select fparentid from  CT_LHS_SALEFORECASTENTRY  ");
		sql.append(" where cfqtyb>0  and fparentid='"+this.id+"'  ) ");
		is.execute(sql.toString());

		ForecastOrderFacadeFactory.getRemoteInstance().saleorder(this.id);
		this.inittblForecastData(this.kdtForecastTable);
		this.initTableDataOrders(this.kdtOrdersTable);
		MsgBox.showInfo("销售订单已经生成");
		ForecastOrderFacadeFactory.getRemoteInstance().updateSaleForecast(this.id);


	}
	/**
	 * 转换前校验预报单编辑状态
	 * <p>Title: checkForecastTableState</p>
	 * <p>Description: </p>
	 *
	 */
	private void checkForecastTableState(){

		for(int i = 0; i < this.kdtForecastTable.getRowCount(); i++){

			ICell deliveryAccountCell = this.kdtForecastTable.getCell(i, "deliveryAccount");
			// 分配了数量的分录生成订单
			if(deliveryAccountCell !=null && deliveryAccountCell.getValue() != null && (new BigDecimal(deliveryAccountCell.getValue().toString()).compareTo(BigDecimal.ZERO) > 0)){
				if(this.kdtForecastTable.getCell(i, "deliveryOrg") == null){
					MsgBox.showInfo("第" + (i + 1) + "行预报单未选择发货组织。");
					SysUtil.abort();
				}
			}
			// 分配了数量的分录生成订单
			if(this.kdtForecastTable.getCell(i, "deliveryOrg") != null && this.kdtForecastTable.getCell(i, "deliveryOrg").getValue() != null){
				if(deliveryAccountCell ==null || deliveryAccountCell.getValue() == null || (new BigDecimal(deliveryAccountCell.getValue().toString()).compareTo(BigDecimal.ZERO) <= 0)){

					MsgBox.showInfo("第" + (i + 1) + "行预报单未分配数量。");
					SysUtil.abort();
				}
			}
		}
	}

	protected void btDelOrderEntry_actionPerformed(ActionEvent e)
	throws Exception {
		// 是否转换标志
		boolean hasReject = false;

		//		String[] msg = new String[2];
		KDTSelectBlock sb = this.kdtOrdersTable.getSelectManager().get();
		if(sb == null) SysUtil.abort();
		if(MsgBox.showConfirm2("确认删除当前选中的订单分录？") != MsgBox.YES){
			SysUtil.abort();
		}
		int top = sb.getTop();
		int bottom = sb.getBottom();

		for(int i = 0; i < this.kdtOrdersTable.getRowCount() && (i >=  top && i <= bottom) ; i++){
			hasReject = true;
			this.kdtOrdersTable.removeRow(i);

		}

		if(!hasReject){
			MsgBox.showInfo("未选中任何一条记录，不能进行删除。");
			SysUtil.abort();
		}

	}
	/**
	 * 订单保存
	 * <p>Title: btSaveOrders_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btSaveOrders_actionPerformed(ActionEvent e) throws Exception {
		ForecastOrderFacadeFactory.getRemoteInstance().saleorder(this.id);
		this.initTableDataOrders(this.kdtOrdersTable);
		MsgBox.showInfo("销售订单已经生成");
	}

	public void checkSelected(KDTable tblMain){
		if(tblMain.getRowCount() == 0 || tblMain.getSelectManager().size() == 0){
			MsgBox.showWarning(this, EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_MustSelected"));
			SysUtil.abort();
		}
	}
	protected String getSelectedKeyValue(KDTable tblMain){
		String keyFiledName ="id";
		int selectRows[] = KDTableUtil.getSelectedRows(tblMain);
		int selectIndex = -1;
		if(selectRows.length > 0)
			selectIndex = selectRows[0];

		//return ListUiHelper.getSelectedKeyValue(selectIndex, tblMain, keyFiledName);
		return tblMain.getRow(selectIndex).getCell(0).getValue().toString();
	}
	/**
	 * 驳回操作
	 * <p>Title: btReject_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btReject_actionPerformed(ActionEvent e) throws Exception {
		checkSelected(this.kdtForecastTable);
		String id=getSelectedKeyValue(this.kdtForecastTable);

		if(MsgBox.showConfirm2("确认驳回当前选中的销售预报单？") != MsgBox.YES){
			SysUtil.abort();
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set CFSTATE=-1 ");
		sql.append(" where fid='"+id+"' ");
		ToolFacadeFactory.getRemoteInstance().execute(sql.toString());
		inittblForecastData(this.kdtForecastTable);
		MsgBox.showInfo("驳回完成");
	}
	/**
	 * 手动关闭预报单
	 * <p>Title: btCloseForecast_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btCloseForecast_actionPerformed(ActionEvent e)
	throws Exception {
		checkSelected(this.kdtForecastTable);
		String id=getSelectedKeyValue(this.kdtForecastTable);

		if(MsgBox.showConfirm2("确认关闭当前选中的销售预报单？") != MsgBox.YES){
			SysUtil.abort();
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set CFSTATE=4 ");
		sql.append(" where fid='"+id+"' ");
		ToolFacadeFactory.getRemoteInstance().execute(sql.toString());
		inittblForecastData(this.kdtForecastTable);
		MsgBox.showInfo("关闭完成");
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	//    protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
	//	{
	//		com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer oufip=(com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer)com.kingdee.bos.ctrl.extendcontrols.ext.FilterInfoProducerFactory.getOrgUnitFilterInfoProducer(orgType);
	//		oufip.getModel().setIsCUFilter(true);
	//		f7.setFilterInfoProducer(oufip);
	//	}
	private void dataUtil(KDTable tbl, String heads[], int[] boolcol,
			StringBuffer sql) throws EASBizException, BOSException {

		tbl.removeRows();
		tbl.removeColumns();

		int colCount = heads.length;
		int headRowCount = 1;
		int rowCount = 100;
		int i;
		int j;

		// 添加列
		IColumn col;
		for (i = 0; i < colCount; i++) {
			col = tbl.addColumn(i);
			// 设置锁定
			if (i > 2) {
				col.getStyleAttributes().setLocked(true);
			}
			// 设置id列隐藏
			if (i==(colCount-1)) {
				col.getStyleAttributes().setHided(true);
			}

		}

		// 添加表头行
		IRow row;
		ICell cell;
		for (i = 0; i < headRowCount; i++) {
			// 添加空表头行
			row = tbl.addHeadRow(i);
			for (j = 0; j < colCount; j++) {
				// 获取表头行的单元，并设置单元的值
				cell = row.getCell(j);
				cell.setValue(heads[j]);
			}
		}

		IRowSet rs;
		try {
			rs = ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
			i = 0;
			while (rs.next()) {
				// 添加空表体行
				row = tbl.addRow(i);
				i++;
				// 获取表头行的单元，并设置单元的值

				for (j = 0; j < colCount; j++) {
					cell = row.getCell(j);
					cell.setValue(rs.getString(j + 1));
					if (isBoolCol(j, boolcol)) {
						cell.setValue(rs.getBoolean(j + 1));

					} else {
						cell.setValue(rs.getString(j + 1));
					}
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			handUIException(e);
		}
	}
	// 判断是否是Bool列
	private boolean isBoolCol(int n, int[] boolcol) {
		boolean isBool = false;
		for (int m = 0; m < boolcol.length; m++) {
			if (n == boolcol[m]) {
				isBool = true;
				return isBool;
			}
		}
		return isBool;
	}
	// 展示数据
	protected void displayData(KDTable tbl) throws Exception {
		String heads[] = null;
		int i=2;
		String companyids="";
		int[] boolcol = new int[] { 1, 2, 42, 43 };
		boolcol = new int[]{};
		StringBuffer sql = new StringBuffer("");
		heads = new String[] {"物料编码","物料名称"};
		LinkedHashMap map=new LinkedHashMap();
		map.put("0", "物料编码");
		map.put("1", "物料名称");

		sql=new StringBuffer();
		sql.append("select t1.fcompanyorgunitid fcompanyid,t1.fmaterialid,t1.fbaseqty fqty ");
		sql.append(" from T_IM_Inventory t1");
		sql.append(" inner join T_LHS_SSorgList t2 on t2.cforgidid=t1.fcompanyorgunitid");
		sql.append(" where t1.fmaterialid in("+this.materialids+")");
		IRowSet rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
		ForecastOrderFacadeFactory.getRemoteInstance().companyInv("",materialids);

		sql= new StringBuffer("");
		sql.append("select t1.* from t_org_company  t1");

		if(this.prmtCompany.getText().equals("")){
			sql.append(" inner join T_LHS_SSorgList t2 on t2.cforgidid =t1.fid ");
		}else{
			Object[] sous = new Object[]{this.prmtCompany.getValue()};
			for(int m=0;m<sous.length;m++){
				CompanyOrgUnitInfo fou = (CompanyOrgUnitInfo)sous[m];
				if(fou!=null){
					if(companyids.equals("")){
						companyids="'"+fou.getId().toString()+"'";
					}else{
						companyids=companyids+",'"+fou.getId().toString()+"'";
					}
				}
			}
			if(!companyids.equals("")){
				sql.append(" where fid in("+companyids+") ");
			}else{
				sql.append(" where fparentid='"+cuid+"'");
			}
		}
		sql.append(" order  by t1.fnumber ");
		rs=ToolFacadeFactory.getRemoteInstance().executeQuery(sql.toString());

		companyids="";
		sql = new StringBuffer("");
		sql.append(" /*dialect*/select ");
		sql.append(" t3.fnumber,t3.fname_l2,");
		while(rs.next()){
			String cunumber=rs.getString("FNumber");
			String cuname=rs.getString("FName_L2");
			map.put(String.valueOf(i),cuname);
			i=i+1;
			sql.append(" sum((case when t2.fnumber='"+cunumber+"' then t1.cfqty2 else 0 end)) ");
			sql.append(" as F" +cunumber+ ", ");
		}
		map.put(String.valueOf(i),"状态");
		sql.append(" 0 fstatus ");
		sql.append(" from ct_lhs_companyinv t1 ");
		sql.append(" inner join t_org_company t2 on t2.fid=t1.cfcompanyid ");
		sql.append(" inner join t_bd_material t3 on t3.fid=t1.cfmaterialid ");
		if(this.prmtMaterial.getValue()==null){
			sql.append("where t3.fid in("+this.materialids+")");
		}else{
			Object[] sous = (Object[])this.prmtMaterial.getValue();
			for(int m=0;m<sous.length;m++){
				MaterialInfo fou = (MaterialInfo)sous[m];
				if(fou!=null){
					if(companyids.equals("")){
						companyids="'"+fou.getId().toString()+"'";
					}else{
						companyids=companyids+",'"+fou.getId().toString()+"'";
					}
				}
			}
			if(!companyids.equals("")){
				sql.append("where t3.fid in("+companyids+") ");
			}else{
				sql.append("where t3.fid in("+this.materialids+")");
			}
		}
		sql.append(" group by t3.fnumber,t3.fname_l2 ");
		sql.append(" order by t3.fnumber ");

		heads = new String[map.size()];
		for(int j=0;j<map.size();j++){
			heads[j]=(String)map.get(String.valueOf(j));
		}

		dataUtil(tbl, heads, boolcol, sql);
	}

	@Override
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
	}
	private void detailMouseClickGetQtyAndNewPrice() {
		// TODO Auto-generated method stub
		final KDFrame fram=new KDFrame();
		fram.setSize(400,250);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width - 300;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height - 300;
		fram.setLocation(x-100, y-7);


		//基本信息以textArea展示
		fram.setTitle("近期价格查看");
		KDTextArea txtArea=new KDTextArea();
		txtArea.setEnabled(false);
		txtArea.setBackground(new Color(222,243,255));
		txtArea.setFont(new Font("宋体",Font.BOLD,12));
		txtArea.setText("最新价格");
		txtArea.setSize(50, 80);

		//饲料以KDTable展示
		final KDTable table1=new KDTable();
		table1.setSize(100,170);
		table1.setBackground(new Color(222,243,255));
		table1.addHeadRow();

		table1.addColumns(1);

		table1.getColumn(0).setKey("price");
		table1.getHeadRow(0).getCell("price").setValue("价格");


		table1.getColumn("price").setWidth(200);


		table1.setEnabled(false);

		table1.addKDTMouseListener(new KDTMouseListener(){
			public void tableClicked(KDTMouseEvent paramKDTMouseEvent) {
				// TODO Auto-generated method stub
				int[] selectedRow = KDTableUtil.getSelectedRows(kdtOrdersTable);
				BigDecimal bigDecimal = UIRuleUtil.getBigDecimal(table1.getCell(KDTableUtil.getSelectedRow(table1).getRowIndex(), "price").getValue());
				int showConfirm2 = MsgBox.showConfirm2("是否将单价替换为"+bigDecimal.toString()+"?");
				if(showConfirm2 == MsgBox.OK){
					kdtOrdersTable.getCell(selectedRow[0], "price").setValue(bigDecimal);
					KDTEditEvent kdte = new KDTEditEvent(kdtOrdersTable, bigDecimal.ZERO, bigDecimal, selectedRow[0], kdtOrdersTable.getColumnIndex("price"), false, 1);  
					Object[] listeners = kdtOrdersTable.getListenerList().getListenerList();  
					for (int i = listeners.length - 2; i >= 0; i -= 2) {  
						if (listeners[i] == KDTEditListener.class) {  
							((KDTEditListener) listeners[(i + 1)]).editStopped(kdte);  
						}  
					} 
					fram.dispose();
				}
			}});
		final KDTable table = table1;

		fram.add(BorderLayout.NORTH,txtArea);
		fram.add(BorderLayout.CENTER,table);
		fram.setVisible(true);
		fram.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent paramFocusEvent) {
				// TODO Auto-generated method stub
				if(!table.requestFocusInWindow())
					fram.dispose();
			}});


		ArrayList<BigDecimal> priceList = new ArrayList<BigDecimal>();
		int[] selectedRow = KDTableUtil.getSelectedRows(kdtOrdersTable);
		if(selectedRow.length == 0){
			fram.dispose();
			commUtils.giveUserTipsAndRetire("请选择分录行");
		}
		Object materialInfo = kdtOrdersTable.getCell(selectedRow[0], "material").getValue();
		Object saleOrgUnitInfo = kdtOrdersTable.getCell(selectedRow[0], "company").getValue();
		Object saleOrder = kdtOrdersTable.getCell(selectedRow[0], "saleOrder").getValue();
		if(saleOrder != null){
			fram.dispose();
			commUtils.giveUserTipsAndRetire("已生成的订单请前往订单界面修改");
		}
		if(materialInfo== null || saleOrgUnitInfo == null){
			return;
		}
		//获取最新价格
		String sql = "select FPrice from T_SD_MaterialBasePrice where FMaterialID='"+((IPropertyContainer)materialInfo).getString("id")+"' and FCheckedStatus=2 and FAdminCUID='"+((IPropertyContainer)saleOrgUnitInfo).getString("id")+"'";
		IRowSet rs ;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if(rs.next()){
				priceList.add(rs.getBigDecimal("FPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sql = "select t2.FnewPrice,t2.FoldPrice,t1.FAuditTime from T_SD_BasePriceAdjust t1  inner join T_SD_BasePriceAdjustEntry t2 on t1.FID=t2.FParentID where t2.FMaterialID='"+((IPropertyContainer)materialInfo).getString("id")+"' and t1.FBaseStatus=4 and t1.FControlUnitID='"+((IPropertyContainer)saleOrgUnitInfo).getString("id")+"' order by FAuditTime desc";
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			while(rs.next()){
				if(priceList.size() ==3)
					break;
				if(priceList.contains(rs.getBigDecimal("FnewPrice"))){
					if(!priceList.contains(rs.getBigDecimal("FoldPrice"))){
						priceList.add(rs.getBigDecimal("FoldPrice"));
					}
					continue;
				}else{
					priceList.add(rs.getBigDecimal("FnewPrice"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<priceList.size();i++){
			IRow addRow = table.addRow();
			addRow.getCell("price").setValue(priceList.get(i));
		}

	}
}