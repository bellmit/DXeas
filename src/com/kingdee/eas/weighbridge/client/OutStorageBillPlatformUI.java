/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingConstants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.client.F7MaterialSimpleSelector;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.client.IBTPBillEdit;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.publicdata.CarType;
import com.kingdee.eas.publicdata.CardReaderFactory;
import com.kingdee.eas.publicdata.CardReaderInfo;
import com.kingdee.eas.publicdata.CardRelationCollection;
import com.kingdee.eas.publicdata.CardRelationFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.F7SelectBillInfo;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.eas.weighbridge.IOutStorageBill;
import com.kingdee.eas.weighbridge.IOutStorageBillEntry;
import com.kingdee.eas.weighbridge.IOutStorageBillEntryDetail;
import com.kingdee.eas.weighbridge.OutStorageBillEntryCollection;
import com.kingdee.eas.weighbridge.OutStorageBillEntryDetailCollection;
import com.kingdee.eas.weighbridge.OutStorageBillEntryDetailFactory;
import com.kingdee.eas.weighbridge.OutStorageBillEntryDetailInfo;
import com.kingdee.eas.weighbridge.OutStorageBillEntryFactory;
import com.kingdee.eas.weighbridge.OutStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.OutStorageBillFactory;
import com.kingdee.eas.weighbridge.OutStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBaseType;
import com.kingdee.eas.weighbridge.WeighBillType;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.WeighBridgeFactory;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.eas.weighbridge.WeighLogInfo;
import com.kingdee.eas.weighbridge.weightbridgeFacadeFactory;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import com.kingdee.eas.weighbridge.comm.BTPBillEditImplEx;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 出庫過榜單操作界面
 * 
 * @author Simple_Dai
 * 
 */
