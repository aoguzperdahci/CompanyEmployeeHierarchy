package com.Project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class OfficerTest {
    
    @Test
    public void shouldCalculateCostOfficer() { 
        Officer officer = new Officer("Ada Lovelace", 15000);
        int cost = officer.getCost();
        assertEquals(15000, cost);
    }

    @Test
    public void shouldFailNegativeSalaryOfficer() { 
        Officer officer = new Officer("Ada Lovelace", -1);
        int cost = officer.getCost();
        assertNotEquals(-1, cost);
    }

}
