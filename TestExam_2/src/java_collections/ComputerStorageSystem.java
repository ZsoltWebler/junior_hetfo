package java_collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComputerStorageSystem {

    private final List<Computer> computerList = ComputerDatabase.getComputers();


    public final List<Computer> getAllComputer() {
        return computerList;
    }

    public final List<Computer> getAllComputersWithIntelCPU() {
        return computerList.stream().filter(computer -> computer.getCPU().startsWith("Intel")).toList();
    }

    public final List<Computer> getAllComputersWithAmdCPU() {
        return computerList.stream().filter(computer -> computer.getCPU().startsWith("AMD")).toList();
    }

    public final List<Computer> getAllComputersWithGeForceGPU() {
        return computerList.stream().filter(computer -> computer.getGPU().startsWith("GeForce")).toList();
    }

    public final List<Computer> getAllComputersWithRadeonGPU() {
        return computerList.stream().filter(computer -> computer.getGPU().startsWith("Radeon")).toList();
    }

    public final List<Computer> getAllComputersWithMoreThan16GBRam() {
        return computerList.stream().filter(computer -> computer.getRamCapacity() > 16).toList();
    }

    public final Map<StorageType, List<Computer>> getAllComputersGroupedByStorageType() {
        return computerList.stream().collect(Collectors.groupingBy(Computer::getStorageType));
    }

    public final Map<Integer, List<Computer>> getAllComputersGroupedByMemoryCapacity() {
        return computerList.stream().collect(Collectors.groupingBy(Computer::getRamCapacity));
    }

    public final Map<Integer, List<Computer>> getAllComputersGroupedByStorageCapacity() {
        return computerList.stream().collect(Collectors.groupingBy(Computer::getStorageCapacity));
    }


}


