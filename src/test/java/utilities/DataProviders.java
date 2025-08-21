package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider1
	
    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
        // Path to Excel file
        String path = ".\\testData\\Opencart_LoginData.xlsx";

        // Create Excel utility object
        ExcelUtility xlutil = new ExcelUtility(path);

        // Get row and column count
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Create 2D array
        String loginData[][] = new String[totalrows][totalcols];

        // Read data from Excel (excluding header)
        for(int i=1; i<=totalrows; i++)   // i starts from 1 (skip header row) 
        {
            for(int j=0; j<totalcols; j++)   // j starts from 0
            {
                loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);    // [i-1] -- as per array index start from 0. so we are storing row in 0th position
            }
        }

        return loginData;   // return 2D array to test
    }
    
    
  //DataProvider 2
  //DataProvider 3
  //DataProvider 4
    
}
