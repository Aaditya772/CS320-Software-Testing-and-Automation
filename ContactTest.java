import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void validContactCreated() {
        Contact contact = new Contact("1", "Java", "Joe", "1234567890", "130 Main St");
        assertEquals("Java", contact.getFirstName());
        assertEquals("Joe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("130 Main St", contact.getAddress());
    }

    @Test
    public void contactIdValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Java", "Joe", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Java", "Joe", "1234567890", "Addr"));
    }

    @Test
    public void firstAndLastNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("2", null, "Joe", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("3", "Java", null, "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("4", "ABCDEFGHIJK", "Joe", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("5", "Java", "ABCDEFGHIJK", "1234567890", "Addr"));
    }

    @Test
    public void phoneValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("6", "Java", "Joe", null, "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("7", "Java", "Joe", "12345", "Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("8", "Java", "Joe", "12345678901", "Addr"));
    }

    @Test
    public void addressValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("9", "Java", "Joe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("10", "Java", "Joe", "1234567890", "A".repeat(31)));
    }
}
