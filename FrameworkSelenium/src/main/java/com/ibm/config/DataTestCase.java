package com.ibm.config;

import org.testng.annotations.DataProvider;

import com.ibm.utils.ExcelFunction;
import com.ibm.utils.Xls_Reader;

public class DataTestCase {
	
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ibm\\config\\TestData.xlsx");
	
	@DataProvider(name = "AccountCreation")
	public Object[][]CreateAccount(){
		
//		Object[][] obj = new Object[3][7];
//		
//		//First Script Run Data
//		obj[0][0] = "Kaushik Mukherjee"; //Full Name
//		obj[0][1] = "testibmSel"; //Choose Rediffmail id
//		obj[0][2] = "test@1234"; //Password
//		obj[0][3] = "test@1234"; //Retype Password
//		obj[0][4] = "Pasta"; //Enter the Security Question NAswer
//		obj[0][5] = "Sukla"; //Mother's Maiden Name
//		obj[0][6] = "9945515744"; //Mobile Number
//		
//		//Second Script Run Data
//		obj[1][0] = "Sam Mendes"; //Full Name
//		obj[1][1] = "testibmSelHello"; //Choose Rediffmail id
//		obj[1][2] = "test@5678"; //Password
//		obj[1][3] = "test@5678"; //Retype Password
//		obj[1][4] = "Burger"; //Enter the Security Question NAswer
//		obj[1][5] = "Hanna"; //Mother's Maiden Name
//		obj[1][6] = "9674563625"; //Mobile Number
//		
//		//Second Script Run Data
//		obj[2][0] = "Peter M"; //Full Name
//		obj[2][1] = "testibmDjangoFramework"; //Choose Rediffmail id
//		obj[2][2] = "test@0343"; //Password
//		obj[2][3] = "test@0343"; //Retype Password
//		obj[2][4] = "Pizza"; //Enter the Security Question NAswer
//		obj[2][5] = "Revanna"; //Mother's Maiden Name
//		obj[2][6] = "4567890344"; //Mobile Number
//		
//		
//		return obj;
		
		return ExcelFunction.ReadExcel("CreateAccountRediffmailTest", xls);
		
		}
	
	@DataProvider(name = "SendMail")
	public Object[][]SendMailData(){
		
		return ExcelFunction.ReadExcel("SendMailRediffmailTest", xls);
		
	}

}
