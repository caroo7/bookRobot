package access;

import entities.Book;
import entities.Library;
import lombok.extern.log4j.Log4j2;
import repositories.BookRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;

@Log4j2
public class DBAccessor {

    private static final String CACHE_FILE_SAVE_LOCATION = "../../web/";

    public Set<Book> getBooks(BookRepository bookRepo, Library library) {
        return bookRepo.findByLibrary(library);
    }

    public void createCache(Set<Book> set, String libraryName) {
        try {
            FileOutputStream outputStream = new FileOutputStream(CACHE_FILE_SAVE_LOCATION + libraryName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(set);
            objectOutputStream.close();
        } catch (FileNotFoundException fNFE) {
            log.error("Exception while accessing the file: " + fNFE);
        } catch (IOException iOE) {
            log.error("Exception while streaming the objects: " + iOE);
        }
    }

}