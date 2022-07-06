package designpatterns.structural.adaptor;

public class AdapterDesignPatterDriver {
    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        WebDriverAdaptor webDriverAdaptor = new WebDriverAdaptor(ieDriver);
        webDriverAdaptor.getElement();
        webDriverAdaptor.selectElement();
    }
}
