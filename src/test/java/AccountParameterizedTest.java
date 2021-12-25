import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void checkNameToEmbossWorksCorrect() {

        Account account = new Account(name);

        assertEquals("checkNameToEmboss works incorrect", account.checkNameToEmboss(), canBeEmbossed);
    }
}
