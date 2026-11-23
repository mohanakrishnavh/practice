package designpatterns.structural.adaptor;

/**
 * Target interface in the Adapter design pattern.
 * Defines the standard interface that clients expect to work with.
 * All compatible drivers should implement this interface.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public interface WebDriver {
    
    /**
     * Gets an element from the web page.
     */
    void getElement();
    
    /**
     * Selects an element on the web page.
     */
    void selectElement();
}
