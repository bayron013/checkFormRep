package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String year, String mounth, String day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(mounth);
        if (Integer.parseInt(day) < 10) {
            $(".react-datepicker__day--00" + day + ":not(.react-datepicker__day--outside-month)").click();

        } else {
            $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        }
    }

}
