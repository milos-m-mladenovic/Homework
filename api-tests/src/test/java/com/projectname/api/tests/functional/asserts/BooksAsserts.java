package com.projectname.api.tests.functional.asserts;


import com.projectname.api.client.data.model.books.BooksResponse;
import org.testng.asserts.SoftAssert;

public class BooksAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertBooks(BooksResponse[] getBooks) {
        for(int i = 0; i < getBooks.length; i++) {
            softAssert.assertFalse(getBooks[i].getExcerpt().isEmpty(), "Excerpt is empty.");
            softAssert.assertFalse(getBooks[i].getTitle().isEmpty(), "Title is empty.");
            softAssert.assertFalse(getBooks[i].getDescription().isEmpty(), "Description is empty.");
            softAssert.assertFalse(getBooks[i].getPublishDate().isEmpty(), "Published date is empty.");
        }
        softAssert.assertAll();
    }

    public void assertBook(BooksResponse booksResponse) {
        softAssert.assertFalse(booksResponse.getTitle().isEmpty(), "Title is empty.");
        softAssert.assertFalse(booksResponse.getDescription().isEmpty(), "Description is empty.");
        softAssert.assertFalse(booksResponse.getExcerpt().isEmpty(), "Excerpt is empty.");
        softAssert.assertFalse(booksResponse.getPublishDate().isEmpty(), "Publish date is empty.");
        softAssert.assertAll();
    }

    public void assertEditBook(BooksResponse oldValues, BooksResponse newValues) {
        softAssert.assertFalse(oldValues.getTitle().equals(newValues.getTitle()), "Title is the same.");
        softAssert.assertFalse(oldValues.getPublishDate().equals(newValues.getPublishDate()), "Publish date is the same.");
        softAssert.assertFalse(oldValues.getDescription().equals(newValues.getDescription()), "Title is the same.");
        softAssert.assertFalse(oldValues.getExcerpt().equals(newValues.getExcerpt()), "Title is the same.");
        softAssert.assertFalse(oldValues.getPageCount().equals(newValues.getPageCount()), "Title is the same.");
        softAssert.assertAll();
    }

    public void assertDeleteBook(BooksResponse deletedBook) {
        softAssert.assertNull(deletedBook);
        softAssert.assertAll();
    }

}
