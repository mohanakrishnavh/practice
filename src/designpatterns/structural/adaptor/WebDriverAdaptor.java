package designpatterns.structural.adaptor;

public class WebDriverAdaptor implements WebDriver{
    IEDriver ieDriver;

    public WebDriverAdaptor(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }


    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}
