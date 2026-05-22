package com.base;
import java.awt.Desktop;
import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass123 {
 
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

			}
		} catch (Exception e) {
			Assert.fail("ERROR:OCCURE DURING BROWSERLAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING URL LAUNCH");
		}
	}

	protected static void getTitle() {
		try {
			String title = driver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET THE TITLE");

		}
	}

	protected static void getCurrentUrl() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALUE PASSING");

		}
	}

	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATION TO");

		}
	}

	protected static void navigate(String name) {
		try {
			if (name.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (name.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (name.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATION ");

		}
	}

	protected static void elementClick(WebElement element) {
		
		element.click();

		
//		try {
//			element.click();
//		} catch (Exception e) {
//			Assert.fail("ERROR: OCCURE DURING ELEMENT CLICK");
//
//		}
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BROWSER CLOSE");

		}
	}

	protected static void passInput(WebElement element, String value) {
		// try {
		element.sendKeys(value);
//		}catch(Exception e) {
//			Assert.fail("ERROR: OCCURE DURING SENDkEY VALUE PASSING");

//		}
	}

	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET THE TEXT FROM ELEMENT ");
		}
	}

	protected static void getAttribute(WebElement element) {
		try {
			String attribute = element.getAttribute("");
			System.out.println(attribute);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET THE ATTRIBUTE");
		}
	}

	protected static void webElementMethod(WebElement element, String value) {
		try {
			if (value.equalsIgnoreCase("displayed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			} else if (value.equalsIgnoreCase("enabeled")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
			} else if (value.equalsIgnoreCase("selected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING WEBELEMENT METHODS ");

		}
	}

	protected static void getCurrentTabId() {
		try {
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET WINDOW HANDLING ");

		}
	}

	protected static void getAllTabId(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING WINDOW hANDLING");

		}
	}

	protected static void selectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			System.out.println(multiple);
			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALUE SELECTION");

		}
	}

	protected static void deselectOption(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			System.out.println(multiple);
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING VALUE DE SELECTION");

		}
	}

	protected static void getOptiions(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement allOptions : options) {
				String text = allOptions.getText();
				System.out.println(text);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET OPTION ");

		}
	}

	protected static void getAllSelectedOptions(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> selectedOptions = select.getAllSelectedOptions();
			for (WebElement allSelectedOption : selectedOptions) {
				String text = allSelectedOption.getText();
				System.out.println(text);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING GET ALL SELECT OPTIONS ");

		}
	}

	protected static void getFirstSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String text = firstSelectedOption.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING  GET FIRST SELECT OPTIONS ");

		}
	}

	protected static void alertSendKey(String value) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING ALERT SENDKEYS ");
		}
	}

	protected static void alertHandles(String name) {
		try {
			Alert alert = driver.switchTo().alert();
			if (name.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (name.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			} else if (name.equalsIgnoreCase("getText")) {
				System.out.println(alert.getText());
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING ALERT HANDLE ");

		}
	}

	protected static void mouseAction(String value, WebElement element1) {
		try {
			Actions action = new Actions(driver);
			if (value.equalsIgnoreCase("leftClick")) {
				action.click(element1).build().perform();
			} else if (value.equalsIgnoreCase("rightClick")) {
				action.contextClick(element1).perform();
			} else if (value.equalsIgnoreCase("doubleClick")) {
				action.doubleClick(element1).perform();
			} else if (value.equalsIgnoreCase("mouseHover")) {
				action.moveToElement(element1).perform();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING MOUSE ACTION ");
		}
	}

	protected static void dragAndDropMouseAction(WebElement element1, WebElement element2) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(element1, element2).perform();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING DRAG AND DROP ");

		}
	}

	protected static void keyboardAction(String value, WebElement element) {
		try {
			Robot robot = new Robot();
			if (value.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} else if (value.equalsIgnoreCase("tab")) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			} else if (value.equalsIgnoreCase("escape")) {
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
			} else if (value.equalsIgnoreCase("ctrlA")) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING KEYBOARD ACTION ");

		}
	}

	protected static void switchFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SWITCH THE FRAME");

		}
	}

	protected static void frameDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BACK TO THE MAIN FRAME ");

		}
	}

	protected static void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SWITCH THE FRAME BY USING INDEX ");
		}
	}

	protected static void switchToFrameByName(String name) {
		try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SWITCH THE FRAME BY USING NAME ");
		}
	}

	protected static void switchToFrameByElement(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SWITCH THE FRAME BY USING WEBELEMENT ");
		}
	}

	protected static void implicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING IMLICITYWAIT ");
		}
	}

	protected static void explicitWait(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			 wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING EXPLICITYWAIT ");
		}
	}
	protected static void explicitWait2(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			 wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING EXPLICITYWAIT ");
		}
	}

	protected static void takeScreenshotmethod(String value) {
		try {
			Date currentDate = new Date();
			String dataFile = currentDate.toString().replace(" ", "_").replace(":", "_");
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(".//screenshot//" + dataFile + ".png"));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING TAKESCREENSHOT");
		}
	}

	protected static void scrollUpScrollDown(int x, int y) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + x + "," + y + ")");

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCROLL UP AND SCROLL DOWN ");
		}
	}

	protected static void scrollInToVeiw(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCROLL IN TO VIEW ");
		}
	}

	protected static void clickJSE(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING CLICK USING JSE METHOD ");
		}
	}

	protected static void sendKeyUsingDocument(String name, String value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('" + name + "').value='" + value + "'");
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SEND KEY USING DOCUMEN ");
		}
	}
	public String getCellValue(String filePath, String sheetName, String columnName, int rowNum) {

		String value = "";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);

// Read header row (0th row)
			Row headerRow = sheet.getRow(0);
			Map<String, Integer> columnMap = new HashMap<>();

			for (Cell cell : headerRow) {
				columnMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
			}

			int colIndex = columnMap.get(columnName);

			Row dataRow = sheet.getRow(rowNum);
			Cell cell = dataRow.getCell(colIndex);

			DataFormatter formatter = new DataFormatter();
			value = formatter.formatCellValue(cell);

			workbook.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	protected static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING QUIT THE BROWSER ");
		}
	}

	protected static void validation(WebElement actual, String expected) {
		try {
			Assert.assertEquals(actual.getText(), expected);
			System.out.println(actual.getText());
		} catch (Exception e) {
			Assert.fail("ERROR:OCCURE DURING VALIDATION");
		}
	}
	protected static void explicitWait12(WebElement element, int time) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void extentReportStart(String location) {
		try {
		extentReports=new ExtentReports();
		file =new File(location);
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}catch(Exception e) {
		Assert.fail("ERROR: OCCURE DURING REPORT START ");
			}}
	public static void extentReportTearDown( String location)throws IOException {
		try {
			extentReports.flush();
			file=new File(location);
			Desktop.getDesktop().browse((file).toURI());
		}catch(Exception e) {
			Assert.fail("ERROR: OCCURE DURING REPORT TEARDOWN ");
			}}
	
	protected static void takeScreenshot1() throws IOException {
		try {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
		   String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		   File scrfile=screenshot.getScreenshotAs(OutputType.FILE);
		  File destfile=new File("Screenshot\\.png"+"_"+timeStamp+".png");
		  FileHandler.copy(scrfile,destfile);
		}catch(Exception e) {
			Assert.fail("ERROR: OCCURE DURING SCREENSHOT ");
			}}
	
	

}


