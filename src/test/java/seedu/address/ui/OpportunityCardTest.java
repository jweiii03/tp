package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OpportunityCardTest {

    @Test
    public void getStatusStyleClass_allValidStatuses_returnsCorrectClass() {
        assertEquals("status-saved", OpportunityCard.getStatusStyleClass("SAVED"));
        assertEquals("status-applied", OpportunityCard.getStatusStyleClass("APPLIED"));
        assertEquals("status-oa", OpportunityCard.getStatusStyleClass("OA"));
        assertEquals("status-interview", OpportunityCard.getStatusStyleClass("INTERVIEW"));
        assertEquals("status-offer", OpportunityCard.getStatusStyleClass("OFFER"));
        assertEquals("status-rejected", OpportunityCard.getStatusStyleClass("REJECTED"));
        assertEquals("status-withdrawn", OpportunityCard.getStatusStyleClass("WITHDRAWN"));
    }

    @Test
    public void getStatusStyleClass_lowercaseInput_returnsLowercaseClass() {
        assertEquals("status-applied", OpportunityCard.getStatusStyleClass("applied"));
    }

    @Test
    public void getStatusStyleClass_classPrefixIsStatusDash() {
        String styleClass = OpportunityCard.getStatusStyleClass("OFFER");
        assertEquals(true, styleClass.startsWith("status-"));
    }
}
