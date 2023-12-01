package ch.hslu.oop.SW07.Element;

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
        System.out.println(nitrogen.getEvaporationPoint());
        System.out.println(nitrogen.toString());
        System.out.println(nitrogen.getElementClassification());
        
    }

    /**
     * Default constructor for the element Nitrogen.
     */
    public Nitrogen() {
        super("Nitrogen", 7, ElementClassification.NON_METALS, -210.1f, -196.0f);
    }

    /**
     * Returns name of the element with a custom warning flag.
     * @return The name of the element with a custom warning flag.
     */
    @Override
    public String toString() {
        return super.toString() + " TOXIC";
    }



    // -------------------- PRIVATE --------------------

}
