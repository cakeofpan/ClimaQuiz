package Code;
class Timer{
    private final int timeLimit = 15;
    boolean isTimeDone;

    public Timer(){
        isTimeDone = false;
    }

    public boolean isTimeDone(){
        return isTimeDone;
    }

    public void start() {
        isTimeDone = false;
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(timeLimit * 1000);
                isTimeDone = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timerThread.start();
    }
}