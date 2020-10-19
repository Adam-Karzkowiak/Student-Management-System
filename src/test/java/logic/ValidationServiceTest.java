package logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class ValidationServiceTest {

    @Test
    @DisplayName("when password is too short")
    public void test1() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ValidationService.passwordValidation("Pasw0rd");
            }
        });
        //Assertions.assertThrows(IllegalArgumentException.class, () -> ValidationService.isPasswordValid("Pasw0rd"));

        String expectedMessage = "Password must be less than 20 and more than 8 characters in length.";
        Assertions.assertEquals(expectedMessage, e.getMessage(), "incorrect exception message");
    }

    @Test
    @DisplayName("when password is too long")
    public void test2() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ValidationService.passwordValidation("MyPasw0rdIsTooLongImPrettySureAboutThat");
            }
        });

        String expectedMessage = "Password must be less than 20 and more than 8 characters in length.";
        Assertions.assertEquals(expectedMessage, e.getMessage(), "incorrect exception message");
    }

    @Test
    @DisplayName("when password is correct")
    public void test3() {
    }

    @Test
    @DisplayName("when password dont have got uppercase")
    public void test4() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ValidationService.passwordValidation("mybadpassw0rd");
            }
        });

        String expectedMessage = "Password must have at least one uppercase character.";
        Assertions.assertEquals(expectedMessage, e.getMessage(), "incorrect exception message");

    }

    @Test
    @DisplayName("when password dont have got lowercase")
    public void test5() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ValidationService.passwordValidation("MYBADPASSW0RD");
            }
        });

        String expectedMessage = "Password must have at least one lowercase character";
        Assertions.assertEquals(expectedMessage, e.getMessage(), "incorrect exception message");
    }

    @Test
    @DisplayName("when password dont have got numbers")
    public void test6() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ValidationService.passwordValidation("MyBadPassword");
            }
        });

        String expectedMessage = "Password must have at least one number";
        Assertions.assertEquals(expectedMessage, e.getMessage(), "incorrect exception message");
    }


}