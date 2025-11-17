package designpatterns.decorator;

/**
 * Abstract decorator class in the Decorator pattern.
 * This class wraps a Dress object and delegates calls to it,
 * allowing subclasses to add additional behavior before or after delegation.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class DressDecorator implements Dress {

    /** The wrapped dress object that this decorator enhances */
    protected Dress dress;

    /**
     * Constructs a DressDecorator that wraps the specified dress.
     *
     * @param dress the dress object to be decorated
     */
    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    /**
     * Assembles the dress by delegating to the wrapped dress object.
     * Subclasses can override this method to add additional behavior.
     */
    @Override
    public void assemble() {
        this.dress.assemble();
    }
}
