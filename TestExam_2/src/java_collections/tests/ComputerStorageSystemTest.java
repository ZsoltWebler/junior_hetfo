package java_collections.tests;

import java_collections.StorageType;
import org.junit.jupiter.api.Test;
import java_collections.Computer;
import java_collections.ComputerDatabase;
import java_collections.ComputerStorageSystem;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerStorageSystemTest {

    private final ComputerStorageSystem computerStorageSystem = new ComputerStorageSystem();

    @Test
    public void getAllComputerTest() {

        List<Computer> expected = ComputerDatabase.getComputers();
        List<Computer> actual = computerStorageSystem.getAllComputer();
        assertEquals(100, actual.size());
        assertEquals(expected, actual);

    }

    @Test
    public void getAllComputersWithIntelCPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithIntelCPU();

        assertEquals(64, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getCPU().startsWith("Intel"));
        }
    }

    @Test
    public void getAllComputersWithAmdCPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithAmdCPU();

        assertEquals(36, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getCPU().startsWith("AMD"));
        }
    }

    @Test
    public void getAllComputersWithGeForceGPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithGeForceGPU();

        assertEquals(67, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getGPU().startsWith("GeForce"));
        }
    }

    @Test
    public void getAllComputersWithRadeonGPUTest() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithRadeonGPU();

        assertEquals(33, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getGPU().startsWith("Radeon"));
        }
    }

    @Test
    public void getAllComputersWithMoreThan16GBRam() {
        List<Computer> actual = computerStorageSystem.getAllComputersWithMoreThan16GBRam();

        assertEquals(50, actual.size());
        for (Computer c : actual) {
            assertTrue(c.getRamCapacity() > 16);
        }
    }

    @Test
    public void getAllComputersGroupedByStorageType() {
        Map<StorageType, List<Computer>> actual = computerStorageSystem.getAllComputersGroupedByStorageType();

        assertEquals(2,actual.keySet().size());
        assertEquals(44,actual.get(StorageType.SSD).size());
        assertEquals(56,actual.get(StorageType.HDD).size());

        actual.get(StorageType.SSD).forEach(computer -> assertEquals(computer.getStorageType(), StorageType.SSD));
        actual.get(StorageType.HDD).forEach(computer -> assertEquals(computer.getStorageType(), StorageType.HDD));
    }

    @Test
    public void getAllComputersGroupedByMemoryCapacity() {
        Map<Integer, List<Computer>> actual = computerStorageSystem.getAllComputersGroupedByMemoryCapacity();

        assertEquals(4,actual.keySet().size());
        assertEquals(29,actual.get(8).size());
        assertEquals(21,actual.get(16).size());
        assertEquals(27,actual.get(32).size());
        assertEquals(23,actual.get(64).size());


        actual.forEach((key, value) -> value
                .forEach(
                        computer -> assertEquals(key, computer.getRamCapacity())));

    }

    @Test
    public void getAllComputersGroupedByStorageCapacity() {
        Map<Integer, List<Computer>> actual = computerStorageSystem.getAllComputersGroupedByStorageCapacity();

        assertEquals(4,actual.keySet().size());
        assertEquals(21,actual.get(512).size());
        assertEquals(26,actual.get(1024).size());
        assertEquals(27,actual.get(2048).size());
        assertEquals(26,actual.get(4096).size());


        actual.forEach((key, value) -> value
                .forEach(
                        computer -> assertEquals(key, computer.getStorageCapacity())));

    }

}
