package designpatterns.structural.adaptor;

/**
 * Adapter class that makes IEDriver compatible with the WebDriver interface.
 * This class implements the Adapter design pattern by wrapping the IEDriver
 * and translating WebDriver method calls to IEDriver's methods.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class WebDriverAdaptor implements WebDriver {
    private IEDriver ieDriver;

    /**
     * Constructs a WebDriverAdaptor that wraps the specified IEDriver.
     *
     * @param ieDriver the IE driver instance to be adapted
     */
    public WebDriverAdaptor(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    /**
     * Adapts the getElement() call to IEDriver's findElement() method.
     */
    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    /**
     * Adapts the selectElement() call to IEDriver's clickElement() method.
     */
    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}
