package TestCases;

import Hooks.TestBase;
import Utilities.ConfigurationReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class facebookCredentials extends TestBase {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    @Test
    public void log() throws InterruptedException, IOException {
        driver.get(ConfigurationReader.get("url3"));
     WebElement cookies=  driver.findElement(By.xpath("//button[text()='Allow essential and optional cookies']"));
     cookies.click();
     Thread.sleep(3000);

        // Import excel sheet.
        File src=new File("src/test/resources/Test.xlsx");
// Load the file.
        FileInputStream fis = new FileInputStream(src);
// Load he workbook.
        workbook = new XSSFWorkbook(fis);
// Load the sheet in which data is stored.
        sheet= workbook.getSheet("Sheet0");
        for(int i=1; i<=sheet.getLastRowNum(); i++){
/*I have added test data in the cell A2 as "testemailone@test.com" and B2 as "password"
Cell A2 = row 1 and column 0. It reads first row as 0, second row as 1 and so on
and first column (A) as 0 and second column (B) as 1 and so on*/
// Import data for Email.
            cell = sheet.getRow(i).getCell(0);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
// Import data for password.
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.id("pass")).clear();
            driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());
// To click on Login button
            driver.findElement(By.id("u_0_5_Q/")).click();
//To write data in the excel
            FileOutputStream fos=new FileOutputStream(src);
// Message to be written in the excel sheet
            String message = "Pass";
            // Create cell where data needs to be written.
            sheet.getRow(i).createCell(2).setCellValue(message);

            // finally write content
            workbook.write(fos);
// To click on Account settings dropdown
            driver.findElement(By.xpath("//div[text()='Account Settings']")).click();
// To click on logout button
            driver.findElement(By.xpath("//text()[.='Log Out']/ancestor::span[1]")).click();
// close the file
            fos.close();



        }
    }
    }

