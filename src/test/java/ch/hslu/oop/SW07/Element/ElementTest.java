package ch.hslu.oop.SW07.Element;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.hslu.oop.SW07.Element.Element.ElementClassification;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ElementTest {
    
    @Test
    void testGetElementClassification() {
        Element Mercury = new Mercury();

        assertEquals(ElementClassification.TRANSITION_METALS, Mercury.getElementClassification());
    }

    @Test
    void testGetElementClassification_2() {
        Element Nitrogen = new Nitrogen();

        assertEquals(ElementClassification.NON_METALS, Nitrogen.getElementClassification());
    }


    // ---------------- Equals Verifier ----------------- // 
    // @Disabled ("This test is disabled until further notice")
    @Test
    void testEqualsContract() {
        // EqualsVerifier.simple().forClass(Element.class).verify();
        // EqualsVerifier.forClass(Element.class).suppress(Warning.NONFINAL_FIELDS).verify(); 
        EqualsVerifier.forClass(Element.class).withOnlyTheseFields("classification").verify(); 
    }

    // ------------------ Equals & Hash ------------------- //
    @Test
    void testEquals() {
        Element Mercury = new Mercury();
        Element Nitrogen = new Nitrogen();

        assertTrue(!Mercury.equals(Nitrogen));
        assertTrue(!Nitrogen.equals(Mercury));
    }

    @Test 
    void testHash() {
        Element Mercury = new Mercury();
        Element Nitrogen = new Nitrogen();

        assertTrue(Mercury.hashCode() != Nitrogen.hashCode());
    }

     @Test 
    void testHash2() {
        Element Mercury = new Mercury();
        Element Mercury2 = new Mercury();

        assertTrue(Mercury.hashCode() == Mercury2.hashCode());
    }

    // ------------------ CompareTo ------------------- //
    @Test
    void testCompareTo() {
        Element Mercury = new Mercury();
        Element Nitrogen = new Nitrogen();

        assertTrue(Mercury.compareTo(Nitrogen) > 0);
    }

    @Test
    void testCompareTo2() {
        Element Mercury = new Mercury();
        Element Mercury2 = new Mercury();

        assertTrue(Mercury.compareTo(Mercury2) == 0);
    }

    @Test
    void testCompareTo3() {
        Element Nitrogen = new Nitrogen();
        Element Lead = new Lead();

        assertTrue(Nitrogen.compareTo(Lead) < 0);
    }

}
