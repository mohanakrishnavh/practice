package designpatterns.decorator;

public class SportyDress extends DressDecorator {

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Sporty Dress Features");
    }
}
