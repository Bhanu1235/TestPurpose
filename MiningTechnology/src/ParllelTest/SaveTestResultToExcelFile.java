package ParllelTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterSuite;
import java.io.*;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Test
public class SaveTestResultToExcelFile{

	 public static void main(String[] args) throws InterruptedException { 
		 WebDriver driver;
		  
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		    driver = new ChromeDriver();

	         driver = new ChromeDriver();

	        driver.get("http://www.mining-technology.com/");
	       

	        driver.manage().window().maximize();  
	       
	        WebElement SearchValuename = driver.findElement(By.xpath(".//*[@id='content-container']/header/div[2]/div[2]/form/fieldset/input"));
	        SearchValuename.click();
	        
	       

	 try {
	    
	 FileInputStream file = new FileInputStream(new File("C:/Users/kbprasanth/Desktop/n.xls")); 
	HSSFWorkbook workbook = new HSSFWorkbook(file);
	  
	  

	  HSSFSheet sheet = workbook.getSheetAt(0);

	        Cell resultCell= sheet.getRow(1).createCell(3);
	      
	        String 
 = sheet.getRow(1).getCell(2).getStringCellValue();
	        
//	        WebElement Search = driver.findElement(By.xpath(".//*[@id='content-container']/header/div[2]/div[2]/form/fieldset/input"));
//	        
//	        Search.click();
	       
	        SearchValuename.sendKeys(Searchname);
	        

	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	        String Searchtext="Materials" ;
	       

	        if(Searchtext.equals(Searchname)){
	                System.out.println("set is successful.");
	                resultCell.setCellValue("PASS");
	                driver.findElement(By.xpath(".//*[@id='content-container']/header/div[2]/div[2]/form/fieldset/button")).click();
	        }
	        
	        else 
	        {
	                System.out.println("set is not successful.");
	                resultCell.setCellValue("FAIL");
	        }
	       

	  
	  //file.close();

	  FileOutputStream outFile =new FileOutputStream(new File("C:/Users/kbprasanth/Desktop/n.xls"));
	  workbook.write(outFile);
	  outFile.close();

	 } catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace();
	 } catch (IOException e) {
	  e.printStackTrace();
	 }
	 }
	
	 
	 @AfterSuite
	 public void AfterSuite(){
	 Properties props = new Properties();
		   
	 // this will set host of server- you can change based on your requirement 
	  		props.put("mail.smtp.host", "smtp.gmail.com");
	   
	  		// set the port of socket factory 
	  		props.put("mail.smtp.socketFactory.port", "465");
	   
	  		// set socket factory
	  		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	   
	  		// set the authentication to true
	  		props.put("mail.smtp.auth", "true");
	   
	  		// set the port of SMTP server
	  		props.put("mail.smtp.port", "465");
	   
	  		// This will handle the complete authentication
	  		Session session = Session.getDefaultInstance(props,
	   
	  				new javax.mail.Authenticator() {
	   
	  					protected PasswordAuthentication getPasswordAuthentication() {
	   
	  					return new PasswordAuthentication("prasanth.kolluri@gmail.com", "Bhanu1436");
	   
	  					}
	   
	  				});
	   
	  		try {
	   
	  			// Create object of MimeMessage class
	  			Message message = new MimeMessage(session);
	   
	  			// Set the from address
	  			message.setFrom(new InternetAddress("prasanth.kolluri@gmail.com"));
	   
	  			// Set the recipient address
	  			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("prasanth.kolluri@gmail.com"));
	              
	                          // Add the subject link
	  			message.setSubject("Testing Subject");
	   
	  			// Create object to add multimedia type content
	  			BodyPart messageBodyPart1 = new MimeBodyPart();
	   
	  			// Set the body of email
	  			messageBodyPart1.setText("This is message body");
	   
	  			// Create another object to add another content
	  			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	   
	  			// Mention the file which you want to send
	  			String filename = "C:/Users/kbprasanth/Desktop/n.xls";
	   
	  			// Create data source and pass the filename
	  			DataSource source = new FileDataSource(filename);
	   
	  			// set the handler
	  			messageBodyPart2.setDataHandler(new DataHandler(source));
	   
	  			// set the file
	  			messageBodyPart2.setFileName(filename);
	   
	  			// Create object of MimeMultipart class
	  			Multipart multipart = new MimeMultipart();
	   
	  			// add body part 1
	  			multipart.addBodyPart(messageBodyPart2);
	   
	  			// add body part 2
	  			multipart.addBodyPart(messageBodyPart1);
	   
	  			// set the content
	  			message.setContent(multipart);
	   
	  			// finally send the email
	  			Transport.send(message);
	   
	  			System.out.println("=====Email Sent=====");
	   
	  		} catch (MessagingException e) {
	   
	  			throw new RuntimeException(e);
	  		}
		  }
		  
	  }

	   
	 
	  
	  
	 
	 
  
 
 
 


	  
	   
	  
  


