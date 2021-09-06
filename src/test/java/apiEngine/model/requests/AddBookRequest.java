package apiEngine.model.requests;

import java.util.ArrayList;
import java.util.List;

public class AddBookRequest {
    public String userID;
    public List<ISBN> collectionOfIsbns;

    public AddBookRequest(String userID, List<ISBN> collectionOfIsbns, ISBN isbn)
    {
        this.userID = userID;
        collectionOfIsbns = new ArrayList<>();
        collectionOfIsbns.add(isbn);
    }
}
