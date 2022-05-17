package com.projectname.api.client.data.model.activities;

import com.projectname.api.client.data.model.activities.ActivitiesRequest;

import java.io.Serializable;

public class UpdateActivityRequest extends ActivitiesRequest implements Serializable {

    public UpdateActivityRequest() {
        super();
    }

    public UpdateActivityRequest(Integer id, String title, String dueDate, Boolean completed) {
        super(id, title, dueDate, completed);
    }
}
