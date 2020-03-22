/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTMergeManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.CellCheckBoxRenderer;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.SetValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.scm.common.client.SCMClientHelper;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.IToolFacade;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.UuidException;

/**
 * output class name
 */

/**
 * 
 ������
 create table CT_LHS_SALEFORECASTENTRY2 (
 FID varchar(44),
 FParentID varchar(44),
 fseq int default 0,
 Fentryid varchar(44),
 FCustomerID varchar(44), 
 FMaterialID varchar(44),
 FCompanyID varchar(44),
 FSaleOrderID varchar(44),
 funitid varchar(44), 
 FQty decimal(28,10) default 0,
 FPrice decimal(28,10) default 0,
 famount decimal(28,10) default 0, 
 FRemarks varchar(200),
 FStatus int default 0
 )
 */
public class ForcastToNOrdersUI extends AbstractForcastToNOrdersUI
{
	private static final Logger logger = CoreUIObject.getLogger(ForcastToNOrdersUI.class);
	public String entryid;
	public String customerid;
	public String materialid;
	public String unitid;
	public BigDecimal qtybc=BigDecimal.ZERO;
	public BigDecimal qty=BigDecimal.ZERO;
	public BigDecimal price=BigDecimal.ZERO;
	// ��ǰ�Ĳ�����֯
	protected CompanyOrgUnitInfo currOrgUnitInfo;
	// ��ǰ�����ڼ�
	protected PeriodInfo currPeriod;
	/**
	 * output class constructor
	 */
	public ForcastToNOrdersUI() throws Exception
	{
		super();
		Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension((int)(dd.getWidth()*0.8),(int)(dd.getHeight()*0.8)));
	}

	public void onLoad() throws Exception {
		super.onLoad();
		// ��ǰ��֯
		currOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
		currPeriod = SystemStatusCtrolUtils.getCurrentPeriod(null/* ��������Ϣ�����ڿͻ���ʹ�ÿ�Ϊnull */, SystemEnum.ACCOUNTSPAYABLE, currOrgUnitInfo/**/);
		String cuid;
		cuid = currOrgUnitInfo.getId().toString().trim();
		if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("��ǰ��˾Ϊ���壬������ʹ�øù��ܡ���ѡ��ʵ�幫˾��");
			SysUtil.abort();
		}
		this.chkisaudit.setSelected(true);
		btnViewInv.setVisible(false);
		btnReturn.setVisible(false);
//		btCloseForecast.setVisible(false);
		btnImport.setVisible(false);
		btClear.setVisible(false);
