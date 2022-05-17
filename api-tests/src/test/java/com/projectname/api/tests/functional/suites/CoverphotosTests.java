package com.projectname.api.tests.functional.suites;

import com.projectname.api.client.calls.CoverPhotosApi;
import com.projectname.api.client.data.model.coverphotos.CoverphotosResponse;
import com.projectname.api.tests.data.provider.Provider;
import com.projectname.api.tests.functional.asserts.CoverphotosAsserts;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class CoverphotosTests extends TestBase {

    CoverphotosResponse[] getAllCoverphotos;
    CoverphotosAsserts assertCoverphotos = new CoverphotosAsserts();

    @Test
    public void getCoverphotos() {
        getAllCoverphotos = CoverPhotosApi.getCoverphotos();
        assertCoverphotos.assertCoverphotos(getAllCoverphotos);
    }

    @Test
    public void getCoverphoto() {
        getAllCoverphotos = CoverPhotosApi.getCoverphotos();
        CoverphotosResponse getCoverphoto = CoverPhotosApi.getCoverphoto(getAllCoverphotos[0].getId());
        assertCoverphotos.assertCoverphoto(getCoverphoto);
    }

    @Test
    public void getCoverphotosByBook() {
        CoverphotosResponse[] getCoverphotosByBook = CoverPhotosApi.getCoverphotosByBook(1);
        assertCoverphotos.assertCoverphotosByBook(getCoverphotosByBook);
    }

    @Test
    public void createCoverphoto() {
        CoverphotosResponse createCoverphoto = CoverPhotosApi.postCoverphoto(Provider.prepareCoverphotoRequest());
        assertCoverphotos.assertCoverphoto(createCoverphoto);
    }

    @Test
    public void editCoverphoto() {
        getAllCoverphotos = CoverPhotosApi.getCoverphotos();
        CoverphotosResponse existingCoverphoto = CoverPhotosApi.getCoverphoto(getAllCoverphotos[0].getId());
        CoverphotosResponse editedCoverphoto = CoverPhotosApi.putCoverphoto(Provider.prepareCoverphotoRequest(), getAllCoverphotos[0].getId());
        assertCoverphotos.assertEditCoverphoto(existingCoverphoto, editedCoverphoto);
    }

    @Test
    public void deleteCoverphoto() {
        CoverphotosResponse getCoverphoto = CoverPhotosApi.getCoverphoto(100);
        CoverphotosResponse deleteCoverphoto = CoverPhotosApi.deletCoverphoto(getCoverphoto.getId());
        assertCoverphotos.assertDeleteCoverphoto(deleteCoverphoto);
    }

}
