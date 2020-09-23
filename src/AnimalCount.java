public class AnimalCount<T extends Animal> {
    private T animal;
    private volatile int count;

    public AnimalCount(T animal, int count) {
        this.animal = animal;
        this.count = count;
    }

    public void addition(){
        count=count+1;
    }

    public void zero(){
        count=0;
    }

    @Override
    public String toString() {
        return "AnimalCount{" +
                "animal=" + animal.getAnimalName() +
                ", count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
