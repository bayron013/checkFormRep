package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String year, String mounth, String day) {
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
    }

}
