//package com.kingdee.eas.farm.stocking.assistfunction.client;
//
//import java.io.UnsupportedEncodingException;
//
//import org.xvolks.jnative.JNative;
//import org.xvolks.jnative.exceptions.NativeException;
//import org.xvolks.jnative.pointers.Pointer;
//import org.xvolks.jnative.pointers.memory.MemoryBlockFactory;
//
//import com.kingdee.bos.BOSException;
///**
// * 身份证读取
// * @author Administrator
// *
// */
//public class NativeUtils {
//    private String strTmp;
//    int len = 0;
//    int ret = 0; 
//    
//	public String getStrTmp() {
//		return strTmp;
//	}
//
//	public void setStrTmp(String strTmp) {
//		this.strTmp = strTmp;
//	}
//
//	public int getLen() {
//		return len;
//	}
//
//	public void setLen(int len) {
//		this.len = len;
//	}
//
//	public int getRet() {
//		return ret;
//	}
//
//	public void setRet(int ret) {
//		this.ret = ret;
//	}
//
//	public  int CVR_InitComm(int Port) throws NativeException, IllegalAccessException, UnsupportedEncodingException 
//    {          
//          JNative n = null;
//          try 
//          {
//             n = new JNative("Termb.dll", "CVR_InitComm");              
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型
//             n.setParameter(0, Port);                   
//             n.invoke(); // 调用方法
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//    
//	public  int GetPeopleName() throws NativeException, IllegalAccessException 
//    {
//          JNative n = null;           
//          try 
//          {
//             n = new JNative("Termb.dll", "GetPeopleName"); 
//			n.setRetVal( org.xvolks.jnative.Type.INT); // 指定返回参数的类型 
//             Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
//             Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));             
//             n.setParameter(0,b);
//             n.setParameter(1,a);              
//             n.invoke(); 
//             byte[] by = new byte[120];             
//             by = b.getMemory();
//            try 
//            {
//                strTmp = new String(by,"gb2312");
//            } 
//            catch (UnsupportedEncodingException ex) 
//            {
////                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            byte[] bt = new byte[40];  
//            bt = a.getMemory();
//             len = a.getAsInt(0);
//             a.dispose();
//             b.dispose();
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//     
//	public  int GetPeopleAddress() throws NativeException, IllegalAccessException, BOSException 
//    {
//          JNative n = null;           
//          try 
//          {
//             n = new JNative("Termb.dll", "GetPeopleAddress"); 
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型 
//             Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
//             Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
//             n.setParameter(0,b);
//             n.setParameter(1,a);              
//             n.invoke(); 
//             byte[] by = new byte[120];             
//             by = b.getMemory();
//            try 
//            {
//                strTmp = new String(by,"gb2312");
//            } 
//            catch (UnsupportedEncodingException ex) 
//            {
////                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
//            	throw new BOSException(ex);
//            }
//
//             len = a.getAsInt(0);
//             
//             a.dispose();
//             b.dispose();
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//      
//	public  int GetPeopleIDCode() throws NativeException, IllegalAccessException, BOSException 
//    {
//          JNative n = null;           
//          try 
//          {
//             n = new JNative("Termb.dll", "GetPeopleIDCode"); 
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型 
//             Pointer a = new Pointer(MemoryBlockFactory.createMemoryBlock(4*10));
//             Pointer b = new Pointer(MemoryBlockFactory.createMemoryBlock(4*30));
//             n.setParameter(0,b);
//             n.setParameter(1,a);              
//             n.invoke(); 
//             byte[] by = new byte[120];             
//             by = b.getMemory();
//            try 
//            {
//                strTmp = new String(by,"gb2312");
//            } 
//            catch (UnsupportedEncodingException ex) 
//            {
////                Logger.getLogger(CVR100DemoView.class.getName()).log(Level.SEVERE, null, ex);
//            	throw new BOSException(ex);
//            }
//
//             len = a.getAsInt(0);
//             
//             a.dispose();
//             b.dispose();
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//    
//	public  int CVR_Authenticate() throws NativeException, IllegalAccessException 
//    {
//          JNative n = null;
//          try 
//          {
//             n = new JNative("Termb.dll", "CVR_Authenticate"); 
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型                              
//             n.invoke(); // 调用方法
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//    
//	public  int CVR_Read_Content(int Active) throws NativeException, IllegalAccessException 
//    {
//          JNative n = null;
//          try 
//          {
//             n = new JNative("Termb.dll", "CVR_Read_Content"); 
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型
//             n.setParameter(0, Active);                   
//             n.invoke(); // 调用方法
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//     }
//    
//	public  int CVR_CloseComm() throws NativeException,IllegalAccessException 
//    {
//          JNative n = null;
//          try 
//          {
//             n = new JNative("Termb.dll", "CVR_CloseComm"); 
//             n.setRetVal(org.xvolks.jnative.Type.INT); // 指定返回参数的类型                               
//             n.invoke(); // 调用方法
//             return Integer.parseInt(n.getRetVal());
//          } 
//          finally 
//          {
//             
//          }
//       }
//}
