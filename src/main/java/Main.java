import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.util.List;


public class Main {
    public static final int FIRST_ELEMENT = 0;
    public static final int MIN_COURSE_NUMBER = 1;
    public static final int EXIT_LOCATION = 1;
    public static final int SLEEP = 1000;

    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        String userName = str.nextLine();
        String password = str.nextLine();*/
        String csvFile = "names.csv";
        BufferedReader br = null;
        String line = "";
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
            String[] b = {"השלמות שיעורים","הקניות הבאות","מניינים ופינוקים","יסכה"};
/*            //            br = new BufferedReader(new FileReader(csvFile));
            System.out.println("OK");
          //  br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null){
               driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]")).click();
            }*/
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]")).click();
            WebElement ser = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]"));
/*            for (int i = 0; i < b.length; i++){
                ser.sendKeys(b[i] + "\n");
                Thread.sleep(1000);
                WebElement mes = driver.findElement(By.cssSelector("body.web:nth-child(2) div._1ADa8._3Nsgw.app-wrapper-web.font-fix.os-win div._1XkO3.two:nth-child(6) div.ldL67._3sh5K:nth-child(4) div._3xTHG footer._2cYbV:nth-child(7) div._2BU3P.tm2tP.copyable-area div._1SEwr div._6h3Ps div._2lMWa div.p3_M1._1YbbN div._1UWac._1LbR4 > div._13NKt.copyable-text.selectable-text"));
                Thread.sleep(1000);
                mes.sendKeys("If you received this message, it's even though I did not scan the WhatsApp barcode?" + "\n");
                Thread.sleep(3000);
            }*/
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
            }*/
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
            StringBuilder allText = new StringBuilder();
            try {
                List<WebElement> mes6 = driver.findElements(By.className("_1Gy50"));
                System.out.println("mes6: " + mes6.size());

                for (int i = 0; i < mes6.size(); i++){
                    allText.append(mes6.get(i).getText());
                }
                System.out.println(allText);
            } catch (Exception e) {
                System.out.println("mes6");
            }
/*            Thread.sleep(3000);
            ser.sendKeys("ברק" + "\n");
            Thread.sleep(3000);
            mes = driver.findElement(By.xpath("//div[@class=\"p3_M1 _1YbbN\"]"));*/

            String text = allText.toString();
            String[] t1 = text.split("\n");
            StringBuilder ss = new StringBuilder();
            for (String s: t1){
                ss.append(s);
            }

            int count = 0;
            String textToSearch = "מזל טוב";
            count = countAppearance(ss, textToSearch);
            String textToSend = "This chat was sent " + count + " times mazal tov, so you deserve Mazal Tov from the bot!";
            String textToSend1 = "disappointing. There is no Mazal Tov in this group";
            System.out.println(count);
            ser.sendKeys("סטארטאפ בהקמה" + "\n");
            Thread.sleep(3000);
            WebElement mes = driver.findElement(By.xpath("//div[@class=\"p3_M1 _1YbbN\"]"));
            Thread.sleep(4000);
            if (count >= 5){
                mes.sendKeys(textToSend + "\n");
            } else {
                mes.sendKeys(textToSend1 + "\n");
            }

//            printMessage(driver, ss);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void printMessage(WebDriver driver, StringBuilder allText){
        int count = 0;
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