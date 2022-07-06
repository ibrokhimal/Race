public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "������� " + length + " ������";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " ��������� � �����(����): " +
                        description);
                MainClass.semaphore.acquire();
                System.out.println(c.getName() + " ����� ����: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " �������� ����: " +
                        description);
                MainClass.semaphore.release();
                MainClass.endRace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
