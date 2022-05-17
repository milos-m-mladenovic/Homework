package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.AuthorsApi;
import com.projectname.api.client.data.model.authors.AuthorsResponse;
import com.projectname.api.tests.data.provider.Provider;
import com.projectname.api.tests.functional.asserts.AuthorsAsserts;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class AuthorsTests extends TestBase {

    AuthorsAsserts assertAuthors = new AuthorsAsserts();
    AuthorsResponse[] getAllAuthors;

    @Test
    public void getAuthors() {
        getAllAuthors = AuthorsApi.getAuthors();
        assertAuthors.assertAuthors(getAllAuthors);
    }

    @Test
    public void getAuthor() {
        getAllAuthors = AuthorsApi.getAuthors();
        AuthorsResponse getAuthor = AuthorsApi.getAuthor(getAllAuthors[0].getId());
        assertAuthors.assertAuthor(getAuthor);
    }

    @Test
    public void getBooksByAuthor() {
        AuthorsResponse[] getBooksByAuthor = AuthorsApi.getBooksByAuthor(1);
        assertAuthors.assertBooksByAuthor(getBooksByAuthor);
    }

    @Test
    public void createAuthor() {
        AuthorsResponse createAuthor = AuthorsApi.postAuthor(Provider.prepareAuthorRequest());
        assertAuthors.assertNewAuthor(createAuthor);
    }

    @Test
    public void editAuthor() {
        getAllAuthors = AuthorsApi.getAuthors();
        AuthorsResponse existingAuthor = AuthorsApi.getAuthor(getAllAuthors[0].getId());
        AuthorsResponse editedAuthor = AuthorsApi.putAuthor(Provider.prepareAuthorRequest(), getAllAuthors[0].getId());
        assertAuthors.assertEditAuthor(existingAuthor, editedAuthor);
    }

    @Test
    public void deleteAuthor() {
        AuthorsResponse getAuthor = AuthorsApi.getAuthor(100);
        AuthorsResponse deleteAuthor = AuthorsApi.deleteAuthor(getAuthor.getId());
        assertAuthors.assertDeleteAuthor(deleteAuthor);
    }

}
