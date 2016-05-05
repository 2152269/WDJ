import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by 20912 on 14/04/2016.
 */
public class imdbWebDirver {
    @Test
    public void imdbTest() {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.imdb.com");;
        // And now use this to visit Google
        //driver.get("http://www.imdb.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Blade Runner");
        // Now submit the form. WebDriver will find the form for us from the element5 José Carlos Bregieiro Ribeiro, 2016 | INSTITUTO POLITÉCNICO DE LEIRIA
        element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("find");
            }
        });
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        //Close the browser
        driver.quit();
    }

}