//		btReject.setVisible(false);
		//        if(!currOrgUnitInfo.getNumber().equals("70000")){
		//        	MsgBox.showInfo("���л�����ʳ��������");
		//	        SysUtil.abort();
		//        }
		//inittblOrders(this.kdtOrdersTable);
		inittblForecast(this.kdtForecastTable);
		initAction();
		inittblForecastData(this.kdtForecastTable,false);
		kdtForecastTable.checkParsed();
		kdtForecastTable.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		//		kdtForecastTable.getColumn("price").getStyleAttributes().setHided(false);
	}
	public void initAction() throws Exception{
		// F7��ʼ��
		//		this.kDComboBox1.setVisible(true);		
		//        this.kDComboBox1.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum").toArray());		
		//        this.kDComboBox1.setRequired(false);

		// prmtcustomer		
		this.prmtCustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
		this.prmtCustomer.setVisible(true);		
		this.prmtCustomer.setEditable(true);		
		this.prmtCustomer.setDisplayFormat("$name$");		
		this.prmtCustomer.setEditFormat("$number$");		
		this.prmtCustomer.setCommitFormat("$number$");		
		this.prmtCustomer.setRequired(false);
		//        //����Ա
		//		this.prmtSalePerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
		//		this.prmtSalePerson.setCommitFormat("$number$");		
		//		this.prmtSalePerson.setEditFormat("$number$");	
		//		this.prmtSalePerson.setDisplayFormat("$name$");	
		//		
		Set materialsID = new LinkedHashSet();
		StringBuffer sql=new StringBuffer();
		sql.append("select fnumber,cforgidid fid from T_LHS_SSorgList  ");
		sql.append(" where cfstatus=1 ");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
		}
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("saleOrg.id",materialsID,CompareType.INCLUDE));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);

		// ����Ա 
		this.prmtSalePerson.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7SalePersonQuery");		
		//this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
		this.prmtSalePerson.setCommitFormat("$person.number$");		
		this.prmtSalePerson.setEditFormat("$number$");		
		this.prmtSalePerson.setDisplayFormat("$name$");		
		this.prmtSalePerson.setEditable(true);		
		this.prmtSalePerson.setRequired(true);
		prmtSalePerson.setEntityViewInfo(evi);
		// ������֯

		this.prmtSaleGroup.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQuery");		
		this.prmtSaleGroup.setEditable(true);		
		this.prmtSaleGroup.setDisplayFormat("$name$");		
		this.prmtSaleGroup.setEditFormat("$number$");		
		this.prmtSaleGroup.setCommitFormat("$number$");		
		this.prmtSaleGroup.setVisible(true);		
		this.prmtSaleGroup.setEnabled(true);		
		this.prmtSaleGroup.setForeground(new java.awt.Color(0,0,0));		
		this.prmtSaleGroup.setRequired(false);
		prmtSaleGroup.setEntityViewInfo(evi);

		// ����ں�
		this.kdtForecastTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_ROW_MERGE);
		//this.kdtOrdersTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_ROW_MERGE);
		// �Զ�����
		//        this.kdtForecastTable.getStyleAttributes().setWrapText(true);
		//        this.kdtOrdersTable.getStyleAttributes().setWrapText(true);
		// ��������
		this.kdtForecastTable.getColumn("qty").getStyleAttributes().setNumberFormat("%r{#,##0.00}f");
		this.kdtForecastTable.getColumn("qtya").getStyleAttributes().setNumberFormat("%r{#,##0.00}f");
		this.kdtForecastTable.getColumn("qtyb").getStyleAttributes().setNumberFormat("%r{#,##0.00}f");
		this.kdtForecastTable.getColumn("companyqty").getStyleAttributes().setHided(true);
		this.kdtForecastTable.getColumn("company").getStyleAttributes().setHided(true);
		this.kdtForecastTable.getColumn("companyqty").getStyleAttributes().setNumberFormat("%r{#,##0.00}f");
		// �༭�¼�
		this.kdtForecastTable.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				try {
					if(e != null){
						forecastTableCellChanged(e);
					}
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
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
		this.btnViewInv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionViewInv_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});
		this.btnReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionReturn_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});
		this.btnImport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					actionImport_actionPerformed(e);
				} catch (Exception e1) {
					if(e1.getMessage()!=null){
						handUIException(e1);
					}
				}	
			}	
		});
		this.prmtSalePerson.addDataChangeListener( new DataChangeListener() {
			public void dataChanged(DataChangeEvent e){
				try{
					prmtSalePerson_dataChanged(e);
				}catch(Exception exc){
					handUIException(exc);
				}
			}
		});
	}

	protected void prmtSalePerson_dataChanged(DataChangeEvent e){
		if(!(prmtSalePerson.getData() instanceof SalePersonInfo))
			return;
		SalePersonInfo salePersonInfo = (SalePersonInfo)prmtSalePerson.getData();
		SCMClientHelper scmClientHelper = new SCMClientHelper(this);
		scmClientHelper.initSalePersonDisplay(prmtSalePerson);
		//IPerson iPerson = PersonFactory.getRemoteInstance();

		//PersonInfo aPersonInfo = (PersonInfo)prmtSalePerson.getData();
		//            SaleGroupInfo aSaleGroupInfo=null;
		//			if(salePersonInfo != null){
		//                aSaleGroupInfo = salePersonInfo.getSaleGroup();
		//	            if(aSaleGroupInfo != null){
		//	                aSaleGroupInfo = SaleGroupFactory.getRemoteInstance().getSaleGroupInfo(new ObjectUuidPK(aSaleGroupInfo.getId().toString()));
		//	                prmtsaleGroup.setValue(aSaleGroupInfo);
		//	            }
		//			}

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
	/**
	 * �򿪷������
	 * @param e
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws UuidException
	 * @throws SQLException
	 */
	protected void kdtForecastTable_Changed(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws EASBizException, BOSException, UuidException, SQLException {
		if (e.getClickCount() == 2) {
			int rowIndex = e.getRowIndex();
			String id = (String)kdtForecastTable.getRow(rowIndex).getCell("id").getValue();
			if(id != null){
				String uiname = "com.kingdee.eas.custom.lhsm.client.ToSaleOrderUI";
				UIContext uiContext = new UIContext(this);
				uiContext.put("FID", id);
				IUIWindow uiWindow = null;
				uiWindow = UIFactory.createUIFactory(UIFactoryName.NEWTAB).create(uiname, uiContext, null, OprtState.VIEW);
				uiWindow.show();
			}
		}  
	}
	/**
	 * 
	 * <p>Title: forecastTableCellChanged</p>
	 * <p>Description: </p>
	 * ����仯�¼�
	 * @param e
	 */
	private void forecastTableCellChanged(KDTEditEvent e){
		int rowIndex = e.getRowIndex();
		int colIndex = e.getColIndex();

		String fieldName = kdtForecastTable.getColumnKey(colIndex);
		//		if(fieldName.equals("qty")||fieldName.equals("price")){
		//			kdtForecastTable.getCell(e.getRowIndex(), "amount").setValue(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "price").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtForecastTable.getCell(e.getRowIndex(), "qty").getValue())).setScale(2,RoundingMode.HALF_UP));
		//		}


		if("companyqty".equalsIgnoreCase(fieldName)){
			try{
				BigDecimal companyqty = BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "companyqty").getValue() != null){
					companyqty = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "companyqty").getValue().toString());
				}
				//����
				BigDecimal qty = BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qty").getValue() != null){
					qty = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qty").getValue().toString());
				}

				//�ɷ�������
				BigDecimal  qtya= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qtya").getValue() != null){
					qtya = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qtya").getValue().toString());
				}

				//�ɷ�������
				BigDecimal  qtyb= BigDecimal.ZERO;
				if(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue() != null){
					qtyb = new BigDecimal(this.kdtForecastTable.getCell(rowIndex, "qtyb").getValue().toString());
				}

				if(companyqty.compareTo(BigDecimal.ZERO) < 0){
					MsgBox.showInfo("�����������0.");
					//					this.kdtForecastTable.getCell(preRowIndex, preColIndex).setValue(null);
					this.kdtForecastTable.getSelectManager().select(rowIndex,colIndex);
					SysUtil.abort();
				}
				if(companyqty.compareTo(qtyb) > 0){
					MsgBox.showInfo("�������ܴ��ڿɷ�����.");
					//					this.kdtForecastTable.getCell(preRowIndex, preColIndex).setValue(null);
					this.kdtForecastTable.getSelectManager().select(rowIndex,colIndex);
					SysUtil.abort();

				}
				// ���¿ɷ����������ѷ�������
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
	 * <p>Description:  ��ѯ��ת��Ԥ����</p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */

	protected void btQuery_actionPerformed(ActionEvent e) throws Exception {
		inittblForecastData(this.kdtForecastTable,true);
	}
	public void inittblOrders(KDTable kdTable){
		kdTable.checkParsed();


		// �������ɱ༭
		kdTable.setEditable(true);
		// ѡ��ģʽΪ ��ѡ�� 
		kdTable.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		// ����  �ͻ�
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

		final KDBizPromptBox prmtCompanyInv = new KDBizPromptBox();
		prmtCompanyInv.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7CompanyInvQuery");		
		prmtCompanyInv.setVisible(true);		
		prmtCompanyInv.setEditable(true);		
		prmtCompanyInv.setDisplayFormat("$company.number$");		
		prmtCompanyInv.setEditFormat("$company.number$");		
		prmtCompanyInv.setCommitFormat("$company.number$");		
		prmtCompanyInv.setRequired(false);

		KDTDefaultCellEditor prmtCompanyInvCellEditor = new KDTDefaultCellEditor(prmtCompanyInv);
		kdTable.getColumn("companyInv").setEditor(prmtCompanyInvCellEditor);
		ObjectValueRender prmtCompanyInvOVR = new ObjectValueRender();
		prmtCompanyInvOVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("companyInv").setRenderer(prmtCompanyInvOVR);

		// ����  ������֯
		final KDBizPromptBox kdtEntrys_deliveryOrg_PromptBox = new KDBizPromptBox();
		kdtEntrys_deliveryOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyQuery");		
		kdtEntrys_deliveryOrg_PromptBox.setVisible(true);		
		kdtEntrys_deliveryOrg_PromptBox.setEditable(true);		
		kdtEntrys_deliveryOrg_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setEditFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_deliveryOrg_PromptBox.setRequired(false);

		KDTDefaultCellEditor kdtEntrys_deliveryOrg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_deliveryOrg_PromptBox);
		kdTable.getColumn("company").setEditor(kdtEntrys_deliveryOrg_CellEditor);
		ObjectValueRender kdtEntrys_deliveryOrg_OVR = new ObjectValueRender();
		kdtEntrys_deliveryOrg_OVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("company").setRenderer(kdtEntrys_deliveryOrg_OVR);
		// ���� ����
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

		// ���� ��λ
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

		KDFormattedTextField kdtForecastTable_price_TextField = new KDFormattedTextField();
		kdtForecastTable_price_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_price_TextField.setVisible(true);
		kdtForecastTable_price_TextField.setEditable(true);
		kdtForecastTable_price_TextField.setHorizontalAlignment(2);
		kdtForecastTable_price_TextField.setDataType(1);
		kdtForecastTable_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_price_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_price_TextField);
		kdTable.getColumn("price").setEditor(kdtEntrys_price_CellEditor);


		KDFormattedTextField kdtForecastTable_deliveryAccount_TextField = new KDFormattedTextField();
		kdtForecastTable_deliveryAccount_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_deliveryAccount_TextField.setVisible(true);
		kdtForecastTable_deliveryAccount_TextField.setEditable(true);
		kdtForecastTable_deliveryAccount_TextField.setHorizontalAlignment(2);
		kdtForecastTable_deliveryAccount_TextField.setDataType(1);
		kdtForecastTable_deliveryAccount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_measureUnitAccount_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_deliveryAccount_TextField);
		kdTable.getColumn("qty").setEditor(kdtEntrys_measureUnitAccount_CellEditor);
	}

	public void inittblForecast(KDTable kdTable){
		this.kdtForecastTable.checkParsed();
		// ���÷�����֯�༭��ʽ
		final KDBizPromptBox kdtEntrys_senderCompany_PromptBox = new KDBizPromptBox();
		kdtEntrys_senderCompany_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
		kdtEntrys_senderCompany_PromptBox.setVisible(true);		
		kdtEntrys_senderCompany_PromptBox.setEditable(true);		
		kdtEntrys_senderCompany_PromptBox.setDisplayFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setEditFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setCommitFormat("$number$");		
		kdtEntrys_senderCompany_PromptBox.setRequired(false);

		KDTDefaultCellEditor kdtEntrys_materialNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_senderCompany_PromptBox);
		this.kdtForecastTable.getColumn("company").setEditor(kdtEntrys_materialNumber_CellEditor);
		ObjectValueRender kdtEntrys_materialNumber_OVR = new ObjectValueRender();
		kdtEntrys_materialNumber_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtForecastTable.getColumn("company").setRenderer(kdtEntrys_materialNumber_OVR);
		// �����༭
		KDFormattedTextField kdtForecastTable_deliveryAccount_TextField = new KDFormattedTextField();
		kdtForecastTable_deliveryAccount_TextField.setName("kdtEntrys_measureUnitAccount_TextField");
		kdtForecastTable_deliveryAccount_TextField.setVisible(true);
		kdtForecastTable_deliveryAccount_TextField.setEditable(true);
		kdtForecastTable_deliveryAccount_TextField.setHorizontalAlignment(2);
		kdtForecastTable_deliveryAccount_TextField.setDataType(1);
		kdtForecastTable_deliveryAccount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtForecastTable_deliveryAccount_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_measureUnitAccount_CellEditor = new KDTDefaultCellEditor(kdtForecastTable_deliveryAccount_TextField);
		this.kdtForecastTable.getColumn("qty").setEditor(kdtEntrys_measureUnitAccount_CellEditor);
	}
	public void inittblForecastData(KDTable kdTable,boolean isdate) throws EASBizException, BOSException, SQLException{
		// ���������Ŀ
		kdTable.removeRows();

		StringBuilder sql =  new StringBuilder();
		sql.append(" select   ");
		sql.append(" t.fid,to_char(t.fbizdate,'yyyy-MM-dd') fdate,t.fnumber, ");
		sql.append(" t.CFCUSTOMERID,t.cfsalepersonid,t.CFSTATE,t.CFLINKMAN,");
		sql.append(" t.CFLINKMANTEL,t.CFWAYOFTAKINGDELIVERY,t.FDESCRIPTION,t4.fname_l2 fcreatorname,");
		sql.append(" isnull(t5.fname_l2,'') fcompanyname,");
		sql.append(" sum(isnull(t2.cfbaseqty,0)) fbaseqty,sum(isnull(t2.cfamount,0)) famount,");
		sql.append(" sum(isnull(t2.cfqtya,0)) fqtya,sum(isnull(t2.cfqtyb,0)) fqtyb ");
		sql.append(" from CT_LHS_SALEFORECAST t");
		sql.append(" inner join ct_lhs_saleForecastentry t2 on t2.fparentid=t.fid ");
		sql.append(" inner join t_bd_material t3 on t3.fid=t2.CFMaterialNumberID ");
		sql.append(" inner join t_pm_user t4 on t4.fid=t.fcreatorid ");
		sql.append(" left join t_org_company t5 on t5.fid=t2.CFCompanyID ");
		if(isdate==true){
			sql.append(" where   1=1 ");
			if(this.dpBeginDate.getValue()!= null ){
				sql.append("  and  t.fBizDATE >={ts '");
				sql.append(this.dpBeginDate.getText());
				sql.append("'} ");
			}
			if(this.dpEndDate.getValue()!= null ){
				String enddate=this.dpEndDate.getText();
				enddate=enddate+" 23:59:59";
				sql.append(" and t.fBizDATE <={ts '");
				sql.append(enddate);
				sql.append("'} ");
			}
			sql.append(" and ( t.CFSTATE=7 ");
		}else{
			sql.append(" where ( t.CFSTATE=7 ");
		}
		if(this.chkisaudit.isSelected() == true){
			sql.append(" or t.CFSTATE=3");//���(δ�������)
		}
		if(this.chkisClose.isSelected()==true){
			sql.append(" or t.CFSTATE=4");//�ر�
		}
		if(this.chkischange.isSelected()==true){
			sql.append("  or t.CFSTATE=5  ");//�������
		}
		if(this.chkisError.isSelected()==true){
			sql.append(" or t.CFSTATE=-1 ");//����
		}

		sql.append(" ) ");
		if(this.prmtCustomer.getValue() != null ){
			sql.append(" and t.CFCUSTOMERID ='");
			sql.append(((CustomerInfo)this.prmtCustomer.getValue()).getId().toString());
			sql.append("' ");
		}
		sql.append(" group by  ");
		sql.append(" t.fid,t.fnumber,to_char(t.fbizdate,'yyyy-MM-dd'),t.CFCUSTOMERID, ");
		sql.append(" t.cfsalepersonid,t.CFSTATE,t.CFLINKMAN,t4.fname_l2 ,");
		sql.append(" t.CFLINKMANTEL,t.CFWAYOFTAKINGDELIVERY,t.FDESCRIPTION,isnull(t5.fname_l2,'') ");
		sql.append(" order by t.fnumber ");

		ICell cell;
		IRow row;
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if(rs != null && rs.size() > 0){
			BigDecimal baseqtyt=BigDecimal.ZERO;
			BigDecimal qtyat=BigDecimal.ZERO;
			BigDecimal qtybt=BigDecimal.ZERO;
			BigDecimal amountt=BigDecimal.ZERO;
			int m= 0;
			while(rs.next()){
				row = kdTable.addRow(m);

				cell = row.getCell("number");
				cell.setValue(rs.getString("fnumber"));//id

				cell = row.getCell("date");
				cell.setValue(rs.getString("fdate"));//id

				//					cell = row.getCell("entryID");
				//					cell.setValue(rs.getString("fentryID"));

				cell = row.getCell("id");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("FID"));

				String state=rs.getString("CFSTATE");
				if(state.equals("1")){
					state="����";
				}else if(state.equals("2")){
					state="�ύ";
				}else if(state.equals("3")){
					state="���";
				}else if(state.equals("4")){
					state="�ر�";
				}else if(state.equals("5")){
					state="�ѷ���";
				}else if(state.equals("-1")){
					state="����";
				}
				cell = row.getCell("status");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(state);

				cell = row.getCell("customer");
				cell.getStyleAttributes().setLocked(true);
				if(rs.getString("CFCUSTOMERID") != null){
					CustomerInfo customerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(rs.getString("CFCUSTOMERID")));
					cell.setValue(customerInfo.getName());
					row.getCell("customerID").setValue(customerInfo.getId().toString());
				}

				cell = row.getCell("linkman");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("CFLINKMAN"));

				cell= row.getCell("tel");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("CFLINKMANTEL"));


				cell = row.getCell("carryWay");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("CFWAYOFTAKINGDELIVERY") == "0" ? "��ȡ" :"�ͻ�" );


				cell = row.getCell("creator");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("fcreatorname"));


				cell = row.getCell("salePerson");
				cell.getStyleAttributes().setLocked(true);
				if(rs.getString("CFSALEPERSONID") != null){
					PersonInfo salePerson = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("CFSALEPERSONID")));
					cell.setValue(salePerson.getName());
				}

				cell = row.getCell("abtract");
				cell.getStyleAttributes().setHided(false);
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("FDESCRIPTION"));

				cell= row.getCell("companyname");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("fcompanyname"));

				//  ������
				BigDecimal baseqty = BigDecimal.ZERO;
				baseqty=rs.getBigDecimal("fbaseqty");
				baseqtyt=baseqtyt.add(baseqty);
				cell = row.getCell("qty");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("fbaseqty"));

				//					cell = row.getCell("price");
				//					cell.setValue(rs.getString("fprice"));//id

				BigDecimal amount = BigDecimal.ZERO;
				amount=rs.getBigDecimal("famount");
				amountt=amountt.add(amount);
				cell = row.getCell("amount");
				cell.setValue(rs.getString("famount"));//id

				// �ѷ�������
				BigDecimal qtya = BigDecimal.ZERO;
				qtya=rs.getBigDecimal("fqtya");
				qtyat=qtyat.add(qtya);
				cell = row.getCell("qtya");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("fqtya"));


				//				row.getCell("price").setValue(rs.getString("fprice"));;
				//				if(UIRuleUtil.getBigDecimal(qtya).compareTo(BigDecimal.ZERO) == 0){
				//					row.getCell("qty").getStyleAttributes().setLocked(false);
				//					row.getCell("price").getStyleAttributes().setLocked(false);
				//				}

				// ��������
				BigDecimal qtyb = BigDecimal.ZERO;
				qtyb=rs.getBigDecimal("fqtyb");
				qtybt=qtybt.add(qtyb);
				cell= row.getCell("qtyb");
				cell.getStyleAttributes().setLocked(true);
				cell.setValue(rs.getString("fqtyb"));

				m=m+1;
			}
			row = kdTable.addRow(m);
			cell = row.getCell("qty");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(baseqtyt);

			cell = row.getCell("amount");
			cell.setValue(amountt);//id

			// �ѷ�������
			cell = row.getCell("qtya");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(qtyat);

			// ��������
			cell= row.getCell("qtyb");
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(qtybt);
			java.awt.Color rowColor=new Color(255,128,0);
			kdTable.getRow(m).getStyleAttributes().setBackground(rowColor);
			this.kdtForecastTable.getMergeManager().setMergeMode(KDTMergeManager.FREE_MERGE);
		}else{
			//MsgBox.showInfo("û�ҵ���������������Ԥ���� ��");
		}
	}
	public void initTableDataOrders(KDTable kdTable,String entryid,boolean isall) throws BOSException, EASBizException, UuidException, SQLException
	{
		kdTable.removeRows();

		IRow row;
		ICell cell;
		ObjectUuidPK pk=null;
		StringBuffer sql =new StringBuffer();

		final KDBizPromptBox prmtCompanyInv = new KDBizPromptBox();
		prmtCompanyInv.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7CompanyInvQuery");		
		prmtCompanyInv.setVisible(true);		
		prmtCompanyInv.setEditable(true);		
		prmtCompanyInv.setDisplayFormat("$company.number$");		
		prmtCompanyInv.setEditFormat("$company.number$");		
		prmtCompanyInv.setCommitFormat("$company.number$");		
		prmtCompanyInv.setRequired(false);
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("material.id",materialid,CompareType.EQUALS));
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);
		prmtCompanyInv.setEntityViewInfo(evi);
		KDTDefaultCellEditor prmtCompanyInvCellEditor = new KDTDefaultCellEditor(prmtCompanyInv);
		kdTable.getColumn("companyInv").setEditor(prmtCompanyInvCellEditor);
		ObjectValueRender prmtCompanyInvOVR = new ObjectValueRender();
		prmtCompanyInvOVR.setFormat(new BizDataFormat("$name$"));
		kdTable.getColumn("companyInv").setRenderer(prmtCompanyInvOVR);

		KDCheckBox kdtEntrys_Status_CheckBox = new KDCheckBox();
		kdtEntrys_Status_CheckBox.setName("kdtEntrys_Status_CheckBox");
		kdtEntrys_Status_CheckBox.setSelected(false);
		KDTDefaultCellEditor kdtEntrys_Status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Status_CheckBox);
		kdTable.getColumn("status").setRenderer(new CellCheckBoxRenderer());

		sql =new StringBuffer();
		sql.append(" Select t1.*,isnull(t2.fnumber,'') fsalenumber ");
		sql.append(" from CT_LHS_SALEFORECASTENTRY2 t1 ");
		sql.append(" left join t_sd_saleorder t2 on t2.fid=t1.fsaleorderid ");
		sql.append(" where t1.fentryid='"+entryid+"'");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		int m= 0;
		while(rs.next()){
			row = kdTable.addRow(m);

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
			cell.setValue(cinfo);//id


			pk = new ObjectUuidPK(rs.getString("fcompanyid"));
			CompanyOrgUnitInfo coinfo=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("company"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(coinfo);//id

			pk = new ObjectUuidPK(rs.getString("funitid"));
			MeasureUnitInfo unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(pk);
			cell = row.getCell(kdTable.getColumnIndex("unit"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(unit);//id

			cell = row.getCell(kdTable.getColumnIndex("qty"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getString("fqty"));//id

			cell = row.getCell(kdTable.getColumnIndex("price"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getString("fprice"));//id

			cell = row.getCell(kdTable.getColumnIndex("amount"));
			cell.getStyleAttributes().setLocked(true);
			cell.setValue(rs.getString("famount"));//id

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

	public void actionImport_actionPerformed(ActionEvent e) throws Exception {
		ForecastOrderFacadeFactory.getRemoteInstance().addSaleForecast();
		MsgBox.showInfo("������ɣ�"); 
		inittblForecastData(this.kdtForecastTable,false);
	}
	public void actionViewInv_actionPerformed(ActionEvent e) throws Exception {
		//		StringBuffer sql=new StringBuffer();
		//		PurContractJFacadeFactory.getRemoteInstance().companyInv(currOrgUnitInfo.getId().toString());
		String uiname="";
		uiname="com.kingdee.eas.custom.lhsm.client.CompanyInvRptUI";
		UIContext uiContext = new UIContext(this);
		//uiContext.put("ID", id);
		//selectKeyValue = getSelectedKeyValue(this.tblStockReq);
		//prepareUIContext(uiContext, e);
		IUIWindow uiWindow = null;
		if(SwingUtilities.getWindowAncestor(this) != null && (SwingUtilities.getWindowAncestor(this) instanceof JDialog)){
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(uiname, uiContext, null, OprtState.VIEW);
			uiWindow.show();
		}else{
			uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(uiname, uiContext, null, OprtState.VIEW);
			uiWindow.show();
		}
	}
	/**
	 * ��հ�ť�¼�
	 * <p>Title: btClear_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 */
	protected void btClear_actionPerformed(java.awt.event.ActionEvent e){

		// ��ղ�ѯ����
		this.prmtCustomer.setValue(null);
		this.dpBeginDate.setValue(new Date());
		this.dpEndDate.setValue(new Date());
		//this.comboWayOfTakingDelivery.setSelectedItem(WayOfTakingDeliveryEnum.CARRY);
		this.prmtSaleGroup.setValue(null);

	}

	/**
	 * ת���ɶ���
	 * <p>Title: btAddOrder_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */

	/**
	 * ת��ǰУ��Ԥ�����༭״̬
	 * <p>Title: checkForecastTableState</p>
	 * <p>Description: </p>
	 *
	 */
	private void checkForecastTableState(){

		for(int i = 0; i < this.kdtForecastTable.getRowCount(); i++){

			ICell deliveryAccountCell = this.kdtForecastTable.getCell(i, "deliveryAccount");
			// �����������ķ�¼���ɶ���
			if(deliveryAccountCell !=null && deliveryAccountCell.getValue() != null && (new BigDecimal(deliveryAccountCell.getValue().toString()).compareTo(BigDecimal.ZERO) > 0)){
				if(this.kdtForecastTable.getCell(i, "deliveryOrg") == null){
					MsgBox.showInfo("��" + (i + 1) + "��Ԥ����δѡ�񷢻���֯��");
					SysUtil.abort();
				}
			}
			// �����������ķ�¼���ɶ���
			if(this.kdtForecastTable.getCell(i, "deliveryOrg") != null && this.kdtForecastTable.getCell(i, "deliveryOrg").getValue() != null){
				if(deliveryAccountCell ==null || deliveryAccountCell.getValue() == null || (new BigDecimal(deliveryAccountCell.getValue().toString()).compareTo(BigDecimal.ZERO) <= 0)){

					MsgBox.showInfo("��" + (i + 1) + "��Ԥ����δ����������");
					SysUtil.abort();
				}
			}
		}
	}

	/**
	 * ��������
	 * <p>Title: btSaveOrders_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btSaveOrders_actionPerformed(ActionEvent e) throws Exception {
		//PurContractJFacadeFactory.getRemoteInstance().saleorder();
		//MsgBox.showInfo("���۶����Ѿ�����");
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
		return tblMain.getRow(selectIndex).getCell(0).getValue().toString();
	}

	/**
	 * ���ز���
	 * <p>Title: btReject_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */
	protected void actionReturn_actionPerformed(ActionEvent e) throws Exception {
		checkSelected(this.kdtForecastTable);
		int selectRows[] = KDTableUtil.getSelectedRows(kdtForecastTable);
		int selectIndex = -1;
		if(selectRows.length > 0)
			selectIndex = selectRows[0];
		if(selectIndex == kdtForecastTable.getRowCount()-1){
			MsgBox.showInfo("��ѡ���¼�У�");
			return;
		}
		String id=kdtForecastTable.getRow(selectIndex).getCell("id").getValue().toString();

		IToolFacade is = ToolFacadeFactory.getRemoteInstance();
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECASTENTRY  set cfqtya=0 ");
		sql.append(" where fparentid='"+id+"' ");
		is.execute(sql.toString());

		sql=new StringBuffer();
		sql.append(" /*dialect*/update CT_LHS_SALEFORECASTENTRY t1 set t1.cfqtya=(");
		sql.append(" select t2.fqty from (");
		sql.append(" select sum(fqty) fqty ,fentryid from CT_LHS_SALEFORECASTENTRY2 group by fentryid ");
		sql.append(" ) t2 where t2.fentryid=t1.fid ");
		sql.append(" ) ");
		sql.append(" where t1.fparentid='"+id+"' ");
		is.execute(sql.toString());

		sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECASTENTRY set cfqtyb=cfbaseqty-isnull(cfqtya,0) ");
		sql.append(" where fparentid='"+id+"' ");
		is.execute(sql.toString());

		sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set cfstate=5 ");//�������
		sql.append(" where fid='"+id+"' ");
		sql.append(" and fid not in(");
		sql.append(" select fparentid from  CT_LHS_SALEFORECASTENTRY  ");
		sql.append(" where cfqtyb>0  and fparentid='"+id+"'  ) ");
		is.execute(sql.toString());


		sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set cfstate=3 ");//���
		sql.append(" where fid='"+id+"' ");
		sql.append(" and fid in(");
		sql.append(" select fparentid from  CT_LHS_SALEFORECASTENTRY  ");
		sql.append(" where cfqtyb>0  and fparentid='"+id+"'  ) ");
		is.execute(sql.toString());

		inittblForecastData(this.kdtForecastTable,true);
		MsgBox.showInfo("�������");
	}
	/**
	 * ���ز���
	 * <p>Title: btReject_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btReject_actionPerformed(ActionEvent e) throws Exception {
		checkSelected(this.kdtForecastTable);
		int selectRows[] = KDTableUtil.getSelectedRows(kdtForecastTable);
		int selectIndex = -1;
		if(selectRows.length > 0)
			selectIndex = selectRows[0];
		String id=kdtForecastTable.getRow(selectIndex).getCell("id").getValue().toString();
		String billStatus=kdtForecastTable.getRow(selectIndex).getCell("status").getValue().toString();
		String qtya=kdtForecastTable.getRow(selectIndex).getCell("qtya").getValue().toString();
		String qtyb=kdtForecastTable.getRow(selectIndex).getCell("qtyb").getValue().toString();
		if(!billStatus.equals("���")){
			MsgBox.showInfo("�ѷ��䡢���ء��ر�״̬�ĵ��ݣ����ܲ��أ�");
			SysUtil.abort();
		}
		if(MsgBox.showConfirm2("ȷ�ϲ��ص�ǰѡ�е�����Ԥ������") != MsgBox.YES){
			SysUtil.abort();
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set CFSTATE=-1 ");
		sql.append(" where fid='"+id+"' ");
		ToolFacadeFactory.getRemoteInstance().execute(sql.toString());

		ForecastOrderFacadeFactory.getRemoteInstance().updateSaleForecast(id);

		inittblForecastData(this.kdtForecastTable,true);
		MsgBox.showInfo("�������");
	}
	/**
	 * �ֶ��ر�Ԥ����
	 * <p>Title: btCloseForecast_actionPerformed</p> 
	 * <p>Description: </p>
	 * <p>�̳з���</p>
	 * @param e
	 * @throws Exception
	 */
	protected void btCloseForecast_actionPerformed(ActionEvent e)throws Exception {
		checkSelected(this.kdtForecastTable);
		int selectRows[] = KDTableUtil.getSelectedRows(kdtForecastTable);
		int selectIndex = -1;
		if(selectRows.length > 0)
			selectIndex = selectRows[0];
		String id=kdtForecastTable.getRow(selectIndex).getCell("id").getValue().toString();
		String billStatus=kdtForecastTable.getRow(selectIndex).getCell("status").getValue().toString();
		if(!billStatus.equals("���")){
			MsgBox.showInfo("�ѷ��䡢���ء��ر�״̬�ĵ��ݣ����ܹرգ�");
			SysUtil.abort();
		}
		if(MsgBox.showConfirm2("ȷ�Ϲرյ�ǰѡ�е�����Ԥ������") != MsgBox.YES){
			SysUtil.abort();
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_LHS_SALEFORECAST set CFSTATE=4 ");
		sql.append(" where fid='"+id+"' ");
		ToolFacadeFactory.getRemoteInstance().execute(sql.toString());

		ForecastOrderFacadeFactory.getRemoteInstance().updateSaleForecast(id);

		inittblForecastData(this.kdtForecastTable,true);
		MsgBox.showInfo("�ر����");
	}

	/**
	 * 	* <p>Title: getMaterialInventory</p>
	 * <p>Description: </p>
	 * 
	 * @param ctx
	 * @param aCompanyOrgUnitInfo
	 * @param materialInfo
	 * @return
	 * @throws Exception
	 */
	private WarehouseInfo getMaterialInventory(CompanyOrgUnitInfo aCompanyOrgUnitInfo, MaterialInfo materialInfo)
	throws Exception {
		WarehouseInfo warehouserInfo = null;
		if (aCompanyOrgUnitInfo != null && materialInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemMaterialInfo = new FilterItemInfo("material", materialInfo.getId().toString(),CompareType.EQUALS);
			FilterItemInfo filterItemOrgInfo = new FilterItemInfo("CU",aCompanyOrgUnitInfo.getId().toString(), CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemMaterialInfo);
			filterInfo.getFilterItems().add(filterItemOrgInfo);
			filterInfo.setMaskString("#0 and #1");
			viewInfo.setFilter(filterInfo);
			IMaterialInventory iMaterialInventory = MaterialInventoryFactory.getRemoteInstance();
			MaterialInventoryCollection materialCostCollection = iMaterialInventory.getMaterialInventoryCollection(viewInfo);
			if (materialCostCollection != null&& materialCostCollection.size() > 0){
				return materialCostCollection.get(0).getDefaultWarehouse();
			}else{
				return warehouserInfo;
			}	
		} else {
			return warehouserInfo;
		}
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
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

	protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
	{
		com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer oufip=(com.kingdee.bos.ctrl.extendcontrols.ext.OrgUnitFilterInfoProducer)com.kingdee.bos.ctrl.extendcontrols.ext.FilterInfoProducerFactory.getOrgUnitFilterInfoProducer(orgType);
		oufip.getModel().setIsCUFilter(true);
		f7.setFilterInfoProducer(oufip);
	}

}