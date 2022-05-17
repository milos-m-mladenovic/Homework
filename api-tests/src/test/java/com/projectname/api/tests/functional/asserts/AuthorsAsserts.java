package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.authors.AuthorsResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AuthorsAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertAuthors(AuthorsResponse[] getAuthors) {
        for(int i = 0; i < getAuthors.length; i++) {
            softAssert.assertFalse(getAuthors[i].getFirstName().isEmpty(), "First name is empty.");
            softAssert.assertFalse(getAuthors[i].getLastName().isEmpty(), "Last name is empty.");
        }
        softAssert.assertAll();
    }

    public void assertAuthor(AuthorsResponse author) {
        softAssert.assertFalse(author.getFirstName().isEmpty(), "First name is empty.");
        softAssert.assertFalse(author.getLastName().isEmpty(), "Last name is empty.");
        softAssert.assertAll();
    }

    public void assertBooksByAuthor(AuthorsResponse[] booksByAuthor) {
        for(int i = 0; i < booksByAuthor.length; i++) {
            softAssert.assertFalse(booksByAuthor[i].getFirstName().isEmpty(), "First name is empty.");
            softAssert.assertFalse(booksByAuthor[i].getLastName().isEmpty(), "Last name is empty.");
        }
        softAssert.assertAll();
    }

    public void assertNewAuthor(AuthorsResponse newAuthor) {
        if (newAuthor == null) {
            Assert.fail("Author was not created.");
        }
        softAssert.assertFalse(newAuthor.getFirstName().isEmpty(), "First name is empty.");
        softAssert.assertFalse(newAuthor.getLastName().isEmpty(), "Last name is empty.");
        softAssert.assertAll();
    }

    public void assertEditAuthor(AuthorsResponse oldValues, AuthorsResponse newValues) {
        softAssert.assertFalse(oldValues.getId().equals(newValues.getId()));
        softAssert.assertAll();
    }

    public void assertDeleteAuthor(AuthorsResponse deletedUser) {
        softAssert.assertNull(deletedUser);
        softAssert.assertAll();
    }

}
