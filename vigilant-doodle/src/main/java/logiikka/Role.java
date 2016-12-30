package logiikka;

import java.util.*;

public interface Role {

    String toString();
    User getUser();
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);

}