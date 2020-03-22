/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.ctrl.swing.tree.KingdeeTreeModel;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.DataType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyCollection;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.farm.stocking.basedata.AwardsCalType;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class RewardsPolicyEditUI extends AbstractRewardsPolicyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(RewardsPolicyEditUI.class);
    
    /**
     * output class constructor
     */
    public RewardsPolicyEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    @Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.RewardsPolicyFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.RewardsPolicyTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBeginDate(new java.util.Date());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.pkbeginDate.setDatePattern("yyyy-MM-dd");
		this.pkendDate.setDatePattern("yyyy-MM-dd");
		
		BaseSysSettingInfo sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		
		this.calType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColProp();
			}}
		);
		
		this.kdtPolicyEntry.checkParsed();
		setColProp();
		initDynamicCalculatio();
		
	}
	/**
	 * 初始化动态计算
	 */
	private void initDynamicCalculatio() {
		try {
			this.kDTable1.checkParsed();
			this.kDTable1.getStyleAttributes().setLocked(true);
			IRow row;
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffResult");
			row.getCell("name").setValue("公式结果");
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffIf");
			row.getCell("name").setValue("如果");
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffElse");
			row.getCell("name").setValue("否则");
			
			//初始化树
			DefaultKingdeeTreeNode rootNode=new DefaultKingdeeTreeNode("单据");
			TreeModel newModel=new KingdeeTreeModel(rootNode);
			kDTree1.setModel(newModel);
			kDTree1.setShowsRootHandles(true);
			
			EntityObjectInfo eo = StockingComm.getEntityObject(null, "B1E872B9");
			DefaultKingdeeTreeNode lvl1Node=new DefaultKingdeeTreeNode("结算指标");
			lvl1Node.setUserObject(eo);
			rootNode.add(lvl1Node);
			insertIntoTree(eo, lvl1Node);
			
			eo =StockingComm.getEntityObject(null, "18D671B0");
			lvl1Node=new DefaultKingdeeTreeNode("结算单");
			lvl1Node.setUserObject(eo);
			rootNode.add(lvl1Node);
			insertIntoTree(eo, lvl1Node);
			
			kDTree1.expandOnLevel(2);
			
			kDTree1.addTreeSelectionListener(new TreeSelectionListener(){
				public void valueChanged(TreeSelectionEvent e) {
//					treeSelectd_changed(e);
				}});
			kDTree1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					tree_clicked(e);
				}});
			this.kDTable1.addKDTMouseListener(new KDTMouseListener(){
				public void tableClicked(KDTMouseEvent e) {
					table_clicked(e);
				}});
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 插入单据属性节点
	 * @param eo
	 * @param rootNode
	 */
	private void insertIntoTree(EntityObjectInfo eo,DefaultKingdeeTreeNode rootNode) {
		if(eo!=null) {
			DataType dataType;
			PropertyCollection pcols = eo.getProperties();
			DefaultKingdeeTreeNode tempRoot;
			for(int index=0;index<pcols.size();index++) {
				tempRoot=new DefaultKingdeeTreeNode(pcols.get(index));
				if(!(pcols.get(index) instanceof OwnPropertyInfo)) {
					continue;
				}
				dataType=((OwnPropertyInfo)pcols.get(index)).getDataType();
				if(!dataType.equals(DataType.DECIMAL)&&!dataType.equals(DataType.FLOAT)&&!dataType.equals(DataType.DOUBLE)&&!dataType.equals(DataType.INTEGER)&&!dataType.equals(DataType.LONG)&&!dataType.equals(DataType.SHORT)) {
					continue;
				}
				tempRoot.setText(pcols.get(index).getAlias());
				System.out.println(pcols.get(index).getClass().toString());
				kDTree1.addNodeInto(tempRoot,rootNode);
			}
		}
	}
	
	private void tree_clicked(MouseEvent e) {
		if(!oprtState.equals(OprtState.ADDNEW)&&!oprtState.equals(OprtState.EDIT)) {
			return;
		}
		if(e.getClickCount()==2) {
			Object[] path = kDTree1.getSelectionPath().getPath();
			DefaultKingdeeTreeNode node=(DefaultKingdeeTreeNode)path[path.length-1];
			DefaultKingdeeTreeNode rootNode=(DefaultKingdeeTreeNode)path[1];
			if(!(node.getUserObject() instanceof PropertyInfo)) {
				return;
			}
			int beginIndex = this.txtformulaTxt.getSelectionStart();
			this.txtformulaTxt.insert(" ["+rootNode.getText()+"."+((PropertyInfo) node.getUserObject()).getAlias()+"\""+((EntityObjectInfo)rootNode.getUserObject()).getName()+"."+((PropertyInfo) node.getUserObject()).getName()+"\"]",beginIndex);
		}
	}
	private void table_clicked(KDTMouseEvent e) {
		if(!oprtState.equals(OprtState.ADDNEW)&&!oprtState.equals(OprtState.EDIT)) {
			return;
		}
		if(e.getClickCount()!=2) {
			return;
		}
		IRow row = KDTableUtil.getSelectedRow(kDTable1);
		if(row==null||row.getRowIndex()<0) {
			return;
		}
		int beginIndex = this.txtformulaTxt.getSelectionStart();
		if(row.getCell("name").getValue().toString().equals("公式结果")) {
//			this.txtformulaTxt.setText("[公式结果{result}] ="+(this.txtformulaTxt.getText()==null?"":this.txtformulaTxt.getText()));
			this.txtformulaTxt.insert("[公式结果\"result\"] = ",beginIndex);
		}
		if(row.getCell("name").getValue().toString().equals("如果")) {
			this.txtformulaTxt.insert("[如果\"if\"](1==1) {\n    \n}",beginIndex);
		}
		if(row.getCell("name").getValue().toString().equals("否则")) {
			this.txtformulaTxt.insert("\n[否则\"else\"] {\n    \n}",beginIndex);
		}
	}
	/**
	 * 节点选择改变事件 
	 * @param e
	 */
	private void treeSelectd_changed(TreeSelectionEvent e) {
		if(e.getNewLeadSelectionPath()==null)
			return;
		Object[] pd = e.getNewLeadSelectionPath().getPath();
		DefaultKingdeeTreeNode node=(DefaultKingdeeTreeNode) pd[pd.length-1];
		if(!(node.getUserObject() instanceof PropertyInfo)) {
			return;
		}
		this.txtformulaTxt.append(" ["+((PropertyInfo) node.getUserObject()).getAlias()+"]");
	}
	
	
	/**
	 * 设置列的属性
	 */
	private void setColProp() {
		//比例
		if(calType.getSelectedItem()==null) {
			return;
		}
		if (calType.getSelectedItem().equals(AwardsCalType.proMorL)) {//比例增减
			this.kdtPolicyEntry.getHeadRow(0).getCell("diffCoeff").setValue("变动系数(%)");
			this.kdtPolicyEntry.getHeadRow(0).getCell("diff").setValue("增减比例(%)");
			
			this.kdtPolicyEntry.getColumn("floor").getStyleAttributes().setHided(true);
			this.kdtPolicyEntry.getColumn("upper").getStyleAttributes().setHided(true);
			this.kdtPolicyEntry.getColumn("diffCoeff").getStyleAttributes().setHided(false);
			this.kdtPolicyEntry.getColumn("diff").getStyleAttributes().setHided(false);
			this.kdtPolicyEntry.getColumn("calValue").getStyleAttributes().setHided(true);
		}
		else if (calType.getSelectedItem().equals(AwardsCalType.valueMorL)) {//数值增减
			this.kdtPolicyEntry.getHeadRow(0).getCell("diffCoeff").setValue("变动系数");
			this.kdtPolicyEntry.getHeadRow(0).getCell("diff").setValue("增减值");
			
			this.kdtPolicyEntry.getColumn("floor").getStyleAttributes().setHided(true);
			this.kdtPolicyEntry.getColumn("upper").getStyleAttributes().setHided(true);
			this.kdtPolicyEntry.getColumn("diffCoeff").getStyleAttributes().setHided(false);
			this.kdtPolicyEntry.getColumn("diff").getStyleAttributes().setHided(false);
			this.kdtPolicyEntry.getColumn("calValue").getStyleAttributes().setHided(true);
		}	
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);
		
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
		  checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
		  IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
		  if (objectValue != null)
		  {
		    try
		    {
		      String id = this.idList.getID(this.idList.getCurrentIndex());
		      setOprtState("RELEASEALL");
		      pubFireVOChangeListener(id);
		    }
		    catch (Throwable E) {
		    }
		  }
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");
		

		this.editData.setBaseStatus(null);
		
		setDataObject(this.editData);
//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	@Override
	public void storeFields() {
		// TODO Auto-generated method stub
		super.storeFields();
		if(StringUtils.isNotEmpty(editData.getFormulaTxt())){
			if(!editData.getFormulaTxt().trim().endsWith(";")) {
				editData.setFormulaTxt(editData.getFormulaTxt().trim()+";");
			}
		}
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		if(this.calType.getSelectedItem().equals(AwardsCalType.custom)) {
			if(StringUtils.isEmpty(this.txtformulaTxt.getText())){
				MsgBox.showWarning("计算公式不能为空！");
				SysUtil.abort();
			}
		}
	}
	
	
}