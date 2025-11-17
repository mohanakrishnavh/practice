package designpatterns.decorator;

/**
 * Concrete decorator that adds fancy features to a dress.
 * This decorator enhances the base dress with elegant and fancy styling elements.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class FancyDress extends DressDecorator {

    /**
     * Constructs a FancyDress decorator that wraps the specified dress.
     *
     * @param dress the dress object to be enhanced with fancy features
     */
    public FancyDress(Dress dress) {
        super(dress);
    }

    /**
     * Assembles the dress with fancy features.
     * First delegates to the wrapped dress, then adds fancy-specific features.
     */
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Fancy Dress Features");
    }
}
