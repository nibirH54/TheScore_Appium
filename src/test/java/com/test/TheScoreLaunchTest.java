package com.test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class TheScoreLaunchTest {

    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {
        //App launch and Initialization code
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("nibir-test-device");
        options.setApp(System.getProperty("user.dir")+"/app/theScore_24.4.0_apkcombo.com.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        Thread.sleep(4000);

        //App Navigates and select different settings
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/action_button_text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/action_button_text']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/btn_allow']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name' and @text='New York Yankees']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/action_button_text']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/action_button_text']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")).click();
        Thread.sleep(3000);

        //App clicks on a specific team
        driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.fivemobile.thescore:id/icon_team_logo']")).click();
        Thread.sleep(3000);

        //Verify the respective team Name on the Page
        String teamName = driver.findElement(By.id("com.fivemobile.thescore:id/team_name")).getText();
        System.out.println(teamName);
        Thread.sleep(3000);

        //Click on the sub tab Schedule to see the team's upcoming games
        driver.findElement(By.xpath("//android.widget.TextView[@text='SCHEDULE']")).click();
        Thread.sleep(5000);

        //Navigate back to the Teams Main Page
        driver.navigate().back();




    }


}
