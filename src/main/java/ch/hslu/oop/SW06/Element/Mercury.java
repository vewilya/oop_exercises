package ch.hslu.oop.SW06.Element;

/**
 * The <code>Mercury</code> class represents the element Mercury with a given name, boiling point and evaporation point.
 * The <code>Mercury</code> class extends the <code>Element</code> class.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Element.Element
 * @see ch.hslu.oop.SW05.Element.Lead
 * @see ch.hslu.oop.SW05.Element.Nitrogen
 */
public class Mercury extends Element {

    /**
     * Main method to test the class.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Mercury Hg = new Mercury();
        System.out.println(Hg.getAggregateState(100));
        System.out.println(Hg.toString());
        System.out.println(Hg.getEvaporationPoint());
    }

    /**
     * Default constructor for the element Mercury.
     */
    public Mercury() {
        super("Mercury", 357.0f, -38.83f);
    }
    
}
