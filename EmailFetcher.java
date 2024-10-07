import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import java.util.List;

public class EmailFetcher {

    public static List<Message> fetchUnreadEmails(Gmail service) throws Exception {
        ListMessagesResponse messagesResponse = service.users().messages().list("me")
                .setQ("is:unread").execute();
        return messagesResponse.getMessages();
    }
}
