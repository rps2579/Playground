package main.problems.techgig;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ForestFire {

    public static void main(String args[] ) throws Exception {

        //Write code here
        InputValues input = getInput();

        System.out.println("Calculating...");
        System.out.println(findSavableAnimalCount1(input));
//        System.out.println(findSavableAnimalCount2(input));
    }

    private static Long findSavableAnimalCount3(InputValues input) {
        final Long[] savableAnimalsCount = {0L};

        Long[] answer = input.animalEnergyToCountMap.keySet().stream().sorted(Comparator.reverseOrder()).filter(currEnergy -> {
            if (savableAnimalsCount[0] >= input.maxSavableAnimals) {
                return false;
            }
            savableAnimalsCount[0] += input.animalEnergyToCountMap.get(currEnergy);

            return savableAnimalsCount[0] == input.maxSavableAnimals;
        }).toArray(Long[]::new);

        return answer.length == 1 ? answer[0] : -1L;
    }
    private static Long findSavableAnimalCount2(InputValues input) {
        AtomicReference<Long> savableAnimalsCount = new AtomicReference<>(0L);

        input.animalEnergyToCountMap.keySet().stream().sorted(Comparator.reverseOrder()).forEach(currEnergy -> {
            if (savableAnimalsCount.get() < input.maxSavableAnimals) {
                savableAnimalsCount.updateAndGet(v -> v + input.animalEnergyToCountMap.get(currEnergy));
            }
        });

        return savableAnimalsCount.get() == input.maxSavableAnimals ? savableAnimalsCount.get() : -1L;
    }

    private static Long findSavableAnimalCount1(InputValues input) {
        Long savableAnimalsCount = 0L;

        for (Long currEnergy : input.animalEnergyToCountMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            savableAnimalsCount += input.animalEnergyToCountMap.get(currEnergy);

            if (savableAnimalsCount == input.maxSavableAnimals) {
                return currEnergy;
            } else if (savableAnimalsCount > input.maxSavableAnimals) {
                return -1L;
            }
        }
        return -1L;
    }

    private static InputValues getInput() {
        Scanner sc = new Scanner(System.in);
        long animalsCount = sc.nextLong();
        long maxSavableAnimals = sc.nextLong();
        Map<Long, Long> animalEnergyToCountMap = new LinkedHashMap<>();
        for (int i = 0; i < animalsCount; i++) {
            long currAnimalEnergy = sc.nextLong();
            long updatedAnimalCountWithCurrEnergy = animalEnergyToCountMap.getOrDefault(currAnimalEnergy, 0L) + 1;

            animalEnergyToCountMap.put(currAnimalEnergy, updatedAnimalCountWithCurrEnergy);
        }
        InputValues input = new InputValues(maxSavableAnimals, animalEnergyToCountMap);
        sc.close();

        return input;
    }
}

class InputValues {
    Long maxSavableAnimals;
    Map<Long, Long> animalEnergyToCountMap;

    public InputValues(Long maxSavableAnimals, Map<Long, Long> animalEnergyToCountMap) {
        this.maxSavableAnimals = maxSavableAnimals;
        this.animalEnergyToCountMap = animalEnergyToCountMap;
    }
}
