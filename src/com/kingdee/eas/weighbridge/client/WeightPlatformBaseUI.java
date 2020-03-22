/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDLabel;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.client.IBTPBillEdit;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.eas.weighbridge.PortNum;
import com.kingdee.eas.weighbridge.WeighBridgeFactory;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.eas.weighbridge.comm.BTPBillEditImplEx;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class WeightPlatformBaseUI extends AbstractWeightPlatformBaseUI
{
    private static final Logger logger = CoreUIObject.getLogger(WeightPlatformBaseUI.class);
    protected static KDWorkButton btnBeginRead;
    protected static KDWorkButton btnEndRead;
    protected static ComReaderUtils cr=null;
    protected static ExecutorService pool=null;//com读取线程池
    protected static Boolean isNeedRead=false;
    protected static String settingID=null;
    protected static IBTPManager iBTPManager=null;
    protected static IBTPBillEdit billEdit=null;
    protected static HashMap<String,Boolean> isNeedExitList=new HashMap<String,Boolean>();
    protected static boolean isCanStop=false;
    protected StorageOrgUnitInfo storageUnitOrg;
    protected static String showWeight_Value="0.00";
    
    /**
     * output class constructor
     */
    public WeightPlatformBaseUI() throws Exception
    {
        super();
    }
    
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		storageUnitOrg = SysContext.getSysContext().getCurrentStorageUnit();
		if(storageUnitOrg!=null&&!storageUnitOrg.isIsBizUnit()) {
			MsgBox.showWarning("非实体库存组织不允许操作！");
			SysUtil.abort();
		}
		
	  if(btnBeginRead==null) {
	        btnBeginRead = new KDWorkButton("读取");
			btnBeginRead.setName("btnBegin");
			btnBeginRead.setEnabled(true);
			btnBeginRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						beginComReaderNew();
					} catch (Exception err) {
						handleException(err);
					}
				}
			});
//			this.toolBar.add(btnBeginRead);
        }
        if(btnEndRead==null) {
			btnEndRead = new KDWorkButton("停止");
			btnEndRead.setName("btnEnd");
			btnEndRead.setEnabled(false);
			btnEndRead.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//stopComReader();
					stopComReaderNew();
				}
			});
//			this.toolBar.add(btnEndRead);
        }

        iBTPManager = null;
		if (getMainOrgContext() == null) {
			iBTPManager = BTPManagerFactory.getRemoteInstance();
		} else {
			iBTPManager = BTPManagerFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());
		}

		billEdit = new BTPBillEditImplEx(this);
		billEdit.init();

		beginComReaderNew();
		if(pool==null) {
			pool=Executors.newCachedThreadPool();
			settingID=setComReadPort();
		}
	}


	protected void stopComReaderNew() {
		isCanStop=true;
		Iterator<Entry<String, Boolean>> itr = isNeedExitList.entrySet().iterator();
		while(itr.hasNext()){
			Entry<String, Boolean> tmp = itr.next();
			if(!tmp.getValue()) {
				isCanStop=false;
				break;
			}
		}
		if(isCanStop) {
			isNeedRead=false;
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				pool.shutdown();
//				 while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
//		            System.out.println("线程池没有关闭");
//		        }
				Thread.currentThread().sleep(200);
				pool.awaitTermination(1, TimeUnit.SECONDS);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			cr=null;
			pool=null;
			btnBeginRead.setEnabled(true);// 禁用读取
			btnEndRead.setEnabled(false);
		}
	}
	
	protected void disposeUIWindow() {
		// TODO Auto-generated method stub
		stopComReaderNew();
		super.disposeUIWindow();
	}
	
    protected void beginComReaderNew() {
    	isNeedRead=true;
		isCanStop=false;
		btnBeginRead.setEnabled(false);// 禁用读取
		btnEndRead.setEnabled(true);
	}
    
	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		return null;
	}

	@Override
	protected KDTable getDetailTable() {
		return null;
	}
	
	/**
	 * 設置COM通訊類
	 * 
	 * @throws UnknownHostException
	 * @throws SocketException
	 * */
	protected String setComReadPort() throws Exception {
		if(cr!=null) {
			return null;
		}
		String id=null;//单据id
		String macAddress = ComReaderUtils.getLocalMac();
		final IRowSet rs = getSqlInstance().executeQuery(" select * from CT_WHB_Setting where CFmac=? and CFStorageOrgUnitID=?",
				new Object[] { macAddress,storageUnitOrg.getString("id") });
		if (rs.next()) {
			id=rs.getString("fid");

//			bridgeInfo = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
			WeighBridgeInfo info = WeighBridgeFactory.getRemoteInstance().getWeighBridgeInfo(new ObjectUuidPK(rs.getString("CFWeighbridgeID")));
			if(cr==null) {
				cr=new ComReaderUtils(info,null,0);
			}
			pool.submit(new Thread(){
				String returnValue;
				public void run() {
					System.out.println("称重-读数线程开始！");
					while (true) {
						try {
							Thread.currentThread().sleep(200);
							if(isNeedRead||!isCanStop) {
								//打开端口
								if(cr!=null){
									if(!cr.isOpened()) {
										try {
											cr.openPort();
										} catch (Exception e) {
											handleException(e);
										}
									}//读取数据
									returnValue=cr.getPortDataNew();
								}else {
									returnValue="0";
								}
								
								if (StringUtils.isNotBlank(returnValue)) {
									ChangeShowLable(returnValue);
								}
							}else {
								ChangeShowLable("待读取");
								if(cr!=null&&cr.isOpened()){
									try {
										cr.closePort();
										cr=null;
									} catch (Exception e) {
										handleException(e);
									}
								}
								if(isCanStop) {
									System.out.println("称重-读数线程结束！");
									break;
								}
							}
//							if(isNeedExit) {
//								Thread.currentThread().destroy();
//							}
						} catch (Exception e) {
							handleException(e);
						} 
					}
				}
			});
		} else {
			MsgBox.showWarning("读数数值失败，请检查设置！");
		}
		rs.close();
		return id;
	}
	/**
	 * 根据单据编码设置称重
	 * @throws BOSException 
	 */
	private synchronized  void ChangeShowLable(String value) throws BOSException {
//		labShowWeight.setText(value);
		showWeight_Value=value;
	}
	
	/**
	 * 得到SQL执行对象
	 * 
	 * @return
	 * @throws BOSException
	 */
	protected ICommSqlFacade getSqlInstance() throws BOSException {
		return CommSqlFacadeFactory.getRemoteInstance();
	}
	
	/**
	 * 数值显示进程
	 * @author dai_a
	 *
	 */
	protected class ShowLblThread extends Thread{
		private KDLabel labShowWeight;
//		private WeightPlatformBaseUI ui;
		private String uiClassName;
		public ShowLblThread(WeightPlatformBaseUI ui,KDLabel labShowWeight) {
			this.labShowWeight=labShowWeight;
//			this.ui=ui;
			this.uiClassName=ui.getClass().getSimpleName();
		}
		@Override
		public void run() {
			System.out.println(uiClassName+"显示线程开始！");
			while(true) {
				if(isNeedExitList.containsKey(uiClassName)&&!isNeedExitList.get(uiClassName)) {
					labShowWeight.setText(showWeight_Value);
				}else {
					System.out.println(uiClassName+"显示线程退出！");
					break;
				}
				Thread.currentThread();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}