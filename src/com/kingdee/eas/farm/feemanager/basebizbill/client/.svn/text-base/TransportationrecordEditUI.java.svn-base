/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.ibm.db2.jcc.a.c;
import com.ibm.db2.jcc.a.f;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum;
import com.kingdee.eas.farm.feemanager.basebizbill.CalfrightFacadeFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.ICalfrightFacade;
import com.kingdee.eas.farm.feemanager.basebizbill.ITransportationrecord;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryInfo;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.reportone.r1.form.engine.x.util.SwingUtil;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class TransportationrecordEditUI extends AbstractTransportationrecordEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TransportationrecordEditUI.class);

	/**
	 * output class constructor
	 */
	public TransportationrecordEditUI() throws Exception
	{
		super();
		//图标初始化
		this.audit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.auditback.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));

	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
		initUIComp();
	}
	private void initUIComp() {
		// TODO Auto-generated method stub

		// F7查询过滤
		SelectorListener[] selLis = prmtcar.getSelectorListeners();
		for (SelectorListener lis : selLis) {
			prmtcar.removeSelectorListener(lis);
		}
		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;

			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						EntityViewInfo evi = new EntityViewInfo(); // 实体视图信息
						FilterInfo fi = new FilterInfo();// 过滤信息
						fi.getFilterItems().add(
								new FilterItemInfo("companyOrgUnit.id",
										SysContext.getSysContext().getCurrentFIUnit().getId().toString(),
										CompareType.EQUALS));

						fi.getFilterItems().add(
								new FilterItemInfo("carstate",
										'2',
										CompareType.EQUALS));
						fi.setMaskString("#0 and #1");

						evi.setFilter(fi);
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI(
								evi);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner", javax.swing.SwingUtilities
							.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true, ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);

				}
			}
		});
		//		 prmtcar.addDataChangeListener(new DataChangeListener() {
		//				public void dataChanged(DataChangeEvent e) {
		//					try {
		////						prmtcar_Changed();
		//					}
		//					catch (Exception exc) {
		//						handUIException(exc);
		//					}
		//				}
		//			});

	}


	@Override
	public void prmtcar_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.prmtcar_Changed();
		//		prmtdrive.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcar.getData(),"driverID"));

	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		DataChangeListener[] listener = prmtcar.getListeners(DataChangeListener.class);
		for(int i=0;i<listener.length;i++)

			super.loadFields();
		if((BillBaseStatusEnum.AUDITED).equals(this.status.getSelectedItem())){
			this.actionAudit.setEnabled(false);
			this.audit.setEnabled(false);
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionAddLine.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(false);
			this.contfreight.setEnabled(false);
			this.actionCalfright.setEnabled(false);


			//审查状态下  审核、新增、修改、添加分录条目、删除、删除分录条目、保存等不可用

		} else if((BillBaseStatusEnum.SUBMITED).equals(this.status.getSelectedItem())){
			this.actionAudit.setEnabled(true);
			this.auditback.setEnabled(false);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.actionAddLine.setEnabled(true);
			this.actionRemove.setEnabled(true);
			this.actionRemoveLine.setEnabled(true);
			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
			this.actionSendend.setEnabled(false);
		}else if((BillBaseStatusEnum.ADD).equals(this.status.getSelectedItem())){
			this.actionAudit.setEnabled(true);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.auditback.setEnabled(false);
			this.actionAddLine.setEnabled(true);
			this.actionRemove.setEnabled(true);
			this.actionRemoveLine.setEnabled(true);
			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
			this.actionSendend.setEnabled(false);
		}else if((BillBaseStatusEnum.TEMPORARILYSAVED).equals(this.status.getSelectedItem())){
			this.actionAudit.setEnabled(true);
			this.auditback.setEnabled(false);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.actionAddLine.setEnabled(true);
			this.actionRemove.setEnabled(true);
			this.actionRemoveLine.setEnabled(true);
			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
			this.actionSendend.setEnabled(false);
		}else if((BillBaseStatusEnum.DELETED).equals(this.status.getSelectedItem())){
			this.actionAudit.setEnabled(false);
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionAddLine.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionRemoveLine.setEnabled(false);
			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(true);
			this.actionSendend.setEnabled(false);
			this.auditback.setEnabled(false);
		};
		//其他状态下均可用


	}
	/**
	 * 初始化界面
	 */
	private void initUI(){
		btnSubmit.setText("配车");
		btnSubmit.setToolTipText("配车");
		audit.setText("司机确认");
		audit.setToolTipText("司机确认");
		auditback.setText("反确认");
		auditback.setToolTipText("反确认");
		sendend.setText("派送完成");
		sendend.setToolTipText("派送完成");
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.auditback.setIcon(EASResource.getIcon("imgTbtn_unaudit")); 
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		kdtCarEntry.getColumn("seq").getStyleAttributes().setHided(true);
		txtsingleMileage.setHorizontalAlignment(SwingConstants.RIGHT);
		txttotalMileage.setHorizontalAlignment(SwingConstants.RIGHT);
	}


	/**
	 * 车辆运输单——运费计算方法
	 * @author yumx
	 * 在TransportationrecordEditUI中调用
	 * 必需数据：物料名称，物料数量，车辆信息，单/全公里里程，物料ID
	 * 生成数据：合计运费，核算信息分录
	 * 时间：2017.3.28
	 */
	@Override
	public void actionCalfright_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if ((BillBaseStatusEnum.AUDITED).equals(this.status.getSelectedItem())) {
			MsgBox.showWarning("非审核状态不可计算");
			SysUtil.abort();
		} else {

			TransportationrecordEntryInfo EntryInfo = new TransportationrecordEntryInfo();

			EntryInfo = this.editData.getEntrys().get(0);
			if(this.editData.getTotalMileage()== null || this.editData.getCar() == null || EntryInfo.getMateriel().getId() == null){
				MsgBox.showWarning("要素存在空值，无法进行计算，请先补充完整！");
				SysUtil.abort();
			}

			//取得当日油价
			BigDecimal dop = new BigDecimal("0");
			String str =SysContext.getSysContext().getCurrentFIUnit().getName().toString();
			try {
				HashMap<Object, Object> result = CalfrightFacadeFactory
				.getRemoteInstance().oiljudg(str,this.editData.getBizDate().toString());
				IRowSet rs = (IRowSet) result.get("result");
				if(rs.size()!=0){
					while (rs.next()) {
						dop = dop.add(rs.getBigDecimal("cfdailyprice"));
					}
				}else{
					MsgBox.showWarning("未定义有效的当日柴油价格！");
					SysUtil.abort();
				}			
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			BigDecimal standkil = new BigDecimal("0");
			BigDecimal oil = new BigDecimal("0");
			BigDecimal of = new BigDecimal("0");
			BigDecimal ff = new BigDecimal("0");

			HashMap<Object, Object> result = CalfrightFacadeFactory
			.getRemoteInstance().calfright(
					this.editData.getCar().getId().toString(),this.editData.getTotalMileage().toString(),EntryInfo.getMateriel().getId().toString(),this.editData.getCompanyOrgUnit().getId().toString());

			BigDecimal cala = new BigDecimal("0");
			BigDecimal duck = new BigDecimal("0");
			BigDecimal sub = new BigDecimal("0");
			// 接收返回map中的result值
			IRowSet rs = (IRowSet) result.get("result");
			// 更新结算政策行
			// 更新结算政策行时先对结算政策行进行清空
			kdtAssEntrys.removeRows();
			//对result是否为空进行判断，防止空指针出现
			if (rs.size() == 0) {
				MsgBox.showWarning("无匹配结算政策，请检查单据信息！");
				SysUtil.abort();
			} else {
				if(rs.size() > 1){
					MsgBox.showWarning("有多个匹配政策，请检查政策信息！");
					SysUtil.abort();
				}else{
					while (rs.next()) {
						IRow newRowname = kdtAssEntrys.addRow();
						newRowname.getCell("settle").setValue("政策名称");

						newRowname.getCell("price").setValue(
								rs.getObject("name"));

						IRow newRowoil = kdtAssEntrys.addRow();
						newRowoil.getCell("settle").setValue("当日油价");
						newRowoil.getCell("price").setValue(
						"0");
						newRowoil.getCell("formula").setValue("直接取当日油价:"+dop);
						IRow newRowcala = kdtAssEntrys.addRow();
						//计算实际运费单价（cala）
						newRowcala.getCell("settle").setValue("实际运费");
						standkil = standkil.add(rs.getBigDecimal("standkil"));
						oil = oil.add(rs.getBigDecimal("oil"));
						of = of.add(rs.getBigDecimal("oilf"));
						ff = ff.add(rs.getBigDecimal("ff"));
						BigDecimal dop1 = new BigDecimal("0");
						dop1=dop1.add(dop);
						dop = dop.subtract(oil);
						//取余
						dop = dop.divide(of,0,BigDecimal.ROUND_DOWN);
						dop = dop.multiply(ff);
						cala = cala.add(standkil);
						cala = cala.add(dop);

						BigDecimal calaall = new BigDecimal(this.editData
								.getTotalMileage().toString());
						calaall = calaall.multiply(cala);

						newRowcala.getCell("price").setValue(calaall);
						newRowcala.getCell("formula").setValue("["+standkil+"+("+dop1+"-"+oil+")÷"+of+"×"+ff+"]"+"×"+this.editData
								.getTotalMileage().toString());

						IRow newRowduck = kdtAssEntrys.addRow();
						//取出鸭苗补贴单价（duck）
						BigDecimal mnumbe = new BigDecimal("0");
						//循环取商品鸭苗合计数量
						for (int i = 0; i < this.editData.getEntrys().size(); i++) {
							EntryInfo = this.editData.getEntrys().get(i);
							mnumbe = mnumbe.add(EntryInfo.getMaterrelnumber());
						}


						newRowduck.getCell("settle").setValue("鸭苗补贴单价");


						//newRow.getCell("subsidy").setValue(subsidy);
						BigDecimal rsduck = rs.getBigDecimal("duck");
						newRowduck.getCell("formula").setValue(mnumbe+"×"+rsduck);
						mnumbe = mnumbe.multiply(rsduck);
						newRowduck.getCell("price").setValue(mnumbe);




						IRow newRowsub = kdtAssEntrys.addRow();
						//取出远距离补贴金额（sub）
						newRowsub.getCell("settle").setValue("远距离补贴");
						newRowsub.getCell("price").setValue(rs.getObject("sub"));
						newRowsub.getCell("formula").setValue("直接取政策远距离补贴");
						sub = sub.add(rs.getBigDecimal("sub"));
						duck = duck.add(rsduck);
					}
					BigDecimal fright = new BigDecimal("0");
					//				TransportationrecordEntryInfo EntryInfo = new TransportationrecordEntryInfo();
					//				this.editData.getEntrys().size();
					//				//TransportationrecordEntryCollection tcll;
					//				// 通过正则表达式来判断物料种类（后期物料字段修改类型可在此处修改）
					//				// 判断物料类型是否是种鸭苗
					//				EntryInfo = this.editData.getEntrys().get(0);
					//				EntryInfo.getMateriel().toString();
					//				Pattern pattern = Pattern.compile("[*种鸭*]");
					//				Matcher matcher = pattern.matcher(EntryInfo.getMateriel().toString());
					//				System.out.println(EntryInfo.getMateriel().getId());
					////				tcll = TransportationrecordEntryFactory.getRemoteInstance()
					////						.getTransportationrecordEntryCollection(
					////								"where materiel like '%种鸭%'");
					////				if (tcll.size() != 0) {
					//				
					//				if(matcher.find()){
					//					// 如果是种鸭苗则运费合计为单程里程*基数
					//					fright = fright.add(cala);
					//					BigDecimal onem = new BigDecimal(this.editData
					//							.getOnemileage().toString());
					//					fright = fright.multiply(onem);
					//					this.txtfreight.setValue(fright);
					//				} else {

					//循环取商品鸭苗合计数量
					for (int i = 0; i < this.editData.getEntrys().size(); i++) {
						EntryInfo = this.editData.getEntrys().get(i);
						fright = fright.add(EntryInfo.getMaterrelnumber());
					}
					txttotalQty.setValue(fright);
					//计算合计运费：实际运费单价*公里数+鸭苗补贴单价*商品鸭苗运送数量
					BigDecimal frcal = new BigDecimal(cala.toString());
					BigDecimal frallcal = new BigDecimal(this.editData
							.getTotalMileage().toString());
					// 每公里平均运费与单据头的公里数相乘
					frcal = frcal.multiply(frallcal);
					// 物料数量与物料补贴单价相乘
					fright = fright.multiply(duck);
					// 运费+鸭苗补贴+远距离补贴得出运费
					fright = fright.add(frcal);
					fright = fright.add(sub);
					System.out.println("合计运费为："+fright);
					this.txtfreight.setValue(fright);
					txtavePrice.setValue(fright.divide(txttotalQty.getBigDecimalValue(),2,BigDecimal.ROUND_HALF_EVEN));
				}
			}
			//}
		}
		// this.storeFields();
		// this.loadData();
		String saleIssuebillID = "";
		String str="";
		super.actionCalfright_actionPerformed(e);
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "stockout").getValue()!=null){
				saleIssuebillID=((IObjectValue)kdtEntrys.getCell(i, "stockout").getValue()).getString("id");
				str="update T_IM_SaleIssueEntry set CFSingleFright="+(txtavePrice.getBigDecimalValue()==null?"":txtavePrice.getBigDecimalValue())+" where FParentID='"+saleIssuebillID+"'";
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(str);
			}
		}
	}
	@Override
	//派送完成
	//服务端执行更新车辆信息操作
	public void actionSendend_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSendend_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		setMessageText("派送完成");
		showMessage();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		UIUtil.refreshEditUI(this);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
	}
	@Override
	//审核
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		setMessageText("确认完成");
		showMessage();
	}
	@Override
	//反审核
	public void actionAuditback_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAuditback_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		setMessageText("反确认完成");
		showMessage();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getStatus().equals(BillStatusEnum.Save)||editData.getStatus().equals(BillStatusEnum.ArrCar))
			super.actionEdit_actionPerformed(e);
		else
			commUtils.giveUserTipsAndRetire("已确认或派车完成的单据禁止编辑");
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getStatus().equals(BillStatusEnum.Save)||editData.getStatus().equals(BillStatusEnum.ArrCar))
			super.actionRemove_actionPerformed(e);
		else
			commUtils.giveUserTipsAndRetire("已确认或派车完成的单据禁止删除");

	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo objectValue = new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("companyOrgUnit",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		CompanyOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentFIUnit();
		//		objectValue.setCompanyOrgUnit(currAdminOrg);
		objectValue.setNumber(createNumber());
		return objectValue;
	}
	/**
	 * 新增单据时创建一个编码,格式为"yyyyMM"+"Seq"
	 * @return 单据编号
	 */
	private String createNumber() {
		// TODO Auto-generated method stub
		String str="";
		try {
			int num=1;
			TransportationrecordCollection coll;
			do{
				str=MathUtilsComm.getStringByNumber(3, num);
				str = (new SimpleDateFormat("yyyyMM")).format(new Date())+str;
				coll = TransportationrecordFactory.getRemoteInstance().getTransportationrecordCollection("where number='"+str+"'");
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
	@Override
	public void actionUpdateMileage_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getStatus().equals(BillStatusEnum.Reback))
			commUtils.giveUserTipsAndRetire("派送完成的单子才允许此操作");
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("src", editData);
		map.put("ui", this);
		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.feemanager.basebizbill.client.MileModifyRecordEditUI", map, null, OprtState.ADDNEW);
		super.actionUpdateMileage_actionPerformed(e);
	}
	@Override
	public void actionViewUpdateMileage_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getStatus().equals(BillStatusEnum.Reback))
			commUtils.giveUserTipsAndRetire("派送完成的单子才允许此操作");
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("src", editData);
		map.put("ui", this);
		ClientUtils.openChildUIFromParentUI(UIFactoryName.MODEL, "com.kingdee.eas.farm.feemanager.basebizbill.client.MileModifyRecordListUI", map, null, OprtState.VIEW);
		super.actionViewUpdateMileage_actionPerformed(e);
	}
	
}