package Methods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

public class demoQA{
    private static WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);
    public void visitHomePage(String target){
        driver.get(target);
    }

    public void scrollTo(int scrollTo) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, "+scrollTo+")");
    }

    public void clickTheElement(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
    }
    public void typeInTheBox(String cssSelector, String body){
        WebElement box = driver.findElement(By.cssSelector(cssSelector));
        box.sendKeys(body);
    }
    public void getTextAndAssert(String cssSelector,String userData){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        String divText = element.getText();
        System.out.println(divText);
        Assert.assertTrue(divText.contains(userData), "Text doesn't contain /" +'"' + userData +'"');
    }

    public void toggleClick(String[] list) throws InterruptedException {
        for (int i = 0; i < list.length; i++) {
            WebElement element = driver.findElement(By.cssSelector(list[i]));
            element.click();
            Thread.sleep(1000);
        }
    }
    public void assertThatExists(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        Assert.assertNotNull(element);
    }

    public void hoverOver(String cssSelector){
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        action.moveToElement(element).build().perform();

    }

    public void dragAndDrop(String from, String to){
        WebElement fromElement = driver.findElement(By.cssSelector(from));
        WebElement toElement = driver.findElement(By.cssSelector(to));
        action.dragAndDrop(fromElement, toElement).build().perform();

    }

    public void resize(String boxCssSelector, String handleCssSelector, int width, int height){
        WebElement resizableBox = driver.findElement(By.cssSelector(boxCssSelector));
// Use Actions class to click and hold the edge of the resizable box
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizableBox.findElement(By.cssSelector(handleCssSelector)))
                .moveByOffset(width, height)
                .perform();
    }


}
