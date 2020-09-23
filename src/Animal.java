import java.util.Objects;

public class Animal {
    private String animalName;

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private Integer headCount;
    private Integer footCount;

    public Animal(String animalName, Integer headCount, Integer footCount) {
        this.animalName = animalName;
        this.headCount = headCount;
        this.footCount = footCount;
    }

    public Integer getHeadCount() {
        return headCount;
    }

    public void setHeadCount(Integer headCount) {
        this.headCount = headCount;
    }

    public Integer getFootCount() {
        return footCount;
    }

    public void setFootCount(Integer footCount) {
        this.footCount = footCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(headCount, animal.headCount) &&
                Objects.equals(footCount, animal.footCount);
    }

    @Override
    public int hashCode() {
        int i=17;
        i=i*31+(headCount!=null ? headCount.hashCode() :0);
        i=i*31+(footCount!=null ? footCount.hashCode() :0);
        return i;
    }
}
