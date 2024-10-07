// Regex-based extraction from email content for Customer Name, Order ID, etc.
String extractCustomerName(String emailBody) {
    // Example regex extraction (adjust based on format)
    Pattern pattern = Pattern.compile("Customer Name: (.*)");
    Matcher matcher = pattern.matcher(emailBody);
    return matcher.find() ? matcher.group(1) : "N/A";
}

// Repeat similar extraction for Order ID and Feedback Category
