package logic;

import org.junit.Assert;
import org.junit.Test;


class ValidationServiceTest {

    @Test
    public void shouldSayPasswordIsCorrect() {
        ValidationService.isPasswordValid("TestPassword123");
    }
}