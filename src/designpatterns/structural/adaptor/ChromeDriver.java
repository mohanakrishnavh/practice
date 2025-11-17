package designpatterns.structural.adaptor;

/**
 * Concrete implementation of WebDriver for Chrome browser.
 * This class already implements the target interface and doesn't need adaptation.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class ChromeDriver implements WebDriver {
    
    /**
     * Gets an element using Chrome driver's native method.
     */
    @Override
    public void getElement() {
        System.out.println("Get element from Chrome Driver");
    }

    /**
     * Selects an element using Chrome driver's native method.
     */
    @Override
    public void selectElement() {
        System.out.println("Select element from Chrome Driver");
    }
}
