package dellent.errors;
//Simple error payload class
public class ErrorResponse {
    private int status;
    private String message;
    private String timestamp;
   
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString(); 
    }

    // Getters for status, message, timestamp
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public String getTimestamp() { return timestamp; }
}