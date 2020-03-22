/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonCollection;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.AttendanceDockingSettingFactory;
import com.kingdee.eas.custom.wages.AttendanceDockingSettingInfo;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class AttendanceDockingEditUI extends AbstractAttendanceDockingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AttendanceDockingEditUI.class);
    
    /**
     * output class constructor
     */
    public AttendanceDockingEditUI() throws Exception
    {
        super();
    }
    
	public void onLoad() throws Exception {
		super.onLoad();
		pkBizDate.setSupportedEmpty(false);
		kdtEntry.getColumn("punchCardTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
		kdtEntry.getColumn("punchCardTime").setWidth(150);
		kdtEntry.getStyleAttributes().setLocked(true);
		kdtEntry_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntry_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtEntry_detailPanel.getInsertLineButton().setEnabled(false);
		getMassages.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				getMassages();
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			
		});
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
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
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
        com.kingdee.eas.custom.wages.AttendanceDockingInfo objectValue = new com.kingdee.eas.custom.wages.AttendanceDockingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    private void getMassages() {
//    	MsgBox.showWarning("功能正在完善，请稍等。");
    	try{ 
    		Date date=(Date)pkBizDate.getValue();
    		if(date==null){
    			MsgBox.showWarning("业务日期不能为空！");
    			return;
    		}
    		
    		AttendanceDockingSettingInfo sInfo=getSettingInfo();
    		if(sInfo==null) {
    			MsgBox.showWarning("当前计算机没有进行考勤机接口设置！！");
//    			return;
    		}
    		
    		//String filePath="C:\\Users\\admin\\Desktop\\201805.mdb";
    		
    		String filePath=sInfo.getDbFilePath();
    		if(!filePath.endsWith("\\")) {
    			filePath+="\\";
    		}
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    		String dbNameStr=sdf.format(date).substring(0,6)+".mdb";
    		filePath=filePath+dbNameStr;
    		SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd");
    		//SimpleDateFormat sdfs=new SimpleDateFormat("yyyy/MM/dd");
    		String dateStr=sdfs.format(date);
    		
            String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};pwd=123;DBQ="+filePath;  
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
            Connection conn = DriverManager.getConnection(url);  
            System.out.println(conn);  
            Statement sta = conn.createStatement();
            //EMPLOYEE 职员表 EMPLID 员工id EMPCAR 员工编码EMPNAM员工名称
            // ONETIM 原始刷卡数据 ONEEMP 员工id  ONEDAT 刷卡日期，刷卡时间
            kdtEntry.removeRows();
            StringBuffer sql=new StringBuffer();
            sql.append(" SELECT distinct tperson.EMPCAR,tperson.EMPNAM,trecord.onedat as fdate,format(trecord.onedat,'yyyy-MM-dd')&' '&format(onetim,'HH:mm:ss') as FTime")
            .append(" from ONETIM trecord ")
            .append(" inner join  EMPLOYEE tperson on tperson.EMPLID=trecord.ONEEMP")
            .append(" where onedat =cdate('").append(dateStr).append("')")
//            .append(" order by tperson.EMPCAR,trecord.ONEDAT")
            .append(" ");
            ResultSet rs= sta.executeQuery(sql.toString());
            IRow row;
			String personNum;
            HashSet set=new HashSet();
            while(rs.next()){ 
            	row = kdtEntry.addRow();
            	personNum=rs.getString("EMPCAR").substring(1);
            	row.getCell("personNum").setValue(personNum);
            	row.getCell("personName").setValue(rs.getString("EMPNAM"));
            	row.getCell("punchCardTime").setValue(rs.getTimestamp("FTime"));
            	PersonInfo info = getPersonInfo(personNum);
            	if(info!=null){
            		row.getCell("person").setValue(info);
            	}
            	System.out.println(rs.getString("fdate"));
            	set.add(personNum);
            }  
//            if(set.size()>0) {
//	            IPerson ips = PersonFactory.getRemoteInstance();
//	            EntityViewInfo ev=new EntityViewInfo();
//	            FilterInfo filter=new FilterInfo();
//	            filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
//				ev.setFilter(filter);
//				PersonCollection cols = ips.getPersonCollection(ev);
//				for(int index=0;index<cols.size();) {
//					for(int rowIndex=0;rowIndex<kdtEntry.getRowCount();rowIndex++) {
//						personNum=kdtEntry.getCell(rowIndex, "personNum").getValue().toString();
//						if(cols.get(rowIndex).getNumber().equals(personNum)) {
//							kdtEntry.getCell(rowIndex, "person").setValue(cols.get(rowIndex));
//						}
//					}
//				}
//            }
            }catch(Exception err){  
               handleException(err);
            }  
	}

    private PersonInfo getPersonInfo(String personNum) {
		// TODO Auto-generated method stub
    	PersonInfo info = null;
    	String personID = null;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FNumber ='").append(personNum).append("'").append(sp);
		System.out.println("获取用户id"+sql.toString());
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()){
				personID = rs.getString("FID");
			}
			if(personID!=null){
				info = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personID));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	private AttendanceDockingSettingInfo getSettingInfo() {
    	String cpuId="123";
		try {
			cpuId=getLocalMac();
		} catch (IOException e) {
			return null;
		}
		try {
			AttendanceDockingSettingInfo info = AttendanceDockingSettingFactory.getRemoteInstance().getAttendanceDockingSettingInfo("where cpuId='"+cpuId+"'");
			return info;
		} catch (Exception e) {
			return null;
		} 
		
		
		
    }
	/**
	 * 通過本機IP獲取本機MAC地址
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		//String s=new String(mac);
		//System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			//System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}

}