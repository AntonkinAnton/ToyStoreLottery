import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private PriorityQueue<Toy> toysQueue;

    public ToyStore() {
        toysQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getFrequency(), t1.getFrequency()));
    }

    public void put(Toy toy) {
        toysQueue.offer(toy);
    }

    public void getRandomToy() {
        Random random = new Random();
        int totalFrequency = toysQueue.stream().mapToInt(Toy::getFrequency).sum();
        int randomFrequency = random.nextInt(totalFrequency) + 1;
        int cumulativeFrequency = 0;

        for (Toy toy : toysQueue) {
            cumulativeFrequency += toy.getFrequency();
            if (randomFrequency <= cumulativeFrequency) {
                writeResultToFile(toy.getId(), toy.getName());
                return;
            }
        }
    }

    public void writeResultToFile(int id, String toyName) {
        try {
            FileWriter fileWriter = new FileWriter("result.txt", true);
            fileWriter.write("id: " + id + "   name: " + toyName + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