public class OutStorageBillPlatformUI extends AbstractOutStorageBillPlatformUI {
	private static final Logger logger = CoreUIObject.getLogger(OutStorageBillPlatformUI.class);
	private OutStorageBillInfo editData;// 过榜单基本数据
	public final static String billTable = "CT_WHB_OutStorageBill";// 过榜单表
	public final static String billEntryTable = "CT_WHB_OutStorageBillEntry";// 过榜单分录表
	public final static String billDetailTable = "CT_WHB_OutStorageBillDetail";// 过榜单明细表
	private final static String carTable = "CT_PUB_Car";// 过榜单分录表
	private KDWorkButton btnBeginRead;
	private KDWorkButton btnEndRead;
	private KDWorkButton btnModifyImpurity;
	private WeighBaseStatus oldBillStatus;
	private IBTPBillEdit billEdit;
	private Boolean isWeighted;//是否称重
	private HashMap<String, Object> initParams;//初始化参数
	private carDataChangeListenerClass carDataChangeListener;
	private imputityDataChangeListenerClass imputityDataChangeListener;
	private IBTPManager iBTPManager;
	private ExecutorService pool;//com读取线程池
	private Boolean isNeedRead;
	private Boolean isNeedExit;
	// private HashMap<String,ObjectUuidPK> nowBillMap;//当前选择单据ID信息
	private BigDecimal orderBaseQty,orderBagQty;
	private Boolean  isSaveTemp=false;//是否保存临时净重
	WeighBridgeInfo bridgeInfo ;
	// 称重数值，每次称重确认后更新 该字段值为磅秤显示数值
	private BigDecimal weightValue;
	// 记录是否失去焦点 避免订单 回车和 点击按钮 重复触发事件
	private boolean orderFocusLost = false;
	/**
	 * output class constructor
	 */
	public OutStorageBillPlatformUI() throws Exception {
		super();
		btnBeginRead = new KDWorkButton("读取");
		btnBeginRead.setName("btnBegin");
		btnBeginRead.setEnabled(true);
		btnEndRead = new KDWorkButton("停止");
		btnEndRead.setName("btnEnd");
		btnEndRead.setEnabled(false);
		//isNeedExitList.put(this.getClass().getSimpleName(), false);
	}
	
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		StorageOrgUnitInfo storageUnitOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(storageUnitOrg!=null&&!storageUnitOrg.isIsBizUnit()) {
			MsgBox.showWarning("非实体库存组织不允许操作！");
			SysUtil.abort();
		}
		initData();
		initControl();
		beginComReaderNew();
		//增加读数线程
		//pool.submit(new ShowLblThread(this,this.labShowWeight));
		
	}

	/**
	 * 初始化變量
	 */
	private void initData() throws Exception {
		editData = null;
		isWeighted=false;
		isNeedRead=true;
		isNeedExit=false;
		carDataChangeListener=new carDataChangeListenerClass();
		imputityDataChangeListener=new imputityDataChangeListenerClass();
		pool=Executors.newCachedThreadPool();
		orderBaseQty=BigDecimal.ZERO;
		orderBagQty=BigDecimal.ZERO;

		iBTPManager = null;
		if (getMainOrgContext() == null) {
			iBTPManager = BTPManagerFactory.getRemoteInstance();
		} else {
			iBTPManager = BTPManagerFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
		}

		billEdit = new BTPBillEditImplEx(this);
		billEdit.init();
		String settingID=null;
		settingID=setComReadPort();
		setComReadPort();
		
		initParams=new HashMap<String,Object>();
		initParams.put("weighBaseType",null);//过磅方式
		initParams.put("weighBizType",null);//业务类型
		initParams.put("materialSet", null);//物料列表
		initParams.put("isAutoCreateToInvBill", false);//是否自动生成出入库
		if(StringUtils.isNotBlank(settingID)) {//设置不为空
			HashSet materialIDsSet=null;
			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 tentry.CFDefaultWeighType,tentry.CFDefaultBizType,tentry.CFIsAuto2Inv,tmentry.CFMaterialID,");
			sql.append(" tentry.CFIsAuto2Inv,isnull(tentry.CFRange,0) CFRange");
			sql.append(" from CT_WHB_SettingEntrys tentry ");
			sql.append(" left join CT_WHB_SettingMaterialEntrys tmentry on tmentry.FParentID=tentry.FID");
			sql.append(" where tentry.FParentID=? and tentry.CFWeighBillType=?");
			IRowSet rs=getSqlInstance().executeQuery(sql.toString(), new Object[]{settingID,WeighBillType.outStorage.getValue()});
			while(rs.next()){
				if(rs.getRow()==1) {
					initParams.put("weighBaseType", rs.getString("CFDefaultWeighType"));
					initParams.put("weighBizType", rs.getString("CFDefaultBizType"));
					initParams.put("isAutoCreateToInvBill",rs.getBoolean("CFIsAuto2Inv"));
					initParams.put("range",rs.getBigDecimal("CFRange"));
				}
				if(StringUtils.isNotBlank(rs.getString("CFMaterialID"))) {
					if(materialIDsSet==null)
						materialIDsSet=new HashSet();
					materialIDsSet.add(rs.getString("CFMaterialID"));
				}
			}
			rs.close();
			initParams.put("materialSet", materialIDsSet);//物料列表
		}
	}

	/**
	 * 設置COM通訊類
	 * 
	 * @throws UnknownHostException
	 * @throws SocketException
	 * */
	private String setComReadPort() throws Exception {
		String id=null;//单据id
		String macAddress = ComReaderUtils.getLocalMac();
		final IRowSet rs = getSqlInstance().executeQuery(" select * from CT_WHB_Setting where CFmac=?",
				new Object[] { macAddress });
		if (rs.next()) {
			id=rs.getString("fid");


			 bridgeInfo = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
			 pool.execute(new Thread(){
				WeighBridgeInfo info = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
				ComReaderUtils cr=new ComReaderUtils(info,0);
				String returnValue;
				public void run() {
					while (true) {
						try {
							Thread.currentThread().sleep(400);
							if(isNeedRead) {
								//打开端口
								if(cr!=null&&!cr.isOpened()){
									try {
										cr.openPort();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								//读取数据
								returnValue=cr.getPortData();
								if (StringUtils.isNotBlank(returnValue)) {
									ChangeShowLable(returnValue);
								}
							}else {
								ChangeShowLable("待读取");
								if(cr!=null&&cr.isOpened()){
									try {
										cr.closePort();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(isNeedExit) {
								Thread.currentThread().destroy();
							}
						} catch (BOSException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		} else {
			MsgBox.showWarning("界面无法打开，请检查以下问题:1、界面是否二次打开；2、地磅设置是否正确；3、串口线头是否接通；");
		}
		rs.close();
		return id;
	}
	
	
	
	public Boolean getIsNeedRead() {
		return isNeedRead;
	}

	public synchronized void setIsNeedRead(Boolean isNeedRead) {
		this.isNeedRead = isNeedRead;
	}
//	/**
//	 * 設置COM通訊類  读卡器
//	 * 
//	 * @throws UnknownHostException
//	 * @throws SocketException
//	 * */
//	private String setCardReadComPort() throws Exception {
//		String macAddress = ComReaderUtils.getCPUID();
//		final IRowSet rs = getSqlInstance().executeQuery(" select t2.CFCardID FID from CT_PUB_CardSetting t1 inner join CT_PUB_CardSettingEntry t2 on t2.FParentID=t1.FID where t1.CFmac=?",
//				new Object[] { macAddress });
//		while(rs.next()) {
//			pool.execute(new Thread(){
//				CardReaderInfo cardReaderInfo=CardReaderFactory.getRemoteInstance().getCardReaderInfo(new ObjectUuidPK(rs.getString("fid")));
//				com.kingdee.eas.wlhlcomm.client.BaseComReaderUtils cr=new com.kingdee.eas.wlhlcomm.client.BaseComReaderUtils(cardReaderInfo);
//				String returnValue;
//				public void run() {
//					while(true) {
//						if(isNeedRead) {
//							//打开端口
//							if(cr!=null&&!cr.getIsOpened()){
//								try {
//									cr.openPortAutoRead();
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//							}
//							//读取数据
//							returnValue=cr.getReturnValue();
//							if (StringUtils.isNotBlank(returnValue)) {
//								try {
//									cr.setReturnValue(null);
//									ChangeCarBycardNumber(returnValue);
//								} catch (BOSException e) {
//									e.printStackTrace();
//								}
//							}
//						}else {
//							if(cr!=null&&cr.getIsOpened()){
//								try {
//									cr.closePort();
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//							}
//						}
//						if(isNeedExit) {
//							Thread.currentThread().destroy();
//						}
//					}
//				}
//			});
//		}
//		rs.close();
//		return null;
//	}
	/**
	 * 根据单据编码设置车辆字段
	 * @throws BOSException 
	 */
	public synchronized void ChangeCarBycardNumber(String cardNumber) throws BOSException {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("number",cardNumber,CompareType.EQUALS));
		filter.setMaskString("#0");
		ev.setFilter(filter);
		CardRelationCollection cardCol=CardRelationFactory.getRemoteInstance().getCardRelationCollection(ev);
		if(cardCol!=null&&cardCol.size()>0) {
			loadDataByCar(cardCol.get(0).getBaseData());
		}else {
			MsgBox.showWarning("没有对应的车辆信息！");
		}
	}
	/**
	 * 根据车辆id带出最后一张改车没有完成的过榜单
	 */
	private void loadDataByCar(CarInfo carInfo) {
		try {
			 OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
			  IRowSet rs=getExeQueryRowSet(orgInfo,null,null,null,carInfo.getId().toString()," and CFBillStatus<3");
			  if(rs.next()) {
				  setNewBillInfo(rs.getString("FID"));
				  LoadFields(null);
			  }else {
				  	editData = new OutStorageBillInfo();
				  	HashMap map=new HashMap();
				  	map.put("carInfo", CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(carInfo.getId())));
					LoadFields(map);
					initControlDeafultValue();
			  }
			  rs.next();
			}catch(Exception e) {
				super.handleException(e);
			}
	}
	
	/**
	 * 根据单据编码设置称重
	 * @throws BOSException 
	 */
	private synchronized  void ChangeShowLable(String value) throws BOSException {
		this.labShowWeight.setText(value);
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

	/**
	 * 稱重
	 */
	protected void btnWeight_actionPerformed(ActionEvent e) throws Exception {
		this.isSaveTemp=false;
		//this.labShowWeight.setText("90000");//模拟过磅数量修改
		String txtShow = this.labShowWeight.getText();
		if (StringUtils.isBlank(txtShow)) {
			MsgBox.showWarning("读数数值失败，请检查设置！");
			SysUtil.abort();
		}
		try {
			Double.parseDouble(txtShow);
		} catch (Exception ee) {
			MsgBox.showWarning("读数数值失败，请检查设置！");
			SysUtil.abort();
		}
		BigDecimal nowWeigh = new BigDecimal(txtShow);
		if (editData!=null&&editData.getId() != null) {// 已保存单据 根据单据状态和过磅方式判断
			BigDecimal impurityQty=this.txtImpurity.getBigDecimalValue();
			BigDecimal grossQty=this.txtGross.getBigDecimalValue();
			if(grossQty==null) {
				grossQty=BigDecimal.ZERO;
			}
			BigDecimal tareQty=this.txtTare.getBigDecimalValue();
			if(tareQty==null) {
				tareQty=BigDecimal.ZERO;
			}
			if(impurityQty==null) {
				impurityQty=BigDecimal.ZERO;
			}
			if (editData.getWeighType().equals(WeighBaseType.Tare2Gross)) {// 过磅方式
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// 保存{
					this.txtTare.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {// 已过皮重
					this.txtGross.setValue(nowWeigh);
					this.txtActualSuttle.setValue((nowWeigh.subtract(tareQty)).subtract(impurityQty));
					//this.txtActualSuttle.setValue(this.txtSuttle.getBigDecimalValue());
					//显示差异 add@20161130
					if(orderBaseQty!=null&&orderBaseQty.signum()>0) {
						BigDecimal sumSuttle=txtActualSuttle.getBigDecimalValue();
						this.txtSuttle.setValue(orderBaseQty);

						this.lblSuttleDiff.setText(orderBaseQty.subtract(sumSuttle).setScale(2, BigDecimal.ROUND_HALF_UP)+"kg");
					}
				} 
			} else if (editData.getWeighType().equals(WeighBaseType.Gross2Tare)) {
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// 保存{
					this.txtGross.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {// 已过毛重
					this.txtTare.setValue(nowWeigh);
					this.txtSuttle.setValue((grossQty.subtract(nowWeigh)).subtract(impurityQty));
					//this.txtSuttle.setValue(orderBaseQty);
					this.txtActualSuttle.setValue(this.txtSuttle.getBigDecimalValue());
					//显示差异 add@20161130
					if(orderBaseQty!=null&&orderBaseQty.signum()>0) {
						BigDecimal sumSuttle=txtActualSuttle.getBigDecimalValue();
						this.lblSuttleDiff.setText(orderBaseQty.subtract(sumSuttle).setScale(2, BigDecimal.ROUND_HALF_UP)+"kg");
					}
				}

			} else if (editData.getWeighType().equals(WeighBaseType.Tare2Gross2Tare)) {
				if (editData.getBillStatus()==null||editData.getBillStatus().equals(WeighBaseStatus.save)) {// 保存{
					this.txtTare.setValue(nowWeigh);
				}else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {// 已过皮重
					this.txtGross.setValue(nowWeigh);
				} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {// 已过毛重
					this.txtTare2.setValue(nowWeigh);//二次净重
					this.txtSuttle.setValue((grossQty.subtract(nowWeigh)).subtract(impurityQty));
					//this.txtSuttle.setValue(orderBaseQty);
					this.txtActualSuttle.setValue(this.txtSuttle.getBigDecimalValue());
					//显示差异 add@20161130
					if(orderBaseQty!=null&&orderBaseQty.signum()>0) {
						BigDecimal sumSuttle=txtActualSuttle.getBigDecimalValue();
						this.lblSuttleDiff.setText(orderBaseQty.subtract(sumSuttle).setScale(2, BigDecimal.ROUND_HALF_UP)+"kg");
					}
				}
			}
		} else {// 新单据 根据过磅方式判断
			if (this.rdoTare2Gross.isSelected()) {
				this.txtTare.setValue(nowWeigh);
			} else if (this.rdoGross2Tare.isSelected()) {
				this.txtGross.setValue(nowWeigh);
			} else if (this.rdoTare2Gross2Tare.isSelected()) {
				this.txtTare.setValue(nowWeigh);
			}
		}
		
		
		isWeighted=true;
		
		// 暂存过磅数值
		weightValue = nowWeigh.add(BigDecimal.ZERO);
		// this.impirityChanged();//重新计算净重
	}

	/**
	 * 新增
	 */
	
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		this.execQuery();
		this.resetBill();
		this.setNextMessageText("新增");
		showMessage();
	}

	/**
	 * 初始化控件
	 * 
	 * @throws BOSException
	 */
	private void initControl() throws BOSException {
		this.setUITitle("出库过榜单");
		this.setIsShowTextOnly(true);
		setShowMessagePolicy(2);
		
		this.cmbIsAuto2Inv.setVisible(false);

		this.dpInTime.setTimeEnabled(true);
		this.dpOutTime.setTimeEnabled(true);
		this.txtNumber.setEnabled(false);
		this.dpBizDate.setEnabled(false);
		this.txtTare.setEnabled(false);
		this.txtGross.setEnabled(false);
		this.txtSuttle.setEnabled(false);
		this.txtActualSuttle.setEnabled(false);
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setSupportedEmpty(false);
		this.dpEndDate.setSupportedEmpty(false);

		this.txtTare.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtGross.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtSuttle.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtActualSuttle.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTempSuttle.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTare2.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtImpurity.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtTare.setDataType(1);
		this.txtTare.setPrecision(4);
		this.txtGross.setDataType(1);
		this.txtGross.setPrecision(4);
		this.txtSuttle.setDataType(1);
		this.txtSuttle.setPrecision(4);
		this.txtActualSuttle.setDataType(1);
		this.txtActualSuttle.setPrecision(4);
		this.txtTempSuttle.setDataType(1);
		this.txtTempSuttle.setPrecision(4);
		this.txtTare2.setDataType(1);
		this.txtTare2.setPrecision(4);
		this.txtImpurity.setDataType(1);
		this.txtImpurity.setPrecision(4);

		F7MaterialSimpleSelector m7 = new F7MaterialSimpleSelector(this, prmtMaterial);
		m7.setBaseFilter(new FilterInfo());
		this.prmtMaterial.setSelector(m7);
		this.prmtMaterial.setEditFormat("$number$");
		this.prmtMaterial.setCommitFormat("$number$");
		this.prmtMaterial.setRequired(true);
		if(this.initParams.get("materialSet")!=null) {
			HashSet set=(HashSet) this.initParams.get("materialSet");
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			filter.setMaskString("#0");
			ev.setFilter(filter);
			m7.setBaseFilter(filter);
			//this.prmtMaterial.setEntityViewInfo(ev);
		}
		
		this.prmtQueryMaterial.setSelector(m7);
		this.prmtQueryMaterial.setEditFormat("$number$");
		this.prmtQueryMaterial.setCommitFormat("$number$");
		this.prmtQueryMaterial.setDisplayFormat("$name$");
		
		this.prmtCar.setRequired(true);
		this.prmtCar.setEditFormat("$number$");
		this.prmtCar.setCommitFormat("$number$");
		this.prmtCar.setDisplayFormat("$number$");
		this.prmtCar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.publicdata.client.CarListUI prmtcar_F7ListUI = null;

			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.publicdata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner", javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true, ctx);
					prmtCar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
		
		this.prmtQueryCar.setEditFormat("$number$");
		this.prmtQueryCar.setCommitFormat("$number$");
		this.prmtQueryCar.setDisplayFormat("$number$");
		this.prmtQueryCar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.publicdata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.publicdata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner", javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true, ctx);
					prmtQueryCar.setSelector(prmtcar_F7ListUI);
				}
			}
		});

		this.tbList.checkParsed();
		this.tbList.getStyleAttributes().setLocked(true);
		this.tbList.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.tbList.addKDTMouseListener(new KDTMouseListener() {
			public void tableClicked(KDTMouseEvent e) {
				if (e.getClickCount() == 2) {
					tbList_clicked(e);
				}
			}
		});

		StorageBizUnitF7 storageUnitOrgF7 = new StorageBizUnitF7();
		this.prmtOrderStorageOrgUnit.setSelector(storageUnitOrgF7);
		this.prmtOrderStorageOrgUnit.setDisplayFormat("$name$");
		this.prmtOrderStorageOrgUnit.setEditFormat("$number$");
		this.prmtOrderStorageOrgUnit.setCommitFormat("$number$");
		this.prmtOrderStorageOrgUnit.setRequired(true);

		// F7CustomerSimpleSelector c7 = new F7CustomerSimpleSelector(this,
		// prmtCustomer);
		// c7.setBaseFilter(new FilterInfo());
		// this.prmtCustomer.setSelector(c7);
		this.prmtCustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");
		this.prmtCustomer.setDisplayFormat("$name$");
		this.prmtCustomer.setEditFormat("$number$");
		this.prmtCustomer.setCommitFormat("$number$");
		this.prmtCustomer.setRequired(true);

		this.contCustomer.setVisible(true);
		this.contOrderStorageOrgUnit.setVisible(false);
		this.kDSeparator2.setVisible(true);
		
		//this.cmbBizType.setSelectedItem(WeighBizType.TransOut);
		this.cmbBizType.removeItem(WeighBizType.Pur);// 移除采购的选项
		this.cmbBizType.removeItem(WeighBizType.TransIn);// 移除采购的选项
		this.cmbBizType.removeItem(WeighBizType.GroupPur);// 移除采购的选项
		this.cmbBizType.removeItem(WeighBizType.TransOut);//移除调拨出
		this.cmbBizType.removeItem(WeighBizType.RecCK);//其他
		this.cmbBizType.removeItem(WeighBizType.localPur);//移除调拨出

		
		this.cmbBizType.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cmbBizType_changed(e);
			}
		});

		this.rdoTare2Gross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editData != null && editData.getId() != null)
					return;
				// TODO Auto-generated method stub
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
			}
		});
		this.rdoGross2Tare.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
			}
		});
		this.rdoTare2Gross2Tare.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (editData != null && editData.getId() != null)
					return;
				txtTare.setValue(BigDecimal.ZERO);
				txtGross.setValue(BigDecimal.ZERO);
				txtTare2.setValue(BigDecimal.ZERO);
				txtSuttle.setValue(BigDecimal.ZERO);
				txtImpurity.setValue(BigDecimal.ZERO);
			}
		});

		this.menuItemEdit.setVisible(false);
		this.menuItemRemove.setVisible(false);
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			if (!(this.toolBar.getComponent(i) instanceof KDWorkButton)) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnAddNew")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSave")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnPrint")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnPrintPreview")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("cancel")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnTraceUp")) {
				this.btnTraceUp.setEnabled(true);
				this.btnTraceUp.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnTraceDown")) {
				this.btnTraceDown.setEnabled(true);
				this.btnTraceDown.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCreateFrom")) {
				//continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCreateTo")) {
				this.btnCreateTo.setVisible(true);
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnBegin")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnEnd")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSaveWeigh")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnCancel")) {
				this.btnCancel.setVisible(true);
				this.btnCancel.setEnabled(true);
				this.btnCancel.setToolTipText("禁用");
				continue;
			}
			this.toolBar.getComponent(i).setVisible(false);
		}

		btnBeginRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					beginComReaderNew();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEndRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//stopComReader();
				stopComReaderNew(false);
			}
		});
		this.toolBar.add(btnBeginRead);
		this.toolBar.add(btnEndRead);
		this.cmbQueryBillStatus.addItem("全部");
		this.cmbQueryBillStatus.setSelectedIndex(-1);
		
		//是否临时车辆改变事件 add 20150730
		this.txtCarNum.setRequired(true);
		this.chkIsTemp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isTempChanged();
			}});
		
		this.btnCreateFrom.setVisible(true);
		
		
		this.btnShowOrder.setText("...");
		this.lblOrderQty.setText(" ");
		
		this.kdtDetail.getStyleAttributes().setLocked(true);
		this.kdtDetail.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		
		txtOrderNum.addFocusListener(new FocusListener(){  
			   public void focusLost(FocusEvent arg0) {  
			    try{ 
			    	orderFocusLost = true;
			    	btnShowOrder_actionPerformed(null);  
			    }catch(Exception e){  
			         handUIException(e);  
			    } finally{
			    	orderFocusLost=false;
			    }
			   };  
			   public void focusGained(FocusEvent arg0) {  
			    // TODO 自动生成方法存根  
			      
			   }  
			  });  
	}
	
	protected void btnShowOrder_actionPerformedOld(ActionEvent e) throws Exception {
		String orderNum=this.txtOrderNum.getText();
		if(StringUtils.isBlank(orderNum)) {
			MsgBox.showWarning("请输入正确的订单号！");
			return;
		}
		//载入订单转换成的过磅单
		BTPTransformResult tmp=OrderSelectUI.dealOrder(OrderSelectUI.SaleOrder_Value,orderNum);
		if(tmp!=null) {
			this.editData = (OutStorageBillInfo) tmp.getBills().getObject(0);
//			if(this.editData.getSupplier()!=null) {
//				this.editData.setSupplier(SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(this.editData.getSupplier().getId())));
//			}
			this.setMakeRelations(tmp.getBOTRelationCollection());
			LoadFields(null);
		}
	}
	
	/**
	 * 根据输入的订单号显示订单内容
	 */
	protected void btnShowOrder_actionPerformed(ActionEvent e) throws Exception {
		if(e!=null&&orderFocusLost) {
			return;
		}
		String orderNum=this.txtOrderNum.getText();
		String carnumber = this.txtCarNum.getText();
//		if(StringUtils.isBlank(orderNum) && StringUtils.isBlank(carnumber)) {
//			/*MsgBox.showWarning("请至少输入订单号或者车牌号至少一个值进行查询");
//			return;*/
//		}else{
		if(true) {
			try{
				Date currDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(currDate);
				cal.add(Calendar.DATE, -2);
				Date beginDate = cal.getTime();
				String beginDateStr = sdf.format(beginDate);

				cal.setTime(currDate);
				cal.add(Calendar.DATE, 2);
				String endDateStr = sdf.format(cal.getTime());
				
				Map<String,OrderWeightInfo> orderMaps = weightbridgeFacadeFactory.getRemoteInstance().getSaleorderInfoByNumber(orderNum,carnumber,beginDateStr,endDateStr);
//				if(orderMaps != null && orderMaps.size() >0 ){
					// 获取要过磅的订单
					ArrayList<OrderWeightInfo> orderInfoList = getWeightOrder(orderMaps);
					if(orderInfoList != null&&orderInfoList.size()>0){
						// 生成 入库过磅单
						if(this.editData==null) {
							this.setOprtState(OprtState.ADDNEW);
						}else{
							this.setOprtState(OprtState.EDIT);
						}
						this.editData = getNewWeightInBill(this.editData,orderInfoList);
						// 加载入库过磅单内容
						this.LoadFields(null);
						/*if(orderInfoList.size()==1) {
							MaterialInfo materialInfo = new MaterialInfo();
							materialInfo.setId(BOSUuid.read(orderInfoList.get(0).getMaterialID()));
							materialInfo.setNumber(orderInfoList.get(0).getMaterialNumber());
							materialInfo.setName(orderInfoList.get(0).getMaterialName());
							this.prmtMaterial.setValue(materialInfo);
						}*/
					}
//				}else{
//					MsgBox.showWarning("订单号未查询到 订单信息，请核对");
////					this.txtOrderNum.requestFocus();
//				}
			}catch(BOSException bose){
				bose.printStackTrace();
				MsgBox.showWarning(bose.getMessage());
//				this.txtOrderNum.requestFocus();
			}finally{
				orderFocusLost=false;
			}
		}
		orderFocusLost=false;
	}
	/**
	 * 如果只有一条  则直接返回 否则弹出过滤界面 由用户选择
	 * @param orderMaps
	 * @return
	 * @throws UIException 
	 */
	private ArrayList<OrderWeightInfo> getWeightOrder(Map<String,OrderWeightInfo> orderMaps) throws UIException{
//		if(orderMaps != null && orderMaps.size() > 0){
			// 只有一条时  直接返回  否则弹出界面选择，或者重新查询
			if(orderMaps != null &&orderMaps.size() == 1){
				ArrayList<OrderWeightInfo> orderInfoList=new ArrayList<OrderWeightInfo>();
				orderInfoList.add((OrderWeightInfo) orderMaps.values().toArray()[0]);
				return orderInfoList;
			}
			if(orderMaps == null || orderMaps.size() != 1){
				String searchOrderNum = this.txtOrderNum.getText();
//				Date endDate = new Date();
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(endDate);
//				cal.add(Calendar.DATE, -1);
//				Date beginDate = cal.getTime();
				Date currDate = new Date();
				UIContext uiContext = new UIContext(ui);
		    	uiContext.put("searchOrderNum", searchOrderNum);
		    	uiContext.put("orderMaps", orderMaps);
		    	uiContext.put("currDate", currDate);
		    	uiContext.put("orderType", SelectSourceOrderUI.SALE_ORDER);
		    	IUIWindow window = null;
		    	window = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.SelectSaleOrderUI", uiContext, null, OprtState.ADDNEW);
		    	window.show();
		    	Map selectUICtx = window.getUIObject().getUIContext();
		    	
		    	if(selectUICtx != null){
		    		return (ArrayList<OrderWeightInfo> ) selectUICtx.get("orderInfoList");
		    	}
			}
//		}
		
		return null;
	}
	/**
	 * 根据订单组装 如果过磅单 生成新单据
	 * @return
	 */
	private OutStorageBillInfo getNewWeightInBill(OutStorageBillInfo oldInfo,ArrayList<OrderWeightInfo> orderInfoList){
		orderBaseQty=BigDecimal.ZERO;//orderInfo.getOrderBaseQty();
		orderBagQty=BigDecimal.ZERO;//orderInfo.getBagQty();
		for(OrderWeightInfo tempInfo:orderInfoList) {
			orderBaseQty=orderBaseQty.add(tempInfo.getOrderBaseQty());
			orderBagQty=orderBagQty.add(tempInfo.getBagQty());
		}
		
		OutStorageBillInfo inStorageBillInfo = null;
		OutStorageBillEntryInfo entryInfo=null;
		if(oldInfo!=null) {
			inStorageBillInfo=oldInfo;
			if(oldInfo.getEntrys().size()>0) {
				entryInfo=oldInfo.getEntrys().get(0);
			}else{
				entryInfo=new OutStorageBillEntryInfo();
			}
		}else{
			inStorageBillInfo=new OutStorageBillInfo();
			inStorageBillInfo.setId(BOSUuid.create(inStorageBillInfo.getBOSType().toString()));//
			inStorageBillInfo.setNumber(getAutoNumberByOrg("NONE"));
			inStorageBillInfo.setCompany(SysContext.getSysContext().getCurrentFIUnit());
			inStorageBillInfo.setBizDate((Date) this.dpBizDate.getValue());
			inStorageBillInfo.setBillStatus(WeighBaseStatus.save);
			inStorageBillInfo.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
			inStorageBillInfo.setWeighman(SysContext.getSysContext().getCurrentUserInfo().getPerson());
			
			inStorageBillInfo.setWeighType(WeighBaseType.Tare2Gross);
			inStorageBillInfo.setBizType(WeighBizType.Sale);
			
			inStorageBillInfo.setCar((CarInfo) this.prmtCar.getValue());
			inStorageBillInfo.setCarNum(this.txtCarNum.getText());

			Date date = new Date();
			inStorageBillInfo.setInTime(date);
			inStorageBillInfo.setOutTime(date);
			
			entryInfo=new OutStorageBillEntryInfo();
			inStorageBillInfo.getEntrys().add(entryInfo);
		}
		/*SupplierInfo supplierInfo = new SupplierInfo();
		supplierInfo.setId(BOSUuid.read(orderInfo.getCusSuppID()));
		supplierInfo.setNumber(orderInfo.getCusSuppNumber());
		supplierInfo.setName(orderInfo.getCusSuppName());*/
		
		
//		inStorageBillInfo.setSupplier(null);
		
		//add by dai 
		if(entryInfo.getDetail().size()>0) {
			entryInfo.getDetail().clear();
		}
		String materialIDKeep=null,customerIDKeep=null;
		boolean isSameM=true,isSameC=true;
		for(OrderWeightInfo tempInfo:orderInfoList) {
			OutStorageBillEntryDetailInfo detailInfo=new OutStorageBillEntryDetailInfo();
			detailInfo.setSourceBillID(tempInfo.getOrderID());
			detailInfo.setSourceBillNum(tempInfo.getOrderNumber());
			detailInfo.setSourceEntryID(tempInfo.getEntryID());
			detailInfo.setSourceEntryQty(tempInfo.getOrderBaseQty());
			detailInfo.setSourceEntryBag(tempInfo.getBagQty());
			detailInfo.setMaterialNum(tempInfo.getMaterialNumber());
			detailInfo.setMateiralName(tempInfo.getMaterialName());
			detailInfo.setCustomerNum(tempInfo.getCusSuppNumber());
			detailInfo.setCustomerName(tempInfo.getCusSuppName());
			entryInfo.getDetail().add(detailInfo);
			
			if(customerIDKeep==null){
				customerIDKeep=tempInfo.getCusSuppID();
			}else {
				if(!customerIDKeep.equals(tempInfo.getCusSuppID())) {
					isSameC=false;
				}
			}
			if(materialIDKeep==null){
				materialIDKeep=tempInfo.getMaterialID();
			}else {
				if(!materialIDKeep.equals(tempInfo.getCusSuppID())) {
					isSameM=false;
				}
			}
		}
		
		
		
		if(isSameC) {
			CustomerInfo customerInfo=new CustomerInfo();
			customerInfo.setId(BOSUuid.read(orderInfoList.get(0).getCusSuppID()));
			customerInfo.setNumber(orderInfoList.get(0).getCusSuppNumber());
			customerInfo.setName(orderInfoList.get(0).getCusSuppName());
			inStorageBillInfo.setCustomer(customerInfo);
		}else{
			inStorageBillInfo.setCustomer(null);
		}
//		if(isSameM) {
//			MaterialInfo materialInfo = new MaterialInfo();
//			materialInfo.setId(BOSUuid.read(orderInfoList.get(0).getMaterialID()));
//			materialInfo.setNumber(orderInfoList.get(0).getMaterialNumber());
//			materialInfo.setName(orderInfoList.get(0).getMaterialName());
//			inStorageBillInfo.getEntrys().get(0).setMaterial(materialInfo);
//		}else {
//			inStorageBillInfo.getEntrys().get(0).setMaterial(null);
//		}
		
		// add end
//		inStorageBillInfo.setPurOrderNumber(orderInfo.getOrderNumber());
		return inStorageBillInfo;
	}
	

	//是否临时车辆改变事件
	private void isTempChanged(){
		if(this.chkIsTemp.isSelected()) {//选中
			this.prmtCar.setValue(null);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}else {
			this.txtCarNum.setText(null);
			this.contCar.setVisible(true);
			this.contCarNum.setVisible(false);
		}
	};
	
	
	public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception {
		this.setOprtState(STATUS_ADDNEW);
		this.billEdit.createFrom(getMainOrgContext());
		try{
			IObjectCollection destBillCols = (IObjectCollection) this.getUIContext().get("destBillCols");
			if(destBillCols!=null&&destBillCols.size()>0) {
				String entryID=null;
				OutStorageBillInfo head = (OutStorageBillInfo) destBillCols.getObject(0);
				if(head.getEntrys().size()>0) {
					entryID=head.getEntrys().get(head.getEntrys().size()-1).getId().toString();
				}
				this.editData=head;
				
			/*	if(info.getEntrys().size()>1) {//生成了多条分录
					InStorageBillEntryCollection entryInfosClone = (InStorageBillEntryCollection) info.getEntrys().clone();
					for(int i=1;i<info.getEntrys().size();i++) {//删除>第一条分录
						
						info.getEntrys().removeObject(i);
					}
					for(int i=1;i<entryInfosClone.size();i++){
					}
					BOTRelationCollection mr = getMakeRelations();
					for(int i=0;i<mr.size();i++) {
						mr.get(i).setDestEntityID();
					}
				}*/
				
				//setNowBillInfo(billID);
				//this.detailCol.sort("sourceBillNum");//根据来源单据编码排序
				
				this.LoadFields(null);
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		billEdit.CreateTo(this.editData);
	}

	
	public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		this.billEdit.traceDown(editData);
	}

	
	public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData==null||this.editData.getId()==null) {
			return;
		}
		this.billEdit.traceUp(editData);
	}
	
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData==null||this.editData.getId()==null)
			return;
		if(MsgBox.showConfirm2("是否作废过榜单？")==MsgBox.OK) {
			IObjectPK pk = new ObjectUuidPK(this.editData.getId());
			getBizInterface().cancel(pk, this.editData);
			MsgBox.showInfo("作废完成");
		}
		this.execQuery();
	}

	/**
	 * 目测扣杂改变 计算净重
	 */
	private void impirityChanged(DataChangeEvent e) {
		BigDecimal tare = this.txtTare.getBigDecimalValue();
		if(tare==null) {
			tare=BigDecimal.ZERO;
		}
		BigDecimal gross = this.txtGross.getBigDecimalValue();
		if(gross==null) {
			gross=BigDecimal.ZERO;
		}
		BigDecimal imprity =BigDecimal.ZERO;
		if(e.getNewValue()!=null) {
			imprity=new BigDecimal(e.getNewValue().toString());
		}
		BigDecimal tare2 = this.txtTare2.getBigDecimalValue();
		if(tare2==null) {
			tare2=BigDecimal.ZERO;
		}
		if (this.rdoTare2Gross2Tare.isSelected())
			this.txtSuttle.setValue((gross.subtract(tare2)).subtract(imprity));
		else
			this.txtSuttle.setValue((gross.subtract(tare)).subtract(imprity));
	}

	/**
	 * 业务类型改变 客户/库存组织 改变
	 * 
	 * @param e
	 */
	private void cmbBizType_changed(ActionEvent e) {
		if (this.cmbBizType.getSelectedItem().equals(WeighBizType.Sale)) {
			this.contCustomer.setVisible(true);
			this.prmtOrderStorageOrgUnit.setValue(null);
			this.contOrderStorageOrgUnit.setVisible(false);
			
			this.rdoTare2Gross.setSelected(true);
			this.rdoGross2Tare.setSelected(false);
		} else if (this.cmbBizType.getSelectedItem().equals(WeighBizType.TransOut)||this.cmbBizType.getSelectedItem().equals(WeighBizType.GroupSale)) {
			this.prmtCustomer.setValue(null);
			this.contCustomer.setVisible(false);
			this.contOrderStorageOrgUnit.setVisible(true);
			
			this.rdoTare2Gross.setSelected(true);
			this.rdoGross2Tare.setSelected(false);
		}else if(this.cmbBizType.getSelectedItem().equals(WeighBizType.Other)){
			this.rdoTare2Gross.setSelected(false);
			this.rdoGross2Tare.setSelected(true);
			this.prmtMaterial.setRequired(false);
		}else if(this.cmbBizType.getSelectedItem().equals(WeighBizType.WasteSale)){
			this.rdoTare2Gross.setSelected(true);
			this.rdoGross2Tare.setSelected(false);
		}else if(this.cmbBizType.getSelectedItem().equals(WeighBizType.Chicken)){
			this.contCustomer.setVisible(true);
			this.prmtOrderStorageOrgUnit.setValue(null);
			this.contOrderStorageOrgUnit.setVisible(false);
			
			this.rdoTare2Gross.setSelected(true);
			this.rdoGross2Tare.setSelected(false);
		}
	}

	/**
	 * 车辆改变，带出皮重
	 * 
	 * @param e
	 */
	private void prmtCar_Changed(DataChangeEvent e) {
		if (this.prmtCar.getValue() != null) {
			CarInfo carInfo = (CarInfo) e.getNewValue();
			//this.txtTare.setValue(carInfo.getTare());
			if(carInfo.getCarType().equals(CarType.ownCar)) {
				//this.dpOutTime.setValue(new java.util.Date());
			}else{
				//this.dpInTime.setValue(new java.util.Date());
			}
			this.txtCarNum.setText(carInfo.getNumber());//add 20150730
		} else {
//			this.txtTare.setValue(BigDecimal.ZERO);
			this.txtCarNum.setText(null);
		}
	}

	/**
	 * 加载单据
	 */
	protected void tbList_clicked(KDTMouseEvent e) {
		try {
			if (e.getRowIndex() < 0) {
				MsgBox.showWarning("请选择记录行");
				return;
			}
			IRow row = this.tbList.getRow(e.getRowIndex());

			this.setNewBillInfo( row.getCell("id").getValue().toString());
			this.oprtState=OprtState.EDIT;
			this.LoadFields(null);
			this.setMessageBarText("查看");
		} catch (Exception ee) {
			MsgBox.showError(ee.getMessage());
		}

	}

	/**
	 * 得到業務操作實例
	 * 
	 * @return
	 * @throws BOSException
	 */
	private IOutStorageBill getBizInstance() throws BOSException {
		return OutStorageBillFactory.getRemoteInstance();
	}

	private IOutStorageBillEntry getBizEntryInstance() throws BOSException {
		return OutStorageBillEntryFactory.getRemoteInstance();
	}

	private IOutStorageBillEntryDetail getBizEntryDetailInstance() throws BOSException {
		return OutStorageBillEntryDetailFactory.getRemoteInstance();
	}

	
	protected void btnAllSave_actionPerformed(ActionEvent e) throws Exception {
		btnSave_actionPerformed(e);
	}

	
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		this.btnSave_actionPerformed(e);
	}

	/**
	 * 重置单据对象和界面
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void resetBill() throws Exception {
		orderBaseQty=BigDecimal.ZERO;
		orderBagQty=BigDecimal.ZERO;
		this.orderFocusLost=false;
		this.editData = null;
		this.setOprtState(OprtState.ADDNEW);
		this.LoadFields(null);
		initControlDeafultValue();
		this.setSaved(false);
		this.setMessageBarText("新增");
	}

	/**
	 * 保存事件
	 */
	protected void btnSave_actionPerformed(ActionEvent e) throws Exception {
		this.VerifyInput();
		//this.oldData=this.editData;
		this.StoreFields();
		try {
			IObjectPK pk=null;
			if(editData.getBillStatus().equals(WeighBaseStatus.finish)) {
				pk= this.getBizInstance().submit(editData);
			}else {
				pk = this.getBizInstance().save(this.editData);
			}		
			iBTPManager.saveRelations(this.editData, getMakeRelations());//保存BOTP	
			logger.info("NewInStorageBillID:::::::"+pk);
			this.setSaved(true);
			
			/************************************************wgj add save log start 20160828******************/
			saveWeighLog("出库过磅单-业务过磅");
			/************************************************wgj add save log end   20160828******************/
			
			MsgBox.showInfo("保存成功！");
		} catch (Exception e1) {
			editData.setBillStatus(this.oldBillStatus);
			iBTPManager.removeAllRelation(this.editData);
			throw new BOSException(e1);
		}
		this.setOprtState(OprtState.EDIT);
		this.LoadFields(null);
		this.setMessageBarText("查看");
		execQuery();
	}
	
	public synchronized void LoadFields(HashMap params) throws BOSException, EASBizException {
		isWeighted=false;
		this.removeDataChangeListeners();
		//add by dai 
		orderBagQty=BigDecimal.ZERO;
		orderBaseQty=BigDecimal.ZERO;
		this.kdtDetail.removeRows();
		//add end
		BigDecimal sumSuttle=BigDecimal.ZERO,sumActualSuttle=BigDecimal.ZERO,sumTempSuttle=BigDecimal.ZERO;
		if (editData != null && editData.getId() != null) {
			this.txtNumber.setText(this.editData.getNumber());
			this.dpBizDate.setValue(this.editData.getBizDate());
			this.prmtCar.setValue(editData.getCar());
			this.txtCarNum.setText(editData.getCarNum());//add 20150730
			this.prmtCustomer.setValue(editData.getCustomer());
			this.prmtOrderStorageOrgUnit.setValue(editData.getOrderStorageOrgUnit());
//			this.dpInTime.setValue(editData.getInTime());
//			this.dpOutTime.setValue(editData.getOutTime());
			
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			
			this.cmbBizType.setSelectedItem(editData.getBizType());// 设置业务类型
			this.cmbBillStatus.setSelectedItem(editData.getBillStatus());
			if (editData.getWeighType().equals(WeighBaseType.Tare2Gross)) {// 过磅方式
				this.rdoTare2Gross.setSelected(true);
			} else if (editData.getWeighType().equals(WeighBaseType.Gross2Tare)) {
				this.rdoGross2Tare.setSelected(true);
			} else if (editData.getWeighType().equals(WeighBaseType.Tare2Gross2Tare)) {
				this.rdoTare2Gross2Tare.setSelected(true);
			}
			this.txtRemark.setText(this.editData.getDescription());
			//遍历分录集合、累加净重合计
			OutStorageBillEntryCollection entryCol = this.editData.getEntrys();
//			IMaterial ims = MaterialFactory.getRemoteInstance();
			for(int i=0;i<entryCol.size();i++) {
				if(i==0) {
					this.prmtMaterial.setValue(entryCol.get(i).getMaterial());//!=null?ims.getMaterialInfo(new ObjectUuidPK(entryCol.get(i).getMaterial().getId())):null
					this.txtTare.setValue(entryCol.get(i).getTare());
					this.txtGross.setValue(entryCol.get(i).getGross());
					this.txtTare2.setValue(entryCol.get(i).getTare2());
					
					if(entryCol.get(i).getWeighTime()!=null&&entryCol.get(i).getWeighTimeGross()!=null) {
						if(entryCol.get(i).getWeighTime().before(entryCol.get(i).getWeighTimeGross())) {
							this.dpInTime.setValue(entryCol.get(i).getWeighTime());
							this.dpOutTime.setValue(entryCol.get(i).getWeighTimeGross());
						}else {
							this.dpOutTime.setValue(entryCol.get(i).getWeighTime());
							this.dpInTime.setValue(entryCol.get(i).getWeighTimeGross());
						}
					}else {
						if(entryCol.get(i).getWeighTime()!=null) {
							this.dpInTime.setValue(entryCol.get(i).getWeighTime());
						}else {
							this.dpInTime.setValue(entryCol.get(i).getWeighTimeGross());
						}
					}
					
					//this.txtImpurity.setValue(entryCol.get(i).getImpurity());
					if(entryCol.get(i).getSuttle()!=null) {
						sumSuttle=sumSuttle.add(entryCol.get(i).getSuttle());
					}
					//add@20161030 by dai 
					if(entryCol.get(i).getActualSuttle()!=null) {
						sumActualSuttle=sumActualSuttle.add(entryCol.get(i).getActualSuttle());
					}
					if(entryCol.get(i).getTempSuttle()!=null) {
						sumTempSuttle=sumTempSuttle.add(entryCol.get(i).getTempSuttle());
					}
					//add end
					for(int j=0;j<entryCol.get(i).getDetail().size();j++) {
						if(entryCol.get(i).getDetail().get(j).getSourceEntryQty()!=null)
							orderBaseQty=orderBaseQty.add(entryCol.get(i).getDetail().get(j).getSourceEntryQty());
						if(entryCol.get(i).getDetail().get(j).getSourceEntryBag()!=null)
							orderBagQty=orderBagQty.add(entryCol.get(i).getDetail().get(j).getSourceEntryBag());
						
						IRow row=this.kdtDetail.addRow();
						row.getCell("billNum").setValue(entryCol.get(i).getDetail().get(j).getSourceBillNum());
						//row.getCell("mateiralName").setValue(entryCol.get(i).getDetail().get(j).getMateiralName());
						row.getCell("customerName").setValue(entryCol.get(i).getDetail().get(j).getCustomerName());
						row.getCell("qty").setValue(entryCol.get(i).getDetail().get(j).getSourceEntryQty());
						row.getCell("bagQty").setValue(entryCol.get(i).getDetail().get(j).getSourceEntryBag());
					}
					//add end
				}
			}
			if(entryCol.size()<=0) {
				this.prmtMaterial.setValue(null);
				this.txtTare.setValue(BigDecimal.ZERO);
				this.txtGross.setValue(BigDecimal.ZERO);
				this.txtTare2.setValue(BigDecimal.ZERO);
				this.txtImpurity.setValue(BigDecimal.ZERO);
			}
			this.txtSuttle.setValue(sumSuttle);
			//add@20161030 by dai 
			this.txtActualSuttle.setValue(sumActualSuttle);
			this.txtTempSuttle.setValue(sumTempSuttle);
			
		} else {
			this.txtNumber.setText(null);// ****获取新的单据编码？
			this.dpBizDate.setValue(new java.util.Date());
			this.prmtCar.setValue(null);
			this.txtCarNum.setText(null);
			if(params!=null) {
				this.prmtCar.setValue(params.get("carInfo"));
				this.txtCarNum.setText(((CoreBaseInfo) params.get("carInfo")).getString("number"));
			}
			this.prmtMaterial.setValue(null);
			this.prmtCustomer.setValue(null);
			this.prmtOrderStorageOrgUnit.setValue(null);
			this.dpInTime.setValue(null);
			this.dpOutTime.setValue(null);
			this.cmbBillStatus.setSelectedItem(null);
			this.txtTare.setValue(BigDecimal.ZERO);
			this.txtGross.setValue(BigDecimal.ZERO);
			this.txtSuttle.setValue(BigDecimal.ZERO);
			this.txtActualSuttle.setValue(BigDecimal.ZERO);
			this.txtTare2.setValue(BigDecimal.ZERO);
			this.txtImpurity.setValue(BigDecimal.ZERO);
			this.txtRemark.setText(null);
			this.txtOrderNum.setText(null);
		}
		selectControlLocked();
		this.addDataChangeListeners();
		this.lblOrderQty.setText(orderBaseQty.setScale(2,BigDecimal.ROUND_HALF_UP)+"kg "+orderBagQty.setScale(2,BigDecimal.ROUND_HALF_UP)+"包");
		this.lblSuttleDiff.setText(sumActualSuttle.subtract(sumSuttle).setScale(2, BigDecimal.ROUND_HALF_UP)+"kg");
		//setOrderQty();
		
//		txtNumber.setEnabled(true);
//		this.txtNumber.addFocusListener(new FocusListener(){  
//			   public void focusLost(FocusEvent e) {  
//			    try{  
////			    	MsgBox.showInfo(txtNumber.getText());
//			    }catch(Exception ex){  
//			         handUIException(ex);  
//			    }  
//			   };  
//			   public void focusGained(FocusEvent arg0) {  
//			    // TODO 自动生成方法存根  
//			      
//			   }  
//			  }); 
		
	}
	/**
	 * 设置销售订单数量
	 */
	private void setOrderQty() {
		if(this.editData==null) {
			return;
		}
		String entryBosType,entryID;
		BigDecimal sumQty=BigDecimal.ZERO;
		for(int i=0;i<this.editData.getEntrys().size();i++) {
			for(int j=0;j<this.editData.getEntrys().get(i).getDetail().size();j++) {
				entryBosType=this.editData.getEntrys().get(i).getDetail().get(j).getSourceEntryBosType();
				entryID =this.editData.getEntrys().get(i).getDetail().get(j).getSourceEntryID();
				sumQty=sumQty.add(getQtyByEntryID(entryID));
			}
		}
		this.lblOrderQty.setText(sumQty.setScale(4,BigDecimal.ROUND_HALF_UP).toString());
	}
	
	private BigDecimal getQtyByEntryID(String entryID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(FQty,0) Fqty")
			.append(" from t_sd_saleOrderEntry ")
			.append(" where fid='").append(entryID).append("'")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				return rs.getBigDecimal("Fqty");
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * 删除监听器
	 */
	private void removeDataChangeListeners() {
		this.prmtCar.removeDataChangeListener(carDataChangeListener);
		this.txtImpurity.removeDataChangeListener(imputityDataChangeListener);
	}
	/**
	 * 车辆改变事件
	 */
	private class carDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			prmtCar_Changed(e);
		}
	}
	/**
	 * 杂质改变事件
	 */
	private class imputityDataChangeListenerClass implements DataChangeListener {
		public void dataChanged(DataChangeEvent e) {
			impirityChanged(e);
		}
	}
	/*
	 /* 
	 * 增加监听器
	 */
	private void addDataChangeListeners(){
		this.prmtCar.addDataChangeListener(carDataChangeListener);	
		this.txtImpurity.addDataChangeListener(imputityDataChangeListener);
	}
	/**
	 * 得到当前分录对象
	 * 
	 * @param entryID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void setNewBillInfo(String billID) throws EASBizException, BOSException {
		editData = null;
		if (StringUtils.isBlank(billID)) {
			editData = new OutStorageBillInfo();
			editData.setId(BOSUuid.create(editData.getBOSType().toString()));
			editData.setNumber(getAutoNumberByOrg("NONE"));
			editData.setCompany(SysContext.getSysContext().getCurrentFIUnit());
			editData.setId(BOSUuid.create(editData.getBOSType().toString()));
			editData.setBizDate((Date) this.dpBizDate.getValue());
			editData.setBillStatus(WeighBaseStatus.save);
			editData.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
			editData.setWeighman(SysContext.getSysContext().getCurrentUserInfo().getPerson());
		} else {
			SelectorItemCollection slors = new SelectorItemCollection();
			slors.add(new SelectorItemInfo("*"));
			slors.add(new SelectorItemInfo("car.*"));
			slors.add(new SelectorItemInfo("customer.*"));
			slors.add(new SelectorItemInfo("orderStorageOrgUnit.*"));
			slors.add(new SelectorItemInfo("entrys.*"));
			slors.add(new SelectorItemInfo("entrys.material.*"));
			slors.add(new SelectorItemInfo("entrys.Detail.*"));
			editData = this.getBizInstance().getOutStorageBillInfo(new ObjectUuidPK(billID), slors);
		}
	}

	/**
	 * 设置控件默认值
	 */
	private synchronized void initControlDeafultValue() {
//		this.dpInTime.setValue(new java.util.Date());
		if (this.initParams.get("weighBizType") != null) {// 默认业务类型 
			this.cmbBizType.setSelectedItem(WeighBizType.getEnum(this.initParams.get("weighBizType").toString()));// 设置默认值
			this.cmbBizType_changed(null);
		}

		if (this.initParams.get("weighBaseType") != null) {// 默认过磅方式
			String weighType=this.initParams.get("weighBaseType").toString();
			if(weighType.equalsIgnoreCase(WeighBaseType.Tare2Gross.getValue())) {
				this.rdoTare2Gross.setSelected(true);
			}else if(weighType.equalsIgnoreCase(WeighBaseType.Gross2Tare.getValue())) {
				this.rdoGross2Tare.setSelected(true);
			}else{
				this.rdoTare2Gross2Tare.setSelected(true);
			}
		}
		this.cmbIsAuto2Inv.setSelected((Boolean) initParams.get("isAutoCreateToInvBill"));
		//设置默认物料
		if(this.initParams.get("materialSet")!=null) {
			HashSet set=(HashSet) this.initParams.get("materialSet");
			if(set.size()==1) {
				try {
					Iterator it = set.iterator();
					this.prmtMaterial.setValue(MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK((String) it.next())));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}

	/*
	 * 设置控件的锁定状态
	 */
	private void selectControlLocked() {
		Boolean flag = true;
		this.btnShowOrder.setEnabled(true);
		if (this.editData != null && this.editData.getId() != null) {
			//flag = false;
			if(editData.getBillStatus()!=null&&!editData.getBillStatus().equals(WeighBaseStatus.save)) {//保存状态单据可修改
				flag=false;
			}
			if (editData.getBillStatus().equals(WeighBaseStatus.finish)||editData.getBillStatus().equals(WeighBaseStatus.qcFinish)||editData.getBillStatus().equals(WeighBaseStatus.audit)) {// 已经完成锁定过磅
				this.txtImpurity.setEnabled(false);
				this.btnWeight.setEnabled(false);
				this.btnSave.setEnabled(false);
				this.btnAllSave.setEnabled(false);
				this.txtRemark.setEnabled(false);
//				this.dpOutTime.setEnabled(false);
//				this.dpInTime.setEnabled(false);
				
				this.cmbBizType.setEnabled(false);
				this.rdoTare2Gross.setEnabled(false);
				this.rdoGross2Tare.setEnabled(false);
				this.rdoTare2Gross2Tare.setEnabled(false);
				
				//******add 20150504
				this.prmtCustomer.setEnabled(false);
				this.prmtOrderStorageOrgUnit.setEnabled(false);
				this.prmtMaterial.setEnabled(false);
				this.cmbIsAuto2Inv.setEnabled(false);
				this.txtOrderNum.setEnabled(false);
				this.btnShowOrder.setEnabled(false);
			} else {
				this.txtImpurity.setEnabled(true);
				this.btnWeight.setEnabled(true);
				this.btnSave.setEnabled(true);
				this.btnAllSave.setEnabled(true);	
				this.txtRemark.setEnabled(true);
//				this.dpOutTime.setEnabled(true);
//				this.dpInTime.setEnabled(true);
				
				this.cmbBizType.setEnabled(true);
				
				Boolean xx=false;
				if(oprtState.equals(OprtState.ADDNEW)) {
					xx=true;
				}
				this.rdoTare2Gross.setEnabled(xx);
				this.rdoGross2Tare.setEnabled(xx);
				this.rdoTare2Gross2Tare.setEnabled(xx);
				
				
				//******add 20150504
				this.prmtCustomer.setEnabled(true);
				this.prmtOrderStorageOrgUnit.setEnabled(true);
				this.prmtMaterial.setEnabled(true);
				this.cmbIsAuto2Inv.setEnabled(true);
				this.txtOrderNum.setEnabled(true);
			}
		} else {
			this.txtImpurity.setEnabled(true);
			this.btnWeight.setEnabled(true);
			this.btnSave.setEnabled(true);
			this.btnAllSave.setEnabled(true);
//			this.dpInTime.setEnabled(true);
//			this.dpOutTime.setEnabled(true);
			this.txtRemark.setEnabled(true);
			
			this.cmbBizType.setEnabled(true);
			this.rdoTare2Gross.setEnabled(true);
			this.rdoGross2Tare.setEnabled(true);
			this.rdoTare2Gross2Tare.setEnabled(true);	
			
			//******add 20150504
			this.prmtCustomer.setEnabled(true);
			this.prmtOrderStorageOrgUnit.setEnabled(true);
			this.prmtMaterial.setEnabled(true);
			this.cmbIsAuto2Inv.setEnabled(true);
			this.txtOrderNum.setEnabled(true);
		}

		//modify 20150912
		/*this.cmbBizType.setEnabled(flag);
		this.rdoTare2Gross.setEnabled(flag);
		this.rdoGross2Tare.setEnabled(flag);
		this.rdoTare2Gross2Tare.setEnabled(flag);*/
		
		this.chkIsTemp.setEnabled(flag);//add 20150730
		this.txtCarNum.setEnabled(flag);
		
		if(this.editData != null && this.editData.getId() != null&&editData.getCar()==null) {
			this.chkIsTemp.setSelected(true);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
			
		}else {
			this.chkIsTemp.setSelected(true);
			this.contCar.setVisible(false);
			this.contCarNum.setVisible(true);
		}

		this.prmtCar.setEnabled(flag);
//		this.prmtCustomer.setEnabled(flag);
//		this.prmtOrderStorageOrgUnit.setEnabled(flag);
//		this.prmtMaterial.setEnabled(flag);
//		this.cmbIsAuto2Inv.setEnabled(flag);
		
		this.btnTraceUp.setEnabled(true);
		this.btnTraceDown.setEnabled(true);
		
		this.dpOutTime.setEnabled(false);
		this.dpInTime.setEnabled(false);
		
	}

	/**
	 * 给对象赋值
	 * 
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws SQLException
	 */
	public void StoreFields() throws EASBizException, BOSException, SQLException {
		if (editData == null || editData.getId() == null) {
			this.setNewBillInfo(null);
		}
		this.oldBillStatus=editData.getBillStatus();//保存旧的单据状态，保存失败不至于状态混乱
		if(StringUtils.isBlank(editData.getNumber())) {
			editData.setNumber(getAutoNumberByOrg("NONE"));
		}
//		editData.setInTime((Date) this.dpInTime.getValue());
//		editData.setOutTime((Date) this.dpOutTime.getValue());
		editData.setCar((CarInfo) this.prmtCar.getValue());
		editData.setCarNum(this.txtCarNum.getText());//add 20150730
		editData.setTareWeight(this.txtTare.getBigDecimalValue());
		editData.setBizType((WeighBizType) this.cmbBizType.getSelectedItem());
		editData.setCustomer((CustomerInfo) this.prmtCustomer.getValue());
		editData.setDescription(this.txtRemark.getText());
		if(editData.getStorageOrgUnit()==null) {
			editData.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		}
		StorageOrgUnitInfo storageUnit = (StorageOrgUnitInfo) this.prmtOrderStorageOrgUnit.getValue();
		editData.setOrderStorageOrgUnit(storageUnit);
		if(storageUnit!=null) {
			try{
				editData.setOrderComopany(CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(WeighbridgeCommUtils.getOrgIDByRelation(storageUnit.getId().toString(), 4, 1))));
			}catch(Exception e){e.printStackTrace();}
		}
		
		if (this.rdoTare2Gross.isSelected()) {
			editData.setWeighType(WeighBaseType.Tare2Gross);
		}
		if (this.rdoGross2Tare.isSelected()) {
			editData.setWeighType(WeighBaseType.Gross2Tare);
		}
		if (this.rdoTare2Gross2Tare.isSelected()) {
			editData.setWeighType(WeighBaseType.Tare2Gross2Tare);
		}

		String timeFlag="weighTime";
		if (this.rdoTare2Gross.isSelected()) {// 皮重-毛重
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.tare);
				timeFlag="weighTime";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.tare)&&!isSaveTemp) {
				editData.setBillStatus(WeighBaseStatus.finish);
				 timeFlag="weighTimeGross";
			}
		}
		if (this.rdoGross2Tare.isSelected()) {// 毛重-皮重
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.gross);
				timeFlag="weighTimeGross";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)&&!isSaveTemp) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTime";
			}
		}
		if (this.rdoTare2Gross2Tare.isSelected()) {// 皮重-毛重-皮重
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				editData.setBillStatus(WeighBaseStatus.tare);
				timeFlag="weighTime";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
				editData.setBillStatus(WeighBaseStatus.gross);
				timeFlag="weighTimeGross";
			} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)&&!isSaveTemp) {
				editData.setBillStatus(WeighBaseStatus.finish);
				timeFlag="weighTime2";
			}
		}

		BigDecimal suttleQty=this.txtSuttle.getBigDecimalValue();
		if(suttleQty==null)
			suttleQty=BigDecimal.ZERO;
		if (this.editData.getEntrys().size() <= 0) {
			OutStorageBillEntryInfo entryInfo = new OutStorageBillEntryInfo();
			entryInfo.setMaterial((MaterialInfo) this.prmtMaterial.getValue());
			if( this.prmtMaterial.getValue()!=null) {
				entryInfo.setMateiralName(((MaterialInfo) this.prmtMaterial.getValue()).getName());
				entryInfo.setModel(((MaterialInfo) this.prmtMaterial.getValue()).getModel());
				entryInfo.setUnit(((MaterialInfo) this.prmtMaterial.getValue()).getBaseUnit());
			}
			entryInfo.setDate(timeFlag, new java.util.Date());
			entryInfo.setTare(this.txtTare.getBigDecimalValue());
			entryInfo.setTare2(this.txtTare2.getBigDecimalValue());
			entryInfo.setGross(this.txtGross.getBigDecimalValue());
			//entryInfo.setImpurity(this.txtImpurity.getBigDecimalValue());
			entryInfo.setSuttle(suttleQty);
			entryInfo.setActualSuttle(this.txtActualSuttle.getBigDecimalValue());
			entryInfo.setSuttleDiff(this.txtActualSuttle.getBigDecimalValue().subtract(suttleQty));
			entryInfo.setTempSuttle(this.txtTempSuttle.getBigDecimalValue());
			this.editData.getEntrys().add(entryInfo);
		} else {				
			BigDecimal tempQty, weighQty, remainQty,orderQty,entryAddQty;
			remainQty = suttleQty;
			for (int i = 0; i < this.editData.getEntrys().size(); i++) {
				this.editData.getEntrys().get(i).setMaterial((MaterialInfo) this.prmtMaterial.getValue());
				if( this.prmtMaterial.getValue()!=null) {
					this.editData.getEntrys().get(i).setMateiralName(((MaterialInfo) this.prmtMaterial.getValue()).getName());
					this.editData.getEntrys().get(i).setModel(((MaterialInfo) this.prmtMaterial.getValue()).getModel());
					this.editData.getEntrys().get(i).setUnit(((MaterialInfo) this.prmtMaterial.getValue()).getBaseUnit());
				}
				this.editData.getEntrys().get(i).setDate(timeFlag, new java.util.Date());
				/***********************wgj add 校验两次过磅时间 不能间隔太短？是否需要单独校验？**************************/
				Date weighTime = this.editData.getEntrys().get(i).getWeighTime();
				Date weighTime2 = this.editData.getEntrys().get(i).getWeighTime2();
				Date weighTimeGross = this.editData.getEntrys().get(i).getWeighTimeGross();
				 
//				boolean isTooShort = WeighbridgeCommUtils.isWeightTimeTooShort(weighTime, weighTime2, weighTimeGross, WeighbridgeCommUtils.shortestMinutesBetweenTwoWeigh);
//				if(isTooShort && MsgBox.showConfirm2("该车次两次过磅间隔少于10分钟，是否误操作，如果误操作请点击否") != MsgBox.YES){
//					SysUtil.abort();
//				}
				/***********************wgj add 校验两次过磅时间 不能间隔太短**************************/
				
				this.editData.getEntrys().get(i).setTare(this.txtTare.getBigDecimalValue());
				this.editData.getEntrys().get(i).setTare2(this.txtTare2.getBigDecimalValue());
				this.editData.getEntrys().get(i).setGross(this.txtGross.getBigDecimalValue());
				//this.editData.getEntrys().get(i).setImpurity(this.txtImpurity.getBigDecimalValue());
				this.editData.getEntrys().get(i).setSuttle(suttleQty);
				this.editData.getEntrys().get(i).setActualSuttle(this.txtActualSuttle.getBigDecimalValue());
				this.editData.getEntrys().get(i).setSuttleDiff(this.txtActualSuttle.getBigDecimalValue().subtract(suttleQty));
				if(editData.getBillStatus().equals(WeighBaseStatus.finish)) {
					this.editData.getEntrys().get(i).setTempSuttle(null);
				}else {
					this.editData.getEntrys().get(i).setTempSuttle(this.txtTempSuttle.getBigDecimalValue());
				}
				
				//modify by dai @20161030
				/*entryAddQty=BigDecimal.ZERO;
				OutStorageBillEntryDetailCollection detailCol = this.editData.getEntrys().get(i).getDetail();
				for (int j = 0; j < detailCol.size(); j++) {
					//已过磅数量
					weighQty = WeighbridgeCommUtils.getWeighQty(detailCol.get(j).getSourceBillID(),detailCol.get(j).getSourceEntryID());
					//订单数量
					orderQty= detailCol.get(j).getSourceEntryQty();
					if(orderQty==null) 
						orderQty=BigDecimal.ZERO;
					// 剩余需过磅数量
					tempQty = orderQty.subtract(weighQty);
					if (remainQty.compareTo(tempQty) > 0) {
						detailCol.get(j).setWeighQty(tempQty);
						detailCol.get(j).setWeighQty(tempQty);
						entryAddQty=entryAddQty.add(tempQty);
						remainQty = remainQty.subtract(tempQty);
					} else if (remainQty.compareTo(tempQty) <= 0) {
						detailCol.get(j).setWeighQty(remainQty);
						detailCol.get(j).setWeighQty(remainQty);
						entryAddQty=entryAddQty.add(remainQty);
						remainQty = BigDecimal.ZERO;
					}
				}
				if(detailCol.size()<=0)
					entryAddQty=suttleQty;
				this.editData.getEntrys().get(i).setSuttle(entryAddQty);*/
			}
		}
	}
	
	
	
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		this.execQuery();
		this.resetBill();
	}

	
	public void onShow() throws Exception {
		super.onShow();
		this.execQuery();
		this.resetBill();
	}
	/**
	 * 输入数据合法性校验
	 */
	protected void VerifyInputWhenFinish() throws Exception {
		if (this.prmtMaterial.getValue() == null) {
//			this.editData.setBillStatus(oldBillStatus);
			/*MsgBox.showWarning("物料不能为空！");
			SysUtil.abort();*/
		}
		if (this.cmbBizType.getSelectedItem().equals(WeighBizType.Sale)) {
			if (this.prmtCustomer.getValue() == null&&this.kdtDetail.getRowCount()<=0) {
				this.editData.setBillStatus(oldBillStatus);
				MsgBox.showWarning("请选择订单(订单过磅)或者客户不能为空(无源单过磅)！");
				SysUtil.abort();
			}
		} else {
//			if (this.prmtOrderStorageOrgUnit.getValue() == null) {
////				this.editData.setBillStatus(oldBillStatus);
//				MsgBox.showWarning("目标库存组织不能为空！");
//				SysUtil.abort();
//			}
		}
	}
	/**
	 * 输入数据合法性教研
	 */
	protected void VerifyInput() throws Exception {
		//test
		//this.txtSuttle.setValue(new BigDecimal(99));
		if (!this.chkIsTemp.isSelected()&&this.prmtCar.getValue() == null) {
			MsgBox.showWarning("车辆不能为空！");
			SysUtil.abort();
		}
		if (this.chkIsTemp.isSelected()&&StringUtils.isBlank(this.txtCarNum.getText())) {
			MsgBox.showWarning("车牌号不能为空！");
			SysUtil.abort();
		}
		/*if (this.prmtCar.getValue() == null) {
			MsgBox.showWarning("车辆不能为空！");
			SysUtil.abort();
		}*/ //modify 20150730
		/*if (this.prmtMaterial.getValue() == null) {
			this.editData.setBillStatus(oldBillStatus);
			MsgBox.showWarning("物料不能为空！");
			SysUtil.abort();
		}
		if (this.cmbBizType.getSelectedItem().equals(WeighBizType.Pur)) {
			if (this.prmtCustomer.getValue() == null) {
				this.editData.setBillStatus(oldBillStatus);
				MsgBox.showWarning("供应商不能为空！");
				SysUtil.abort();
			}
		} else {
			if (this.prmtOrderStorageOrgUnit.getValue() == null) {
				this.editData.setBillStatus(oldBillStatus);
				MsgBox.showWarning("目标库存组织不能为空！");
				SysUtil.abort();
			}
		}*/

		KDDatePicker dpDate1 = null, dpDate2 = null;
		String lblDate1 = null, lblDate2 = null;
		dpDate2 = this.dpOutTime;
		dpDate1 = this.dpInTime;
		lblDate2 = "出厂时间不能为空！";
		lblDate1 = "入厂时间不能为空！";
		if(!this.chkIsTemp.isSelected()) {
			CarType carType = ((CarInfo) this.prmtCar.getValue()).getCarType();
			if (carType.equals(CarType.ownCar)) {// 自己的车
				dpDate1 = this.dpOutTime;
				dpDate2 = this.dpInTime;
				lblDate1 = "出厂时间不能为空！";
				lblDate2 = "入厂时间不能为空！";
			} else {// 别人的车
	//			dpDate2 = this.dpOutTime;
	//			dpDate1 = this.dpInTime;
	//			lblDate2 = "出厂时间不能为空！";
	//			lblDate1 = "入厂时间不能为空！";//modify 20150730
			}
		}
		if (this.editData == null || this.editData.getId() == null) {
			if (StringUtils.isBlank(dpDate1.getText())) {
				//MsgBox.showWarning(lblDate1);
				//SysUtil.abort();
			}
		} else {
			if (editData.getBillStatus() == null || editData.getBillStatus().equals(WeighBaseStatus.save)) {
				if (StringUtils.isBlank(dpDate1.getText())) {
					//MsgBox.showWarning(lblDate1 );
					//SysUtil.abort();
				}
			}
			if (this.rdoTare2Gross.isSelected()) {// 皮重-毛重
				if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2);
						//SysUtil.abort();
					}
					this.VerifyInputWhenFinish();
					this.checkOrderQty();
				}
			}
			if (this.rdoGross2Tare.isSelected()) {// 毛重-皮重
				if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2 );
						//SysUtil.abort();
					}
					this.VerifyInputWhenFinish();
					this.checkOrderQty();
				}
			}

			if (this.rdoTare2Gross2Tare.isSelected()) {// 皮重-毛重-皮重
				if (editData.getBillStatus().equals(WeighBaseStatus.tare)) {
					if (StringUtils.isBlank(dpDate2.getText())) {
						//MsgBox.showWarning(lblDate2 );
						//SysUtil.abort();
					}
				} else if (editData.getBillStatus().equals(WeighBaseStatus.gross)) {
					this.VerifyInputWhenFinish();
					this.checkOrderQty();
				}
			}
		}

		if (!isWeighted) {
			MsgBox.showWarning("请先称重！");
			SysUtil.abort();
		}
		
	}
	/**
	 * 检查关联单据数量
	 * 
	 * @throws SQLException
	 * @throws BOSException
	 */
	private void checkOrderQty() throws BOSException, SQLException {
		//订单数量小于0
		if(orderBaseQty.signum()<=0) {
			return;
		}
//		orderBaseQty=new BigDecimal(17960);
		BigDecimal range=(BigDecimal) initParams.get("range");
		if(range==null) {
			return;
		}
		//实际jinghzong 
		BigDecimal suttle=this.txtActualSuttle.getBigDecimalValue();
		if(suttle==null) {
			suttle=BigDecimal.ZERO;
		}
		BigDecimal d100=new BigDecimal(100);
		if(orderBaseQty.multiply(BigDecimal.ONE.add(range.divide(d100,6,BigDecimal.ROUND_HALF_UP))).compareTo(suttle)<0
				||orderBaseQty.multiply(BigDecimal.ONE.subtract(range.divide(d100,6,BigDecimal.ROUND_HALF_UP))).compareTo(suttle)>0
				) {
			
			/*if(MsgBox.showConfirm2("重量不在称重可允许的范围内("+range+"%)！,是否继续保存？")!=MsgBox.YES) {
			SysUtil.abort();
		}*/
			
			//整包的
			String result="";
			try {
				UIContext uiContext = new UIContext(this);
				uiContext.put("bagDiff", range);
		    	IUIWindow uiWindow = null ;
		    	// UIFactoryName.MODEL 为弹出模式
		    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.weighbridge.client.WMsgBoxUI", uiContext, null,OprtState.VIEW);
		    	//开始展现UI
		    	uiWindow.show();
		    	result=(String) uiWindow.getUIObject().getUIContext().get("result");
			}catch(Exception err) {
			
			}
	    	if(result==null||result.equals("cancel")){
	    		SysUtil.abort();
	    	}
	    	if(result.equals("actual")) {
	    		this.txtSuttle.setValue(orderBaseQty);
	    	}
	    	else if(result.equals("temp")) {
    			this.txtTempSuttle.setValue(suttle);
    			this.txtSuttle.setValue(null);
    			this.txtActualSuttle.setValue(null);
    			//保存临时净重
    			this.isSaveTemp=true;
	    	}
		}else{
			//如果有包数，则保存理论数量
			if(orderBagQty.signum()>0) {
				this.txtSuttle.setValue(orderBaseQty);
			}
		}
	}

	/**
	 * 检查关联单据数量
	 * 
	 * @throws SQLException
	 * @throws BOSException
	 */
	private void checkOrderQtyOld() throws BOSException, SQLException {
		/**
		 * 如果选择单据不为空 数量不够则提示
		 */		
		Boolean  isExitSourceBill=false;
		BigDecimal suttleQty = this.txtSuttle.getBigDecimalValue();
		BigDecimal sumOrderQty = BigDecimal.ZERO;//来源订单累加数量
		if (suttleQty == null)
			suttleQty = BigDecimal.ZERO;
		for (int j = 0; j < this.editData.getEntrys().size(); j++) {
			OutStorageBillEntryDetailCollection detailCol = this.editData.getEntrys().get(j).getDetail();
			if (detailCol == null || detailCol.size() <= 0) {
				continue;
			}
			isExitSourceBill=true;
			BigDecimal weighQty, baseQty;
			for (int index = 0; index < detailCol.size(); index++) {
				baseQty = detailCol.get(index).getSourceEntryQty();// 来源单据过磅数量
				weighQty = WeighbridgeCommUtils.getWeighQty(detailCol.get(index).getSourceBillID(), detailCol
						.get(index).getSourceEntryID());// 已过磅数量
				if (baseQty == null) {
					baseQty = BigDecimal.ZERO;
				}
				sumOrderQty = baseQty.subtract(weighQty).add(sumOrderQty);
			}
		}
		if (isExitSourceBill&&sumOrderQty.compareTo(suttleQty) < 0) {
			MsgBox.showWarning("过磅数量大于关联单据可过磅数量！");
			SysUtil.abort();
		}
	}

	/**
	 * 執行查詢
	 * 
	 * @throws BOSException
	 * @throws SQLException
	 */
	private void execQuery() throws BOSException, SQLException {
		this.tbList.removeRows();
		 OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		String beginDate = this.dpBeginDate.getText();
		String endDate = this.dpEndDate.getText();String materialID=null;
		String carID=null;
		if(this.prmtQueryMaterial.getValue()!=null) {
			materialID=((AbstractCoreBaseInfo) this.prmtQueryMaterial.getValue()).getId().toString();
		}
		if(this.prmtQueryCar.getValue()!=null) {
			carID=((AbstractCoreBaseInfo) this.prmtQueryCar.getValue()).getId().toString();
		}

		String conditionStr=null;
		if(this.cmbQueryBillStatus.getSelectedIndex()>(-1)&&!this.cmbQueryBillStatus.getSelectedItem().toString().equals("全部")) {
			conditionStr=new StringBuffer().append(" and tb.CFBillStatus=").append(((WeighBaseStatus)this.cmbQueryBillStatus.getSelectedItem()).getValue()).toString();
		}
		IRowSet rs = getExeQueryRowSet(orgInfo,beginDate,endDate,materialID,carID,conditionStr);
		IRow row;
		String billStatus;
		while (rs.next()) {
			row = this.tbList.addRow();
			row.getCell("id").setValue(rs.getString("FID"));
			row.getCell("number").setValue(rs.getString("FNumber"));
			row.getCell("car").setValue(rs.getString("FCarNum"));
			row.getCell("storageOrgUnit").setValue(rs.getString("FStorageName"));
			row.getCell("customer").setValue(rs.getString("FCustomerName"));
			row.getCell("orderStorageOrgUnit").setValue(rs.getString("FOrderStorageOrgUnitName"));
//			row.getCell("inTime").setValue(rs.getString("CFInTime"));
//			row.getCell("outTime").setValue(rs.getString("CFOutTime"));
			
			if(rs.getString("CFInTime")!=null&&rs.getString("CFOutTime")!=null) {
				if(rs.getDate("CFInTime").before(rs.getDate("CFOutTime"))) {
					row.getCell("inTime").setValue(rs.getString("CFInTime"));
					row.getCell("outTime").setValue(rs.getString("CFOutTime"));
				}else {
					row.getCell("outTime").setValue(rs.getString("CFInTime"));
					row.getCell("inTime").setValue(rs.getString("CFOutTime"));
				}
			}else {
				if(rs.getString("CFInTime")!=null) {
					row.getCell("inTime").setValue(rs.getString("CFInTime"));
				}else {
					row.getCell("inTime").setValue(rs.getString("CFOutTime"));
				}
			}
			
			billStatus=rs.getString("CFBillStatus");
			row.getCell("billStatus").setValue(WeighBaseStatus.getEnum(billStatus).getAlias());
			row.getCell("materialName").setValue(rs.getString("FMaterialName"));
			row.getCell("tare").setValue(rs.getBigDecimal("CFTare"));
			row.getCell("gross").setValue(rs.getBigDecimal("CFGross"));
			row.getCell("tare2").setValue(rs.getBigDecimal("CFTare2"));
			row.getCell("impurity").setValue(rs.getBigDecimal("CFImpurity"));
			row.getCell("suttle").setValue(rs.getBigDecimal("CFSuttle"));
			row.getCell("actualSuttle").setValue(rs.getBigDecimal("CFActualSuttle"));
			row.getCell("suttleDiff").setValue(rs.getBigDecimal("CFActualSuttle").subtract(rs.getBigDecimal("CFSuttle")));
			row.getCell("bizDate").setValue(rs.getString("FBizDate").substring(0, 10));
			row.getCell("materialID").setValue(rs.getString("FMaterialID"));
			row.getCell("materialNum").setValue(rs.getString("FMaterialNum"));
			row.getCell("entryID").setValue(rs.getString("FEntryID"));
			if(WeighBaseStatus.getEnum(billStatus).getAlias().endsWith("完成")) {
				row.getStyleAttributes().setBackground(new Color(165,231,92));
			}
		}
		rs.close();
		// this.resetBill();
	}
	
	private IRowSet getExeQueryRowSet(OrgUnitInfo orgInfo,String beginDate,String endDate,String materialID,String carID,String otherCondition) throws BOSException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,tm.FName_l2 FMaterialName,");
		sql.append(" tb.FBizDate,tcar.FNumber FCarNum,te.CFTare,te.CFGross,isnull(te.CFSuttle,0) CFSuttle,tb.FNumber,");
		sql.append(" te.CFTare2,0 CFImpurity,tCustomer.FName_l2 FCustomerName,tStorage.fname_l2 FOrderStorageOrgUnitName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName");
		sql.append(" ,isnull(te.CFActualSuttle,0) CFActualSuttle,te.CFTempSuttle");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_customer tCustomer on tCustomer.FID=tb.CFCustomerID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" left join t_org_storage tStorage on tStorage.FID=tb.CFOrderStorageOrgU");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" left join t_bd_material tm on tm.FID=te.CFMaterialID");
		sql.append(" where ( CFStorageOrgUnitID=?");
		if(orgInfo.isIsCompanyOrgUnit())
			sql.append(" or CFCompanyID='").append( orgInfo.getId().toString()).append("'");
		sql.append(" )");
		sql.append(" and tb.CFBillStatus!=3 ");//非作废单据 ,第一行分录数据
		if(StringUtils.isNotBlank(beginDate)) {
			sql.append(" and FBizDate>={ts '").append(beginDate).append(" 00:00:00'} ");
		}
		if(StringUtils.isNotBlank(endDate)) {
			sql.append(" and FBizDate<={ts '").append(endDate).append(" 23:59:59'} ");
		}
		if(StringUtils.isNotBlank(carID)) {
			sql.append(" and tb.CFCarID='").append(carID).append("'");;
		}
		if(StringUtils.isNotBlank(materialID)) {
			sql.append(" and te.CFMaterialID='").append(materialID).append("'");
		}
		if(StringUtils.isNotBlank(otherCondition)) {
			sql.append(otherCondition);
		}
