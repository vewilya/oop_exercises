package ch.hslu.oop.SW06.Element;

/**
 * The <code>Lead</code> class represents the element Lead with a given name, boiling and evaporation point.
 * The <code>Lead</code> class extends the <code>Element</code> class.
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Element.Element
 * @see ch.hslu.oop.SW05.Element.Mercury
 * @see ch.hslu.oop.SW05.Element.Nitrogen
 */
public class Lead extends Element {

    /**
     * Main method to test the class.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Lead Pb = new Lead();
        System.out.println(Pb.getAggregateState(100));
        System.out.println(Pb.toString());
        System.out.println(Pb.getEvaporationPoint());
    }

    /**
     * Default constructor for the element Lead.
     */
    public Lead() {
        super("Lead", 1744.0f, 327.43f );
    }
    

}
