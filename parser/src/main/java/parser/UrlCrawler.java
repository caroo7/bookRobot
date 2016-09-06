package parser;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Log4j2
public abstract class UrlCrawler {

    protected String MAIN_URL;
    protected String PROMOTION_URL;
    protected PageLoader pageLoader;
    protected IPageUrlParser pageUrlParser;

    protected final int QUEUE_SIZE=10;

    protected UrlCrawler(String mainUrl,String promotionUrl){
        this.MAIN_URL=mainUrl;
        this.PROMOTION_URL=promotionUrl;
    }

    protected UrlCrawler(String mainUrl, String promotionUrl, PageLoader pageLoader, IPageUrlParser pageUrlParser) {
        this.MAIN_URL = mainUrl;
        this.PROMOTION_URL = promotionUrl;
        this.pageLoader = pageLoader;
        this.pageUrlParser = pageUrlParser;
    }

    public List<String> getLinksToAllBooks() {

        BlockingQueue queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

        NextPageUrlProducer nextPageUrlProducer = new NextPageUrlProducer(queue, pageLoader, pageUrlParser, PROMOTION_URL);
        NextPageUrlConsumer nextPageUrlConsumer = new NextPageUrlConsumer(queue, pageLoader, pageUrlParser);

        Thread nextPageUrlProducerThread = new Thread(nextPageUrlProducer);
        nextPageUrlProducerThread.setName("NextPageUrlProducerThread");
        Thread nextPageUrlConsumerThread = new Thread(nextPageUrlConsumer);
        nextPageUrlConsumerThread.setName("NextPageUrlConsumerThread");
        nextPageUrlProducerThread.start();
        nextPageUrlConsumerThread.start();

        try {
            nextPageUrlConsumerThread.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return nextPageUrlConsumer.getBookDetailsUrls();
    }


}
