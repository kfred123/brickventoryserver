package de.pb.bv.crawler;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrickSetCrawlerTest {
    @Test
    public void retrieveHauntedHouseSet() throws IOException {
        var crawler = new BrickSetCrawler();
        var brickSet = crawler.retrieveFromBrickLink("https://www.bricklink.com/v2/catalog/catalogitem.page?S=10273-1#T=I");
        assertTrue(brickSet.isPresent(), "BrickSetContract should be present");
        assertEquals("10273-1", brickSet.get().getExternalId(), "ExternalId should be 10273-1");
        assertEquals("Haunted House", brickSet.get().getName(), "Name should be Haunted House");
    }
}
