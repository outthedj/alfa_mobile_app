package mobilePages.loginPage;

import org.openqa.selenium.By;

public enum LoginErrorMessages {

    ERROR_MESSAGE(By.xpath("//*[contains(@resource-id, 'tvError')]"));

    private final By fieldPath;

    LoginErrorMessages(By fieldPath) {
        this.fieldPath = fieldPath;
    }

    public By getFieldPath() {
        return fieldPath;
    }
}