//		sql.append(" order by tb.FBizDate desc,te.FSeq asc");
		//add 20150730
		sql.append(" union all");
		sql.append(" select tb.FID,te.FID FEntryID,tm.FID FMaterialID,tm.FNumber FMaterialNum,tm.FName_l2 FMaterialName,");
		sql.append(" tb.FBizDate,tb.CFCarNum FCarNum,te.CFTare,te.CFGross,isnull(te.CFSuttle,0) CFSuttle,tb.FNumber,");
		sql.append(" te.CFTare2,0 CFImpurity,tCustomer.FName_l2 FCustomerName,tStorage.fname_l2 FOrderStorageOrgUnitName,te.CFWeighTime CFInTime,");
		sql.append(" te.CFWeighTimeGross CFOutTime,tb.CFBillStatus,tCurStorage.Fname_l2 FStorageName");
		sql.append(" ,isnull(te.CFActualSuttle,0) CFActualSuttle,te.CFTempSuttle");
		sql.append(" from ").append(billTable).append(" tb");
		sql.append(" left join t_bd_customer tCustomer on tCustomer.FID=tb.CFCustomerID");
		sql.append(" left join t_org_storage tCurStorage on tCurStorage.FID=tb.CFStorageOrgUnitID");
		sql.append(" left join t_org_storage tStorage on tStorage.FID=tb.CFOrderStorageOrgU");
		sql.append(" inner join ").append(billEntryTable).append(" te on te.FParentID=tb.FID");
