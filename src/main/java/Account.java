import io.qameta.allure.Step;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Check name is valid")
    public boolean checkNameToEmboss() {

        if (name == null) {
            return false;
        }

        String nameFormat = "(?=.{3,19}$)([A-Za-z]+(?= {1}).[A-Za-z]+)";
        return Pattern.matches(nameFormat, name);

    }
}
