import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;


public class Main {

    public static void main(String[] args) {
/*        String csvFile = "names.csv";
        BufferedReader br = null;
        String line = "";*/
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\יצחק אמסלם\\Documents\\לימודים\\שנה א\\סמסטר ב\\סדנא לתכנות\\chromedriver.exe");
        String chromeProfilePath = "C:\\Users\\יצחק אמסלם\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions chromeProfile = new ChromeOptions();
        chromeProfile.addArguments("chrome.switches", "--disable-extensions");
        chromeProfile.addArguments("user-data-dir=" + chromeProfilePath);
        WebDriver driver = new ChromeDriver(chromeProfile);
        driver.get("https://web.whatsapp.com/");

        try {
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
 //           String[] b = {"השלמות שיעורים","הקניות הבאות","מניינים ופינוקים","יסכה"};
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]")).click();
            WebElement ser = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]"));
            ser.sendKeys("סטארטאפ בהקמה" + "\n");
            Thread.sleep(3000);
/*            try {
                WebElement mes4 = driver.findElement(By.xpath("//div[@class=\"p3_M1 _1YbbN\"]"));//p3_M1
                String t = "ewew";
                Thread.sleep(2000);
                mes4.sendKeys(t);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("mes4");
            }
//            try {
//                List<WebElement> mes5 = driver.findElements(By.className("_22Msk"));
//                System.out.println("mes5: " + mes5.size());
//                StringBuilder allText1 = new StringBuilder("win");
//                for (WebElement webElement: mes5){
//                    allText1.append(webElement.getText());
//                }
//                System.out.println(allText1 + "\n\n\n");
//            } catch (Exception e) {
//                System.out.println("mes5");
//            }
*/
            StringBuilder allText = new StringBuilder();
            try {
                List<WebElement> messages = driver.findElements(By.className("_1Gy50"));
                System.out.println("messages: " + messages.size());
                for (WebElement webElement: messages){
                    allText.append(webElement.getText());
                }
                //System.out.println(allText);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String text = allText.toString();
            String[] t1 = text.split("\n");
            StringBuilder splitText = new StringBuilder();
            for (String s: t1){
                splitText.append(s);
            }

            int count;
            String textToSearch = "מזל טוב";
            count = countAppearance(splitText, textToSearch);
            String textToSend = "This chat was sent " + count + " times mazal tov, so you deserve Mazal Tov from the bot!";
            String textToSend1 = "disappointing. There is no Mazal Tov in this group";
            System.out.println(count + " times mazal tov");
            ser.sendKeys("סטארטאפ בהקמה" + "\n");
            Thread.sleep(3000);
            WebElement mes = driver.findElement(By.xpath("//div[@class=\"p3_M1 _1YbbN\"]"));
            Thread.sleep(3000);
            if (count >= 5){
                mes.sendKeys(textToSend + "\n");
            } else {
                mes.sendKeys(textToSend1 + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void printMessage(WebDriver driver, StringBuilder allText){
        int count;
        String textToSearch = "מזל טוב";
        String textToSend = "mazal tov from the bot!";
        count = countAppearance(allText, textToSearch);
        System.out.println(count);
        if (count >= 5){
            WebElement ser = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]"));
            ser.sendKeys("השלמות שיעורים");
            WebElement mes = driver.findElement(By.xpath("//div[@class=\"p3_M1 _1YbbN\"]"));
            mes.sendKeys(textToSend + "\uD83D\uDC7D" + "\n");

 /*            int[] surrogates = {0xD83D, 0xDC7D};
           String alienEmojiString = new String(surrogates, 0, surrogates.length);
            System.out.println(alienEmojiString);
            System.out.println("\uD83D\uDC7D");*/
        }


    }

    public static int countAppearance (StringBuilder allTitlesText, String text) {
        int count = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < allTitlesText.length(); i++) {
            char checkWord = allTitlesText.charAt(i);
            if ((checkWord >= 'א' && checkWord <= 'ת') || checkWord == '"' || checkWord == ' ' ||
                    (checkWord >= '0' && checkWord <= '9') || (checkWord >= 'A' && checkWord <= 'Z') || (checkWord >= 'a' && checkWord <= 'z')) {
                if (!(checkWord == '"')) {
                    word.append(checkWord);
                    if (word.toString().contains(text)) {
                        count++;
                        word = new StringBuilder();
                    }
                }
            }
        }
        return count;
    }

}