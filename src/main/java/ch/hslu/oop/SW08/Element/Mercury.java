package ch.hslu.oop.SW08.Element;

/**
 * The <code>Mercury</code> class represents the element Mercury with a given
 * name, boiling point and evaporation point.
 * The <code>Mercury</code> class extends the <code>Element</code> class.
 *
 * @author Urs Bollhalder
 * @version 1.0
 * @see ch.hslu.oop.SW07.Element.Element
 * @see ch.hslu.oop.SW07.Element.Lead
 * @see ch.hslu.oop.SW07.Element.Nitrogen
 */
public class Mercury extends Element {

    /**
     * Default constructor for the element Mercury.
     */
    public Mercury() {
        super("Mercury", 80, ElementClassification.TRANSITION_METALS, -38.83f, 357.0f);
    }

}
