import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.Arrays;

public class GoogleFormSubmission {

    public static void submitFeedback(Sheets sheetsService, String sheetId, String customerName, String orderId,
                                      String category, String sentiment) throws Exception {
        ValueRange body = new ValueRange().setValues(Arrays.asList(
                Arrays.asList(customerName, orderId, category, sentiment)
        ));
        sheetsService.spreadsheets().values().append(sheetId, "Sheet1!A1", body)
                .setValueInputOption("RAW").execute();
    }
}
