package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.coverphotos.CoverphotosResponse;
import org.testng.asserts.SoftAssert;

public class CoverphotosAsserts {

    SoftAssert softAssert = new SoftAssert();

    public void assertCoverphotos(CoverphotosResponse[] getCoverphotos) {
        for(int i = 0; i < getCoverphotos.length; i++) {
            softAssert.assertFalse(getCoverphotos[i].getUrl().isEmpty(), "URL is empty.");
        }
        softAssert.assertAll();
    }

    public void assertCoverphoto(CoverphotosResponse coverphoto) {
        softAssert.assertFalse(coverphoto.getUrl().isEmpty(), "URL is empty.");
        softAssert.assertAll();
    }

    public void assertCoverphotosByBook(CoverphotosResponse[] coverphotosByBook) {
        for(int i = 0; i < coverphotosByBook.length; i++) {
            softAssert.assertFalse(coverphotosByBook[i].getUrl().isEmpty(), "URL is empty.");
        }
        softAssert.assertAll();
    }

    public void assertEditCoverphoto(CoverphotosResponse oldValues, CoverphotosResponse newValues) {
        softAssert.assertFalse(oldValues.getId().equals(newValues.getId()));
        softAssert.assertAll();
    }

    public void assertDeleteCoverphoto(CoverphotosResponse deletedCoverphoto) {
        softAssert.assertNull(deletedCoverphoto);
        softAssert.assertAll();
    }

}
