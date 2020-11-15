package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class TestBoxTest {

    @Test
    void FillForms(){
        String name = "Alexander",
                surname = "Alexandrov",
                email = ("main@ya.ru"),
                phone = ("0123456789"),
                subjects = ("Maths"),
                currentAddress = ("Tosno"),
                state = ("NCR"),
                city = ("Delhi");

        File file = new File("src/test/java/docs/harold.jpg");



        open("https://demoqa.com/automation-practice-form");

        $("#firstName").val(name);
        $("#lastName").val(surname);
        $("#userEmail").val(email);
        $x("//*[@for='gender-radio-1']").click();
        $("#userNumber").val(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__day--024").click();
        $("#subjectsInput").val(subjects).pressEnter();
        $x("//*[@for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("*//tr[1]/td[2]").shouldHave(text("Alexander Alexandrov"));
        $x("*//tr[2]/td[2]").shouldHave(text("main@ya.ru"));
        $x("*//tr[3]/td[2]").shouldHave(text("Male"));
        $x("*//tr[4]/td[2]").shouldHave(text("0123456789"));
        $x("*//tr[5]/td[2]").shouldHave(text("24 February,1983"));
        $x("*//tr[6]/td[2]").shouldHave(text("Maths"));
        $x("*//tr[7]/td[2]").shouldHave(text("Reading"));
        $x("*//tr[8]/td[2]").shouldHave(text("harold.jpg"));
        $x("*//tr[9]/td[2]").shouldHave(text("Tosno"));
        $x("*//tr[10]/td[2]").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();


    }
}
