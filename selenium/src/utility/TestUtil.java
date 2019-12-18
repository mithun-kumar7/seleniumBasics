package utility;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> mydata= new ArrayList<Object[]>();
		try {
			reader= new Xls_Reader("E:\\Java_code\\selenium\\src\\TestData\\testData.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("ebay");rowNum++) {
			String first_name=reader.getCellData("ebay", "firstname", rowNum);
			String last_name=reader.getCellData("ebay", "lastname", rowNum);
			String email_id=reader.getCellData("ebay", "email", rowNum);
			String pass_word=reader.getCellData("ebay", "password", rowNum);
			
			Object obj[]= {first_name,last_name,email_id,pass_word};
			mydata.add(obj);
		}
		return mydata;
		
	}

}
