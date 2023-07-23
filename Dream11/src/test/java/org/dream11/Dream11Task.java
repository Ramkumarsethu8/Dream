package org.dream11;

import java.net.MalformedURLException;
import java.util.List;

import org.libglobal.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Dream11Task extends BaseClass {

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		launchApp();
		implicitWait(20);
	}

	@Test(priority = 1)
	public void languageSelection() {
		MobileElement optEnglish = driver.findElement(
				MobileBy.xpath("//*[@resource-id='com.dream11.fantasy.cricket.football.kabaddi:id/2131363432']"));
		elementTap(optEnglish);

		MobileElement btnContinue = driver.findElement(MobileBy.xpath("//*[@text='CONTINUE']"));
		elementTap(btnContinue);
	}

	@Test(priority = 2)
	public void login() {
		MobileElement loginButton = driver.findElement(MobileBy.xpath("//*[@text='Log In']"));
		elementTap(loginButton);
		MobileElement enterNumber = driver.findElement(MobileBy.xpath(
				"//android.view.ViewGroup[@content-desc=\"Login\"]//child::android.view.ViewGroup//child::android.widget.EditText[@content-desc=\"mobile-email-edit-field\"]"));
		elementSendKeys(enterNumber, "6383530160");

		MobileElement ageCheckBox = driver
				.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"age_verify_checkbox\"]"));
		elementTap(ageCheckBox);

		MobileElement nextButton = driver
				.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"btn_next\"]"));
		elementTap(nextButton);
		MobileElement allowOtp = driver.findElement(MobileBy.xpath("//*[@text='Allow']"));
		elementTap(allowOtp);
	}

	@Test(priority = 3)
	public void joinNewContest() {
		MobileElement selectCricket = driver.findElement(
				MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"tagCricket\"]/android.view.ViewGroup"));
		elementTap(selectCricket);
		MobileElement selectMatch = driver.findElement(MobileBy.xpath(
				"//android.view.ViewGroup[@content-desc=\"Match_Card_1\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));
		elementTap(selectMatch);
		MobileElement selectContest = driver.findElement(MobileBy.xpath(
				"(//android.view.ViewGroup[@content-desc=\"Contest_Cards\"])[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup"));
		elementTap(selectContest);
		MobileElement btnJoin = driver.findElement(MobileBy.AccessibilityId("btn_join"));
		elementTap(btnJoin);

		MobileElement createTeamButton = driver.findElement(MobileBy.AccessibilityId("fpsCreateTeamLbl"));
		elementTap(createTeamButton);
	}

	@Test(priority = 4)
	public void selectWicketKeepers() {
		MobileElement wkSelection = driver.findElement(MobileBy.xpath("//*[@text='WK (0)']"));
		elementTap(wkSelection);
		List<MobileElement> wkList = driver
				.findElements(MobileBy.xpath("//*[@resource-id='add-remove-player-button']"));
		elementClick(wkList.get(0));
		elementClick(wkList.get(1));

	}

	@Test(priority = 5)
	public void selectBatters() {
		MobileElement batSelection = driver.findElement(MobileBy.xpath("//*[@text='BAT (0)']"));
		elementTap(batSelection);
		List<MobileElement> batList = driver
				.findElements(MobileBy.xpath("//*[@resource-id='add-remove-player-button']"));
		elementClick(batList.get(0));
		elementClick(batList.get(1));
		elementClick(batList.get(2));
	}

	@Test(priority = 6)
	public void selectAllRounders() {
		MobileElement arSelection = driver.findElement(MobileBy.xpath("//*[@text='AR (0)']"));
		elementTap(arSelection);
		List<MobileElement> arList = driver
				.findElements(MobileBy.xpath("//*[@resource-id='add-remove-player-button']"));
		elementClick(arList.get(0));
		elementClick(arList.get(1));
		elementClick(arList.get(2));
	}

	@Test(priority = 7)
	public void selectBowlers() {
		MobileElement bowlSelection = driver.findElement(MobileBy.xpath("//*[@text='BOWL (0)']"));
		elementTap(bowlSelection);
		List<MobileElement> bowlerList = driver
				.findElements(MobileBy.xpath("//*[@resource-id='add-remove-player-button']"));
		elementClick(bowlerList.get(0));
		elementClick(bowlerList.get(1));
		elementClick(bowlerList.get(2));

		MobileElement nextButton = driver.findElement(MobileBy.AccessibilityId("create-team-NEXT-button"));
		elementTap(nextButton);
	}

	@Test(priority = 8)
	public void selectCaptainAndViceCaptain() {
		List<MobileElement> captainList = driver
				.findElements(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Captain-element\"]"));
		elementClick(captainList.get(2));

		List<MobileElement> viceCaptainList = driver
				.findElements(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Vice Captain-element\"]"));
		elementClick(viceCaptainList.get(4));

		MobileElement btnSave = driver.findElement(MobileBy.AccessibilityId("create-team-SAVE-button"));
		elementTap(btnSave);
	}

	@AfterClass
	public void afterClass() {
		quitApp();
	}

}
