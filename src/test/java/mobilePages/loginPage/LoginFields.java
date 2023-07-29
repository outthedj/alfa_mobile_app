package mobilePages.loginPage;

import org.openqa.selenium.By;

public enum LoginFields {

    LOGIN_FIELD(By.xpath("//*[contains(@resource-id, 'etUsername')]")),
    PASSWORD_FIELD(By.xpath("//*[contains(@resource-id, 'etPassword')]"));

    private final By fieldPath;

    LoginFields(By fieldPath) {
        this.fieldPath = fieldPath;
    }

    public By getFieldPath() {
        return fieldPath;
    }
}
