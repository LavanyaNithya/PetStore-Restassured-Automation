package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException
	{
		
		String path = ".\\testData\\Petstore userdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int rowcount = xl.getRowCount("Sheet1");
		int cellcount = xl.getCellCount("Sheet1", 1);
		String data[][] = new String[rowcount-1][cellcount];
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				
				data[i-1][j] = xl.getCellData("Sheet1", i, j);
				
			}
			
		}
		
		
		return data;
}
		
	@DataProvider(name = "Usernames")	
     public String[] getUserNames() throws IOException
      {
    	  
    	  String path = ".\\testData\\Petstore userdata.xlsx";
    	  ExcelUtility xl = new ExcelUtility(path);
  		  int rowcount = xl.getRowCount("Sheet1");
  		  String usernames[] = new String[rowcount-1];
    	  for(int i=1;i<rowcount;i++)
    	  {
    		  usernames[i-1] = xl.getCellData("Sheet1", i, 1);
    	  }
    	  
    	  return usernames;
      }
      
      

}
