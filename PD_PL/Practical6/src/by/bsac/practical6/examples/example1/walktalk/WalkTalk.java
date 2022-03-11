package by.bsac.practical6.examples.example1.walktalk;

import by.bsac.practical6.examples.example1.talk.TalkThread;
import by.bsac.practical6.examples.example1.walk.WalkRunnable;

public class WalkTalk {
    public static void main(String[ ] args) {
        // новые объекты потоков
        TalkThread talk = new TalkThread();
        Thread walk = new Thread(new WalkRunnable());
        // запуск потоков
        talk.start();
        walk.start();
        // WalkRunnable w = new WalkRunnable(); // просто объект, не поток
        // w.run(); или talk.run(); // выполнится метод, но поток не запустится!
    }
}
