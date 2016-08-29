package parser.empik;

import org.jsoup.nodes.Document;
import parser.IBookParser;
import parser.utils.ParserUtils;

import java.util.Optional;

/**
 * Created by grzegorz_sledz on 25.08.16.
 */
class EmpikBookParser implements IBookParser {

    @Override
     public String getTitle(Optional<Document> document) {
        if(document.isPresent()){
            return document.get().select("h1.productMainTitle > span").first().text();
        }
        return null;
    }

    @Override
    public String getAuthor(Optional<Document> document) {
        if(document.isPresent()) {
            return document.get().select("span.pDAuthorList > a").first().text();
        }
        return null;
    }
    @Override
    public String getPrice(Optional<Document> document) {
        if(document.isPresent()) {
            return document.get().select("span.currentPrice").first().text();
        }
        return null;
    }
    @Override
    public String getPercentageDiscount(Optional<Document> document) {
        if(document.isPresent()) {
            //12,80 zł (40%)
            String priceWithDiscount = document.get().select("span.saving").first().text();
            return ParserUtils.extractDataFromRegex("\\((.*?)\\)", priceWithDiscount);
        }
        return null;
    }
    @Override
    public String getGenre(Optional<Document> document) {
        if(document.isPresent()) {
            return document.get().select("div.productLocalizer > a").last().text();
        }
        return null;
    }
    @Override
    public String getDescription(Optional<Document> document) {
        if(document.isPresent()) {
            return document.get().select("div.contentPacketText").first().text();
        }
        return null;
    }

}
