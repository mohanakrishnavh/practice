package designpatterns.decorator;

/**
 * Concrete decorator that adds sporty features to a dress.
 * This decorator enhances the base dress with athletic and sporty styling elements.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SportyDress extends DressDecorator {

    /**
     * Constructs a SportyDress decorator that wraps the specified dress.
     *
     * @param dress the dress object to be enhanced with sporty features
     */
    public SportyDress(Dress dress) {
        super(dress);
    }

    /**
     * Assembles the dress with sporty features.
     * First delegates to the wrapped dress, then adds sporty-specific features.
     */
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Sporty Dress Features");
    }
}
