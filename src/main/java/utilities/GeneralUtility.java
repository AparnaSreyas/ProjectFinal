package utilities;

import org.openqa.selenium.WebElement;

public class GeneralUtility {
	
	public String getTextOfElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getStyleProperty(WebElement element, String propertyType) {
		String styleValue = element.getCssValue(propertyType);
		return styleValue;
	}

	public String getToolTipValue(WebElement element) {
		String tooltipText = element.getAttribute("title");
		return tooltipText;
	}

}