//		sql.append(" inner join ").append(carTable).append(" tcar on tcar.FID=tb.CFCarID");
		sql.append(" left join t_bd_material tm on tm.FID=te.CFMaterialID");
		sql.append(" where ( CFStorageOrgUnitID=?");
		if(orgInfo.isIsCompanyOrgUnit())
			sql.append(" or CFCompanyID='").append( orgInfo.getId().toString()).append("'");
		sql.append(" )");
		sql.append(" and tb.CFBillStatus!=3 ");//非作废单据 ,第一行分录数据
		if(StringUtils.isNotBlank(beginDate)) {
			sql.append(" and FBizDate>={ts '").append(beginDate).append(" 00:00:00'} ");
		}
		if(StringUtils.isNotBlank(endDate)) {
			sql.append(" and FBizDate<={ts '").append(endDate).append(" 23:59:59'} ");
		}
		if(StringUtils.isNotBlank(carID)) {
//			sql.append(" and tb.CFCarID='").append(carID).append("'");;
		}
		if(StringUtils.isNotBlank(materialID)) {
			sql.append(" and te.CFMaterialID='").append(materialID).append("'");
		}
		if(StringUtils.isNotBlank(otherCondition)) {
			sql.append(otherCondition);
		}
		sql.append(" and tb.CFCarID is null");
		sql.append(" order by FBizDate desc");
		IRowSet rs = getSqlInstance().executeQuery(sql.toString(), new Object[] { orgInfo.getId().toString(),orgInfo.getId().toString() });
		return rs;
	}

	protected void disposeUIWindow() {
		// TODO Auto-generated method stub
		stopComReaderNew(true);
		super.disposeUIWindow();
	}

	private void stopComReaderNew(Boolean isClose) {
		setIsNeedRead(false);
		if(isClose&&pool!=null) {
			this.isNeedExit=true;
			this.pool.shutdown();
		}
		this.btnBeginRead.setEnabled(true);// 禁用读取
		this.btnEndRead.setEnabled(false);
	}
	
	private void beginComReaderNew() {
		setIsNeedRead(true);
		this.btnBeginRead.setEnabled(false);// 禁用读取
		this.btnEndRead.setEnabled(true);
	}

	
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	protected KDTable getDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * output actionPrint_actionPerformed method
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		this.editData = this.editData;
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
			idList.add(editData.getString("id"));
		}
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(
				idList, getTDQueryPK());
		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
		appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	/**
	 * output actionPrintPreview_actionPerformed method
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		this.editData = this.editData;
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
			idList.add(editData.getString("id"));
		}
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
			return;
		com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(
				idList, getTDQueryPK());
		com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
		appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}

	protected String getTDFileName() {
		return "/bim/weighbridge/OutStorageBill";
	}

	protected IMetaDataPK getTDQueryPK() {
		return new MetaDataPK("com.kingdee.eas.weighbridge.app.OutStorageBillQuery");
	}

	public static void model_show(KDBizPromptBox promptBox, KDComboBox bizType) {
		String UICLASSNAME = "com.kingdee.eas.weighbridge.client.F7TransOrderListUI";
		Map map = new UIContext();
		if (bizType.getSelectedItem().equals(WeighBizType.Sale)) {
			map.put("BizBillType", F7TransOrderListUI.SALEORDER_VALUE);
		} else {
			map.put("BizBillType", F7TransOrderListUI.TRANSOUT_VALUE);
		}
		map.put("orgUnitID", SysContext.getSysContext().getCurrentPurchaseUnit() == null ? "" : SysContext
				.getSysContext().getCurrentPurchaseUnit().getId().toString());
		String type = OprtState.VIEW;
		try {
			IUIWindow uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(UICLASSNAME, map, null, type);
			promptBox.setSelector((F7TransOrderListUI) uiWindow.getUIObject());
			uiWindow.show();
			F7SelectBillInfo[] returnData = (F7SelectBillInfo[]) ((F7TransOrderListUI) uiWindow.getUIObject())
					.getData();
			promptBox.setValue(returnData);
		} catch (UIException e) {
			e.printStackTrace();
		}
	}
	
	 protected void setAutoNumberByOrg(String orgType) {
		    editData=editData;
	    	if (editData == null) return;
			if (editData.getNumber() == null) {
	            try {
	            	String companyID = null;
					if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
						companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
					}
					else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
						companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
	            	}
					com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
			        if (iCodingRuleManager.isExist(editData, companyID)) {
			            if (iCodingRuleManager.isAddView(editData, companyID)) {
			            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
			            }
		                txtNumber.setEnabled(false);
			        }
	            }
	            catch (Exception e) {
	                handUIException(e);
	                this.oldData = editData;
	                com.kingdee.eas.util.SysUtil.abort();
	            } 
	        } 
	        else {
	            if (editData.getNumber().trim().length() > 0) {
	                txtNumber.setText(editData.getNumber());
	            }
	        }
	    }
	 
	 protected String getAutoNumberByOrg(String orgType) {
		   String number=null;
		    editData=editData;
	    	if (editData == null) return number;
			if (editData.getNumber() == null) {
	            try {
	            	String companyID = null;
					if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
						companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
					}
					else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
						companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
	            	}
					com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
			        if (iCodingRuleManager.isExist(editData, companyID)) {
			            if (iCodingRuleManager.isAddView(editData, companyID)) {
			            	//editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
			            	return iCodingRuleManager.getNumber(editData,companyID);
			            }
		                //txtNumber.setEnabled(false);
			        }
	            }
	            catch (Exception e) {
	                handUIException(e);
	                this.oldData = editData;
	                com.kingdee.eas.util.SysUtil.abort();
	            } 
	        } 
	        else {
	            if (editData.getNumber().trim().length() > 0) {
	               // txtNumber.setText(editData.getNumber());
	            	number=editData.getNumber();
	            }
	        }
			return number;
	    }	
		protected ICoreBase getBizInterface() throws Exception {
			// TODO Auto-generated method stub
			return OutStorageBillFactory.getRemoteInstance();
		}
		
		

		/**
		 * 保存称重记录
		 * @throws BOSException 
		 * @throws EASBizException 
		 */
		private void saveWeighLog(String dataSource) throws EASBizException, BOSException{

			try{
				WeighLogInfo logInfo = new WeighLogInfo();
				logInfo.setWeight(weightValue);
				logInfo.setCarNumber((CarInfo) this.prmtCar.getValue());
				logInfo.setOtherCarInfo(this.txtCarNum.getText());
				logInfo.setCompany(SysContext.getSysContext().getCurrentFIUnit());
				logInfo.setUser(SysContext.getSysContext().getCurrentUserInfo());
				logInfo.setDataSource(dataSource);
				logInfo.setPlatform(bridgeInfo);
				WeighbridgeCommUtils.addWeighLog(null, logInfo);
				weightValue = BigDecimal.ZERO;
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}

		/**
		 * 保存称重记录
		 */
		@Override
		protected void btnSaveWeigh_actionPerformed(ActionEvent e)
				throws Exception {
			String txtShow = this.labShowWeight.getText();
			if (StringUtils.isBlank(txtShow)) {
				MsgBox.showWarning("读数数值失败，请检查设置！");
				SysUtil.abort();
			}
			try {
				Double.parseDouble(txtShow);
			} catch (Exception ee) {
				MsgBox.showWarning("读数数值失败，请检查设置！");
				SysUtil.abort();
			}
			// 重量
			weightValue = new BigDecimal(txtShow);
			
			// 车
			CarInfo carInfo = (CarInfo) this.prmtCar.getValue();
			String carNumber = this.txtCarNum.getText();
			if(carInfo == null && StringUtils.isBlank(carNumber)){
				MsgBox.showWarning("请填写车辆信息！");
				SysUtil.abort();
			}
			
			if(MsgBox.showConfirm2("确认保存过磅重量："+weightValue.toPlainString() + "?") == MsgBox.OK){
				
				
				saveWeighLog("出库过磅单-单独过磅");
				MsgBox.showInfo("保存重量完成");
			}
			
		}
		
		
}