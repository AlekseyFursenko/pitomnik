package org.nursery.view;

import org.nursery.data.TestData;

import java.util.ArrayList;
import java.util.Date;

public interface View {

    Long getId();
    void setId(Long value);
    String getAnimalClass(String data);
    String getName();
    void setName(String value);
    String getDate();
    void setDate(String value);
    boolean getConfirm(String text);
    String getCommand();
}
