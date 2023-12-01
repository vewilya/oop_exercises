package ch.hslu.oop.SW05.Element;

/**
 * The <code>Nitrogen</code> class represents the element Nitrogen with a given name, boiling and evaporation point.
 * The <code>Nitrogen</code> class extends the <code>Element</code> class.
* @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Element.Element
 * @see ch.hslu.oop.SW05.Element.Mercury
 * @see ch.hslu.oop.SW05.Element.Lead
 */
public class Nitrogen extends Element {
    /**
     * Main method to test the class.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Nitrogen nitrogen = new Nitrogen();
        System.out.println(nitrogen.getAggregateState(100));
        System.out.println(nitrogen.getString());
        System.out.println(nitrogen.getEvaporationPoint());
    }

    /**
     * Default constructor for the element Nitrogen.
     */
    public Nitrogen() {
        super("Nitrogen", -196.0f, -210.1f);
    }
    
}
