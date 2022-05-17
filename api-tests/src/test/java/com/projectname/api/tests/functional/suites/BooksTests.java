package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.BooksApi;
import com.projectname.api.client.data.model.books.BooksRequest;
import com.projectname.api.client.data.model.books.BooksResponse;
import com.projectname.api.client.utils.ValueChoosers;
import com.projectname.api.tests.data.provider.Provider;
import com.projectname.api.tests.functional.asserts.BooksAsserts;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class BooksTests extends TestBase {

    BooksResponse[] getBooks;
    BooksAsserts assertBooks = new BooksAsserts();

    @Test
    public void getBooks() {
        getBooks = BooksApi.getBooks();
        assertBooks.assertBooks(getBooks);
    }

    @Test
    public void getBook() {
        getBooks = BooksApi.getBooks();
        BooksResponse getBook = BooksApi.getBook(getBooks[0].getId());
        assertBooks.assertBook(getBook);
    }

    @Test
    public void createBook() {
        BooksResponse createBook = BooksApi.postBook(Provider.prepareBookRequest());
        assertBooks.assertBook(createBook);
    }

    @Test
    public void editBook() {
        getBooks = BooksApi.getBooks();
        BooksResponse existingBook = BooksApi.getBook(getBooks[0].getId());
        BooksRequest editBook = new BooksRequest(existingBook.getId(), ValueChoosers.setRandomTitleName(), ValueChoosers.setBookDescription(), ValueChoosers.setPageCount(), ValueChoosers.setExcerpt(), ValueChoosers.setPublishDate());
        BooksResponse editedBook = BooksApi.putBook(existingBook.getId(), editBook);
        assertBooks.assertEditBook(existingBook, editedBook);
    }

    @Test
    public void deleteBook() {
        getBooks = BooksApi.getBooks();
        BooksResponse deleteBook = BooksApi.deleteBook(getBooks[0].getId());
        assertBooks.assertDeleteBook(deleteBook);
    }

}
