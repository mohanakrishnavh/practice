package designpatterns.decorator;

/**
 * Concrete decorator that adds casual features to a dress.
 * This decorator enhances the base dress with casual styling elements.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class CasualDress extends DressDecorator {

    /**
     * Constructs a CasualDress decorator that wraps the specified dress.
     *
     * @param dress the dress object to be enhanced with casual features
     */
    public CasualDress(Dress dress) {
        super(dress);
    }

    /**
     * Assembles the dress with casual features.
     * First delegates to the wrapped dress, then adds casual-specific features.
     */
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Casual Dress Features");
    }
}
