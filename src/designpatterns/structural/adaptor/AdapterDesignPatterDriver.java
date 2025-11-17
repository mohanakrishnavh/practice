package designpatterns.structural.adaptor;

/**
 * Client class demonstrating the Adapter design pattern.
 * This class shows how the adapter enables incompatible interfaces
 * to work together seamlessly.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class AdapterDesignPatterDriver {
    
    /**
     * Main method to demonstrate adapter pattern usage.
     * Shows how ChromeDriver works directly with WebDriver interface,
     * and how IEDriver can work through WebDriverAdaptor.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // ChromeDriver works directly with WebDriver interface
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();
        
        System.out.println();

        // IEDriver has incompatible interface
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();
        
        System.out.println();

        // Using adapter to make IEDriver compatible with WebDriver interface
        WebDriverAdaptor webDriverAdaptor = new WebDriverAdaptor(ieDriver);
        webDriverAdaptor.getElement();
        webDriverAdaptor.selectElement();
    }
}
