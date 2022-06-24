package swu.lj;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


@Slf4j
public class DiningPhilosophers implements Runnable {

    private final int id;

    public DiningPhilosophers(int id) {
        this.id = id;
    }

    private static final Random random = new Random(System.currentTimeMillis());

    private static final Semaphore[] forks = new Semaphore[5];

    private static final Semaphore maxDiners = new Semaphore(4);


    // 初始化信号量,每个信号量为1，代表1只筷子
    static {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    @Override
    public void run() {
        try {
            while (true) {
                think(id);
                eat(id);
            }
        } catch (InterruptedException e) {
            log.error("异常中断", e);
        }
    }

    /**
     * 哲学家思考随机时间
     */
    private void think(int id) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(100));

        log.info("哲学家{}正在思考~", id);

    }

    private void eat(int id) throws InterruptedException {
        // 先获得吃饭名额
        maxDiners.acquire();

        // 先拿左边的筷子
        forks[id].acquire();

        // 然后拿右边的筷子
        forks[(id + 4) % 5].acquire();

        TimeUnit.MILLISECONDS.sleep(20);
        // 吃一口饭
        log.info("哲学家{}正在吃饭~", id);

        // 依次放下左边的筷子和右边的筷子
        forks[id].release();
        forks[(id + 4) % 5].release();

        // 吃完之后归还吃饭名额
        maxDiners.release();

        log.info("哲学家{}吃完~", id);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new DiningPhilosophers(i)).start();
        }
    }
}