package de.pb.bv.crawler;

import de.pb.bv.common.DataSource;
import de.pb.bv.contracts.BrickSetContract;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.Optional;

public class BrickSetCrawler {
    public Optional<BrickSetContract> retrieveFromBrickLink(String url) throws IOException {
        var document = Jsoup.connect(url).get();
        var titleElement = document.getElementById("item-name-title");
        var title = ((TextNode)titleElement.childNode(0)).text();
        var idDiv = document.getElementById("id_divBlock_Main");
        var itemNoElements = idDiv.getElementsContainingText("Item No:");
        var itemNoElement = itemNoElements.get(0);
        var itemNoSpan = itemNoElement.getElementsByTag("span");
        var itemNo = ((TextNode)itemNoSpan.get(1).childNode(0)).text();
        var x = 0;
        var contract = new BrickSetContract();
        contract.setDataSource(DataSource.BRICKLINK);
        contract.setName(title);
        contract.setExternalId(itemNo);
        return Optional.of(contract);
    }
}
