package java_database.tests;

import java_database.model.RoomDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomDaoTest {

    @Test
    public void testRoomDaoOnSalePriceWithOnSaleRoom() {
        RoomDao roomDao = new RoomDao(1, 1, 50.0, 500, true, true);
        roomDao.getOnSalePrice();

        assertEquals(roomDao.getPrice()*0.9,roomDao.getOnSalePrice(),0);
    }

    @Test
    public void testRoomDaoOnSalePriceWithNoOnSaleRoom() {
        RoomDao roomDao = new RoomDao(1, 1, 50.0, 500, true, false);
        roomDao.getOnSalePrice();

        assertEquals(roomDao.getPrice(),roomDao.getOnSalePrice(),0);
    }



}
