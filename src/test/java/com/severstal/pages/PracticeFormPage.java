package com.severstal.pages;

import com.severstal.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * <b>Page Practice Form web site Demoqa</b>
 * @author da.vasilev
 */
public class PracticeFormPage {

    /**
     *  <b>Fills out the form on the page</b>
     * @return this
     */
    public PracticeFormPage setStudentRegistrationForm(TestData testData) {
        $("#firstName").setValue(testData.getFirstName());
        $("#lastName").setValue(testData.getLastName());
        $("#userEmail").setValue(testData.getUserEmail());
        $x("//label[contains(., 'Male')]").click();
        $("#userNumber").setValue(testData.getUserNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(testData.getDateOfBirth()[1]);
        $(".react-datepicker__year-select").selectOption(testData.getDateOfBirth()[2]);
        $(String.format(".react-datepicker__day--0%s", testData.getDateOfBirth()[0])).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(., 'Sports')]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/starPhoto.jpg"));
        $("#currentAddress").setValue(testData.getCurrentAddress());
        $("#state #react-select-3-input").setValue("NCR").pressEnter();
        $("#city #react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo();
        $("#submit").click();
        return this;
    }

    /**
     *  <b>Validates the form on the page</b>
     * @return this
     */
    public PracticeFormPage checkStudentRegistrationForm(TestData testData) {
        $(byText("Thanks for submitting the form")).should(appear);
        $(byText(String.format("%s %s", testData.getFirstName(), testData.getLastName()))).should(appear);
        $(byText(testData.getUserEmail())).should(appear);
        $(byText("Male")).should(appear);
        $(byText(testData.getUserNumber())).should(appear);
        $(byText(String.format("%s %s,%s",
                testData.getDateOfBirth()[0],
                testData.getDateOfBirth()[1],
                testData.getDateOfBirth()[2]))).should(appear);
        $(byText("English")).should(appear);
        $(byText("Sports")).should(appear);
        $(byText("starPhoto.jpg")).should(appear);
        $(byText(testData.getCurrentAddress())).should(appear);
        $(byText("NCR Delhi")).should(appear);
        return this;
    }
}
