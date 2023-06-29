public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.put(new Toy(1, "конструктор", 1));
        toyStore.put(new Toy(2, "робот", 2));
        toyStore.put(new Toy(3, "кукла", 6));
        toyStore.put(new Toy(4, "мяч", 10));

        for (int i = 0; i < 10; i++) {
            toyStore.getRandomToy();
        }
    }
}
