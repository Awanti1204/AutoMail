import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.FileInputStream;
import java.util.Collections;

public class GmailService {
    public static Gmail getGmailService() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("credentials.json"))
                .createScoped(Collections.singletonList(GmailScopes.GMAIL_READONLY));
        return new Gmail.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials))
                .setApplicationName("Email Feedback Automation")
                .build();
    }
}
