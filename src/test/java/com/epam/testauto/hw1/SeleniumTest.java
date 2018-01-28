package com.epam.testauto.hw1;

import static com.epam.testauto.Constants.*;
import static com.epam.testauto.User.USER_LOGIN;
import static com.epam.testauto.User.USER_NAME;
import static com.epam.testauto.User.USER_PASS;
import static org.junit.Assert.assertEquals;

import com.epam.testauto.TextBlock;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SeleniumTest extends WebDriverSettings {

    @Test
    public void firstTest() {
//        1. Open test site by URL	https://jdi-framework.github.io/tests
        driver.get(PAGE_URL);

//        2. Assert Browser title	"Index page"
        assertEquals(driver.getTitle(), PAGE_TITLE);

//        3. Perform login	username: epam, pass: 1234
        driver.findElement(By.cssSelector("li.dropdown.uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys(USER_LOGIN);
        driver.findElement(By.id("Password")).sendKeys(USER_PASS);
        driver.findElement(By.cssSelector(".btn-login")).click();

//        4. Assert User name in the left-top side of screen that user is loggined	"Piter Chailovskii"
        assertEquals(USER_NAME,
                driver.findElement(By.cssSelector(".profile-photo > span")).getText());

//        5. Assert Browser title	"Index page"
        assertEquals(PAGE_TITLE, driver.getTitle());

//        6. Assert that there are 4 images on the Home Page and they are displayed	(4 images)
        assertEquals(4, driver.findElements(By.cssSelector(".icons-benefit")).size());

//        7.1 Assert that there are 4 texts on the Home Page
        List<WebElement> textBlocks = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(4, textBlocks.size());

        for (int i = 0; i < textBlocks.size(); i++) {
            String textInTheBlock = textBlocks.get(i).getText().replaceAll("\n", " ");
//        7.2   and check them by getting texts 	(4 texts below of each image)
            assertEquals(TextBlock.values()[i].text, textInTheBlock);
        }

//        8. Assert that there are the main header and the text below it on the Home Page
        assertEquals(HEADER, driver.findElement(By.cssSelector("h3.main-title")).getText());
        assertEquals(MAIN_BLOCK_TEXT, driver.findElement(By.cssSelector("p.main-txt")).getText());
    }
}
