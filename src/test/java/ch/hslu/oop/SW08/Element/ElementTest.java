package ch.hslu.oop.SW08.Element;

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
        assertThat(new Mercury().getElementClassification()).isEqualTo("TRANSITION_METALS");
    }

    @Test
    void testGetElementClassification_2() {
        Element Nitrogen = new Nitrogen();

        assertEquals("NON_METALS", Nitrogen.getElementClassification());
    }

    @Test
    void testGetAggregateState() {
        assertThat(new Nitrogen().getAggregateState(200.0f)).isEqualTo(AggregateState.GASEOUS);
    }

    // 327.43f, 1744.0f - Lead
    @Test 
    void testGetAggregateState2() {
        assertThat(new Lead().getAggregateState(327.43f)).isEqualTo(AggregateState.LIQUID);
        assertThat(new Lead().getAggregateState(1744.0f)).isEqualTo(AggregateState.GASEOUS);
    }

    // -38.83f, 357.0f - Mercury
    @Test
    void testGetAggregateState3() {
        assertThat(new Mercury().getAggregateState(-38.83f)).isEqualTo(AggregateState.LIQUID);
        assertThat(new Mercury().getAggregateState(357.0f)).isEqualTo(AggregateState.GASEOUS);
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
