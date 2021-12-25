import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@DisplayName("Parameterized tests of checkNameToEmboss method")
@RunWith(Parameterized.class)
public class AccountParameterizedTest {

    private final String name;
    private final boolean canBeEmbossed;

    public AccountParameterizedTest(String name, boolean canBeEmbossed) {
        this.name = name;
        this.canBeEmbossed = canBeEmbossed;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {null, false},
                {"D Y", true},
                {"Dan", false},
                {"Dan ", false},
                {" Dan", false},
                {"D  Y", false},
                {"Da N", true},
                {"Asdfghjklr asdfgrte", true},
                {"Asdfghjklr asdfgrteq", false},
                {"Asdfghjklr asdfgrteqq", false}
        };
    }

    @DisplayName("Test that checkNameToEmboss method works correct")
    @Test
    public void checkNameToEmbossWorksCorrect() {

        Account account = new Account(name);

        assertEquals("checkNameToEmboss works incorrect", account.checkNameToEmboss(), canBeEmbossed);
    }
}
