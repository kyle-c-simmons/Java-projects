import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class periodicTableTesting {

    @Test
    public void getSymbolFromElement() {
        Controller c = new Controller();

        // Part 1
        assertEquals(true, c.getSymbolFromElement("Sveggjerium", "Ee"));
        assertEquals(true, c.getSymbolFromElement("Zockurijirium", "Ci"));
        assertEquals(true, c.getSymbolFromElement("Jeffkanium", "Ae"));
        assertEquals(true, c.getSymbolFromElement("Jefftzlot", "Ef"));
        assertEquals(true, c.getSymbolFromElement("Jeffntzum", "Ef"));
        assertEquals(true, c.getSymbolFromElement("Tuffjeffium", "Ef"));
    }

    @Test
    public void partTwo() {
        Controller c = new Controller();

        // Part 2
        assertEquals(true, c.partTwo("Chlorine", "Ch"));
        assertEquals(true, c.partTwo("Chromium", "Cr"));
        assertEquals(true, c.partTwo("Cesium", "Ce"));
        assertEquals(true, c.partTwo("Cerium", "Ci"));
    }
}
