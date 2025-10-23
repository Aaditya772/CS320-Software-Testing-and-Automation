import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    @Test
    public void addAndRetrieveContact() {
        Contact contact = new Contact("1", "Java", "Joe", "1234567890", "130 Main St");
        service.addContact(contact);
        assertEquals("Java", service.getContact("1").getFirstName());
    }

    @Test
    public void addDuplicateIdThrowsError() {
        Contact contact1 = new Contact("1", "Java", "Joe", "1234567890", "130 Main St");
        Contact contact2 = new Contact("1", "Python", "Pat", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void deleteContactRemovesIt() {
        Contact contact = new Contact("2", "Cheng", "Lee", "1234567890", "789 Oak St");
        service.addContact(contact);
        service.deleteContact("2");
        assertNull(service.getContact("2"));
    }

    @Test
    public void updateFirstNameWorks() {
        Contact contact = new Contact("3", "Java", "Joe", "1234567890", "130 Main St");
        service.addContact(contact);
        service.updateFirstName("3", "Python");
        assertEquals("Python", service.getContact("3").getFirstName());
    }

    @Test
    public void updateLastNameWorks() {
        Contact contact = new Contact("4", "Java", "Joe", "1234567890", "130 Main St");
        service.addContact(contact);
        service.updateLastName("4", "Smith");
        assertEquals("Smith", service.getContact("4").getLastName());
    }

    @Test
    public void updatePhoneWorks() {
        Contact contact = new Contact("5", "Java", "Joe", "1234567890", "130 Main St");
        service.addContact(contact);
        service.updatePhone("5", "0987654321");
        assertEquals("0987654321", service.getContact("5").getPhone());
    }

    @Test
    public void updateAddressWorks() {
        Contact contact = new Contact("6", "Java", "Joe", "1234567890", "130 Main St");
        service.addContact(contact);
        service.updateAddress("6", "999 Maple Rd");
        assertEquals("999 Maple Rd", service.getContact("6").getAddress());
    }
}
