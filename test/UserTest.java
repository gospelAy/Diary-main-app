import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
private User user;
    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testTheSizeOfUserDbIncreasesByOneWhenEverANewUserRegisters(){
        int sizeOfDbBeforeAUserRegisters = user.getNumberOfUsers();
        assertEquals(0, sizeOfDbBeforeAUserRegisters);
        user.register("Ik", "1234");
        int sizeOfDbAfterAUserRegisters = user.getNumberOfUsers();
        assertEquals(1, sizeOfDbAfterAUserRegisters);
    }
    @Test
    void testThatARegisteredUserHasADiary(){
        assertNull(user.getDiary());
        user.register("Ik", "1234");
        assertNotNull(user.findUserByEmail("Ik").getDiary());
    }
    @Test
    void testThatAUserCanBeFoundUsingTheUserRegisteredEmailAddress(){
        user.register("Ik", "1234");
       User foundUser = user.findUserByEmail("ik");
       assertEquals(foundUser.getEmail(), "Ik");
    }
}