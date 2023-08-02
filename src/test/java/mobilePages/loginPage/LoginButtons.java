package mobilePages.loginPage;

import org.openqa.selenium.By;

public enum LoginButtons {

    SUBMIT_BUTTON(By.xpath("//*[contains(@resource-id, 'btnConfirm')]"));

    private final By fieldPath;

    LoginButtons(By fieldPath) {
        this.fieldPath = fieldPath;
    }

    public By getFieldPath() {
        return fieldPath;
    }
}
