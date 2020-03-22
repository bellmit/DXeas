//package com.kingdee.eas.hr.affair.client;
//
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.apache.commons.lang.StringUtils;
//
//import com.kingdee.bos.ctrl.kdf.table.IRow;
//import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
//import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
//import com.kingdee.bos.util.BOSUuid;
//import com.kingdee.eas.basedata.hraux.FolkCollection;
//import com.kingdee.eas.basedata.hraux.FolkFactory;
//import com.kingdee.eas.basedata.hraux.IFolk;
//import com.kingdee.eas.basedata.person.Genders;
//import com.kingdee.eas.hr.affair.EmpEnrollBizBillCollection;
//import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryCollection;
//import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryInfo;
//import com.kingdee.eas.hr.base.EmployeeTypeInfo;
//import com.kingdee.eas.util.SysUtil;
//import com.kingdee.eas.util.client.MsgBox;
//
///**
// * 员工入职扩展类
// * @author dai_andong
// *
// */
//public class EmpEnrollBizBillEditUICTEx  extends  EmpEnrollBizBillEditUI{
//	private NativeUtils nUtils;
//	private Thread readerThread=null;
//	private String oldIdentityID="",identityID="",personName="",gender="",birthDay="",address="",nation="",photoBase64="'";//身份证号
//	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//	private boolean isOpened=false;
//	private IFolk ifs;
//	
//	public EmpEnrollBizBillEditUICTEx() throws Exception {
//		super();
//		Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setPreferredSize(new Dimension((int)(dd.getWidth()*0.8),(int)(dd.getHeight()*0.8)));
//	}
//
//	@Override
//	public void onLoad() throws Exception {
//		super.onLoad();
////		btnReadCard.setVisible(false);
//		
//		ifs = FolkFactory.getRemoteInstance();
//		nUtils=new NativeUtils();
//		
//	}
//	
//	@Override
//	protected void btnReadCard_actionPerformed(ActionEvent e) throws Exception {
////		// TODO Auto-generated method stub
////		super.btnReadCard_actionPerformed(e);
//		if(readerThread==null) {
//			readerThread=new Thread(new ReadTimer());
//			readerThread.start();
//		}
//	}
//
//	@Override
//	public boolean destroyWindow() {
//		closePort();
//		return super.destroyWindow();
//	}
//	
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//		closePort();
//		super.finalize();
//	}
//	
//	/**
//	 * 定时任务
//	 * @author Administrator
//	 *
//	 */
//	private class ReadTimer implements Runnable{
//		private int ret;
//		boolean isCanRead=true;
//		public void run() {
//			if(!isOpened) {
//				while(true) {
//					try {
//						if(opPort()==1){
//							break;
//						}
//					}catch(Exception e) {
//						isCanRead=false;
//						MsgBox.showError(e.getMessage());
//					}
//					if(!isCanRead) {
//						break;
//					}
//					try {
//						Thread.currentThread().sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			while(true) {
//				if(!isCanRead) {
//					break;
//				}
//				try {
//					ret=nUtils.CVR_Authenticate();
//				} catch (Exception e) {
//					handleException(e);
//				}
//				System.out.println("身份认证："+ret);
//				//端口没打开
//				if(ret==4) {
////					opPort();
////					break;
//				}
//				//没有身份证
//				if(ret==0) {
//					oldIdentityID="";
//				}
//				try {
//					ret=nUtils.CVR_Read_Content(2);
//				} catch (Exception e) {
//					handleException(e);
//				}
//				System.out.println("读卡："+ret);
//				if(ret==1) {//1未读取正常
//					try {
//						ret = nUtils.GetPeopleIDCode();//
//					} catch (Exception e) {
//						handleException(e);
//					}
//					identityID=nUtils.getStrTmp().trim();
//					System.out.println("获取身份证号："+ret+","+identityID);
//					try {
//						ret = nUtils.GetPeopleName();//
//					} catch (Exception e) {
//						handleException(e);
//					}
//					personName=nUtils.getStrTmp().trim();
//					System.out.println("获取姓名："+ret+","+personName);
//					
//					try {
//						ret = nUtils.GetPeopleGender();
//					} catch (Exception e) {
//						handleException(e);
//					}
//					gender=nUtils.getStrTmp().trim();
//					System.out.println("获取姓名："+ret+","+gender);
//					
//					try {
//						ret = nUtils.GetPeopleBirthDay();
//					} catch (Exception e) {
//						handleException(e);
//					}
//					birthDay=nUtils.getStrTmp().trim();
//					System.out.println("获取生日："+ret+","+birthDay);
//					
//					try {
//						ret = nUtils.GetPeopleAddress();
//					} catch (Exception e) {
//						handleException(e);
//					}
//					address=nUtils.getStrTmp().trim();
//					System.out.println("获取地址："+ret+","+address);
//					
//					try {
//						ret = nUtils.GetPeopleNation();
//					} catch (Exception e) {
//						handleException(e);
//					}
//					nation=nUtils.getStrTmp().trim();
//					System.out.println("获取民族："+ret+","+nation);
//					
//					
//					try {
//						ret = nUtils.GetPeoplePhoto();
//					} catch (Exception e) {
//						handleException(e);
//					}
//					photoBase64=nUtils.getStrTmp().trim();
//					System.out.println("获取照片："+ret+","+photoBase64);
//					
//					if(org.apache.commons.lang.StringUtils.isNotBlank(identityID)) {
//						addEntryLine(personName, identityID, gender, birthDay,address,nation,photoBase64);
//					}
//				}
//				try {
//					Thread.currentThread().sleep(300);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	/**
//	 * 插入分录行
//	 */
//	private void addEntryLine(String personName,String identityID,String gender,String birthDay,String address,String nation,String imgBase64) {
//		if(oldIdentityID.equalsIgnoreCase(identityID)) {
//			return;
//		}
//		try {
//			kdtEntrys_detailPanel.actionAddnewLine_actionPerformed(null);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		IRow row=kdtEntrys.getRow(kdtEntrys.getRowCount() - 1);
//		
//		EmpEnrollBizBillEntryInfo entryInfo=(EmpEnrollBizBillEntryInfo) row.getUserObject();
////		entryInfo.setEmpNumber("");//员工编码
//		entryInfo.setEmpName(personName);
//		entryInfo.setIDCardNo(identityID);
//		entryInfo.setGender(gender.equals("男")?Genders.Male:Genders.Female);
//		entryInfo.setIdCardAddress(address);
//		entryInfo.setFolk(nation);
//		EmployeeTypeInfo empTypeInfo=new EmployeeTypeInfo();
//		empTypeInfo.setId(BOSUuid.read("00000000-0000-0000-0000-000000000002A29E85B3"));//员工状态--试用员工
//		entryInfo.setEmpType(empTypeInfo);
//		if(StringUtils.isNotBlank(imgBase64)) {
//			try {
//				entryInfo.setImageData(new sun.misc.BASE64Decoder().decodeBuffer(imgBase64));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		entryInfo.setProbation(3);
//		try {
//			entryInfo.setBirthday(sdf.parse(birthDay));
//		} catch (ParseException e) {
//			handleException(e);
//		}
//		entryInfo.setEnrollDate(new Date());
//		entryInfo.setBizDate(entryInfo.getEnrollDate());
//		
////		row.getCell("empNumber").setValue(entryInfo.getEmpNumber());
//		row.getCell("empName").setValue(entryInfo.getEmpName());
//		row.getCell("IDCardNo").setValue(entryInfo.getIDCardNo());
//		row.getCell("gender").setValue(entryInfo.getGender());
//		row.getCell("birthday").setValue(entryInfo.getBirthday());
//		row.getCell("enrollDate").setValue(entryInfo.getEnrollDate());
//		row.getCell("bizDate").setValue(entryInfo.getBizDate());
//		row.getCell("probation").setValue(entryInfo.getProbation());
//		row.getCell("empType").setValue(entryInfo.getEmpType());
//		if(row.getCell("accountAddress")!=null) {
//			row.getCell("accountAddress").setValue(entryInfo.getIdCardAddress());
//		}
//		if(row.getCell("accountAddress")!=null) {
//			row.getCell("nowAddress").setValue(entryInfo.getIdCardAddress());
//		}
//		if(row.getCell("accountAddress")!=null) {
//			try {
//				FolkCollection cols = ifs.getFolkCollection("where name='"+entryInfo.getFolk()+"族'");
//				if(!cols.isEmpty()) {
//					row.getCell("nation").setValue(cols.get(0));
//				}
//			}catch(Exception err) {
//				err.printStackTrace();
//			}
//		}
////		row.getCell("imageData").setValue(entryInfo.getImageData());
//		row.setUserObject(entryInfo);
//
//		oldIdentityID=identityID;
//		
//		KDTEditEvent kdte = new KDTEditEvent(getDetailTable(), null, identityID, kdtEntrys.getRowCount() - 1, getDetailTable().getColumnIndex("qty"), false, 1);  
//        Object[] listeners = getDetailTable().getListenerList().getListenerList();  
//        for (int i = listeners.length - 2; i >= 0; i -= 2) {  
//            if (listeners[i] == KDTEditListener.class) {  
//                ((KDTEditListener) listeners[(i + 1)]).editStopped(kdte);  
//            }  
//        }  
//        try {
//			kdtEntrys_editStopped(kdte);
//		} catch (Exception err) {
//			handleException(err);
//		}
//		//触发值改变事件
////		super.kdtEntrys_editStopped(e);
//	}
//	
//	
//	/**
//	 * 打开端口
//	 * @throws Exception 
//	 */
//	private int opPort() throws Exception {
//		int ret=0;
//		try {
//			ret=nUtils.CVR_InitComm(1001);
//			if(ret==1) {
//				isOpened=true;
//			}
//		} catch (Exception e) {
//			throw new Exception(e);
//		} 
//		System.out.println("打开端口："+ret);
//		return ret;
//	}
//
//	/**
//	 * 打开端口
//	 */
//	private void closePort() {
//		if(readerThread==null) {
//			return;
//		}
//		readerThread.suspend();
//		int ret=0;
//		try {
//			if(isOpened) {
//				ret=nUtils.CVR_CloseComm();
//			}
//		} catch (Exception e) {
////			handleException(e);
//		} 
//		isOpened=false;
//		System.out.println("关闭端口："+ret);
//	}
//
//	@Override
//	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
//		// TODO Auto-generated method stub
//		
//		EmpEnrollBizBillEntryCollection  EEBBCC =  this.editData.getEntrys();
//		for(int i=0;i<EEBBCC.size();i++){
//			EmpEnrollBizBillEntryInfo eebbe = EEBBCC.get(i);
//			 Calendar c1 = Calendar.getInstance(); // 创建日历对象
//		     Calendar c2 = Calendar.getInstance();
//		     c1.setTime(eebbe.getBirthday());
//		     c2.setTime(new Date());
//		     int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR); // 计算年度差
//			 if(years<16){
//				 MsgBox.showWarning(eebbe.getEmpName()+"年龄不满16周岁，不允许入职！");
//				 SysUtil.abort();
//			 }
//		}
//		
//		
//		super.actionSubmit_actionPerformed(arg0);
//	}
//}
