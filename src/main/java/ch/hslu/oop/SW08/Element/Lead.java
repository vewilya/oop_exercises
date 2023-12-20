package ch.hslu.oop.SW08.Element;

/**
 * The <code>Lead</code> class represents the element Lead with a given name,
 * boiling and evaporation point.
 * The <code>Lead</code> class extends the <code>Element</code> class.
 * 
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW05.Element.Element
 * @see ch.hslu.oop.SW05.Element.Mercury
 * @see ch.hslu.oop.SW05.Element.Nitrogen
 */
public class Lead extends Element {

    /**
     * Default constructor for the element Lead.
     */
    public Lead() {
        super("Lead", 82, ElementClassification.OTHER_METALS, 327.43f, 1744.0f);
    }

}
