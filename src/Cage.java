import java.util.*;
import java.util.stream.Stream;

public class Cage implements Question {
    private Integer headSum;
    private Integer footSum;
    private Set<Class<? extends Animal>> animals;

    public Set<Class<? extends Animal>> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Class<? extends Animal>> animals) {
        this.animals = animals;
    }

    public Cage(Integer headSum, Integer footSum, Set<Class<? extends Animal>> animals) {
        this.headSum = headSum;
        this.footSum = footSum;
        this.animals = animals;
    }

    public Integer getHeadSum() {
        return headSum;
    }

    public void setHeadSum(Integer headSum) {
        this.headSum = headSum;
    }

    public Integer getFootSum() {
        return footSum;
    }

    public void setFootSum(Integer footSum) {
        this.footSum = footSum;
    }

    @Override
    public void check() {
        if (headSum == null || footSum == null) {
            throw new NullPointerException();
        }
        if (headSum <= 0 || footSum <= 0) {
            throw new RuntimeException("参数异常");
        }
        if (animals == null || animals.size() <= 0) {
            throw new NullPointerException();
        }
    }

    @Override
    public void anower() {
        List<AnimalCount> countList = new ArrayList<>();
        try {
            for (Class<? extends Animal> animal : animals) {
                countList.add(new AnimalCount(animal.newInstance(), 0));
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        int index = countList.size() - 1;
        int nowHead = 0;
        do {
            if (index<0){
                break;
            }
            AnimalCount animalCount = countList.get(index);
            animalCount.addition();
            if (iswhile(countList)) {
                countList.forEach(System.out::println);
                break;
            }else {
                nowHead+=animalCount.getAnimal().getHeadCount();
                if (nowHead < headSum) {
                    if (index != countList.size() - 1) {
                        if (countList.get(countList.size() - 1).getCount() == 0) {
                            index=countList.size()-1;
                        }
                    }
                    continue;
                } else {
                    index--;
                    nowHead-=animalCount.getCount();
                    animalCount.zero();
                }
            }
        } while (true);
    }

    private boolean iswhile(List<AnimalCount> countList) {
        return countList.stream().mapToInt(x -> x.getCount() * x.getAnimal().getHeadCount()).sum() == headSum
                && countList.stream().mapToInt(x -> x.getCount() * x.getAnimal().getFootCount()).sum() == footSum;
    }

}
