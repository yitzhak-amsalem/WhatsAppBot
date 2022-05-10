import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class M1 {
    public static void main(String[] args) {

        int[] surrogates = {0xD83D, 0xDC7D};
        String alienEmojiString = new String(surrogates, 0, surrogates.length);
        System.out.println(alienEmojiString);
        System.out.println("\uD83D\uDC7D");
        System.out.println("\uD83D\uDE00");

/*        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\יצחק אמסלם\\Documents\\לימודים\\שנה א\\סמסטר ב\\סדנא לתכנות\\chromedriver.exe");
        String chromeProfilePath = "C:\\Users\\יצחק אמסלם\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions chromeProfile = new ChromeOptions();
        chromeProfile.addArguments("chrome.switches", "--disable-extensions");
        chromeProfile.addArguments("user-data-dir=" + chromeProfilePath);
        WebDriver driver = new ChromeDriver(chromeProfile);
        driver.get("https://web.whatsapp.com/");*/

    }
}
