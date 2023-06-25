import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Алекс\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver); // создали экземпляр экшенс, будем перетаскивать один элемент в другой

            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();
             // обращаемся к actions и начинаем вызывать методы: навести курсор, кликнуть и задержать, навести курсор, отпустить, собрать, запустить

            // или же более простой метод: actions.dragAndDrop(); Он сделает всё автоматически.

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
