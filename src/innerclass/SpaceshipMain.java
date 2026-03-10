package innerclass;

public class SpaceshipMain {

    public static void main(String[] args) {

        // 정적 내부클래스라서 바로 생성 가능함
        Spaceship.Engine engine = new Spaceship.Engine();
        engine.start();
        Spaceship spaceship1 = new Spaceship();
        spaceship1.addEngine(engine);
        spaceship1.startSpaceShip();


    }
}
