package com.haier.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class ReadFile {
    public static void readTxtFile(String filePath) {
       InfoBean infoBean=new InfoBean();
       try {
           String encoding = "GBK";
           File file = new File("F://ProtocolDebugger//TData.txt");
           if (file.isFile() && file.exists()){ //判断文件是否存在
               InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
               BufferedReader bufferedReader = new BufferedReader(read);
               String lineTxt = null;
               int recordCount = 0;
               OperationDB operationDB=new OperationDB();
               List<String> arrayList = new ArrayList<String>();
               while ((lineTxt = bufferedReader.readLine()) != null) {
	            	 //如果行中包含...，将其打印输出并将其放到数据库中
	               	CharSequence cs1 = "...";
	               	CharSequence cs2 = "成功";
	               	CharSequence cs3 = "失败";
	               	if(lineTxt.contains(cs1)){                
	               		recordCount++;					//计数器，统计行数
	               		System.out.println("RecordCount = " + recordCount);//输出文件行数
	               		//arrayList.add(lineTxt);
	               		System.out.println(lineTxt);
	               		infoBean.setSend(lineTxt);		//将数据加入send中
	               		
	                       
	               	}else if(lineTxt.contains(cs2) || lineTxt.contains(cs3)){
	               		//System.out.println(lineTxt);	//逐行输出打印到控制台
	               		infoBean.setRecive(lineTxt);		//将数据加入get中
	               	}
                  
	               	operationDB.addRcorder(infoBean);                          
               }
               
               read.close();
           } else {
               System.out.println("找不到指定的文件");
           }
       } catch (Exception e) {
           System.out.println("读取文件内容出错");
           e.printStackTrace();
       }
    }
    /*
    public static void main(String argv[]){
        String filePath = "F://ProtocolDebugger//TData.txt";
        readTxtFile(filePath);
    }
    */
}
