package designpatterns.structural.adaptor;

/**
 * Adaptee class representing Internet Explorer driver.
 * This class has an incompatible interface with WebDriver and needs
 * to be adapted to work with the WebDriver interface.
 * 
 * <p>Note: This class uses different method names (findElement, clickElement)
 * instead of the standard WebDriver interface methods (getElement, selectElement).
 *
 * @author Practice Repository
 * @version 1.0
 */
public class IEDriver {
    
    /**
     * Finds an element using IE driver's specific method.
     */
    public void findElement() {
        System.out.println("Find element from IE Driver");
    }

    /**
     * Clicks an element using IE driver's specific method.
     */
    public void clickElement() {
        System.out.println("Click element from IE Driver");
    }
}
