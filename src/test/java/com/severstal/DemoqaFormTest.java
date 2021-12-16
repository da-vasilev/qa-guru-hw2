package com.severstal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillStudentRegistrationForm () {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Patrick");
        $("#lastName").setValue("Star");
        $("#userEmail").setValue("PatrickSuperStar@lagoona.com");
        $x("//label[contains(., 'Male')]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(., 'Sports')]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/starPhoto.jpg"));
        $("#currentAddress").setValue("120 Conch Street, Bikini Bottom, Pacific Ocean");
        $("#state #react-select-3-input").setValue("NCR").pressEnter();
        $("#city #react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).should(appear);
        $(byText("Patrick Star")).should(appear);
        $(byText("PatrickSuperStar@lagoona.com")).should(appear);
        $(byText("Male")).should(appear);
        $(byText("1234567890")).should(appear);
        $(byText("17 August,1989")).should(appear);
        $(byText("English")).should(appear);
        $(byText("Sports")).should(appear);
        $(byText("starPhoto.jpg")).should(appear);
        $(byText("120 Conch Street, Bikini Bottom, Pacific Ocean")).should(appear);
        $(byText("NCR Delhi")).should(appear);
        $("#closeLargeModal").click();
    }
}
