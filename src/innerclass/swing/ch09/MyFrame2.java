package innerclass.swing.ch09;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame2 extends JFrame {


    private JLabel backgroundMap;
    private JLabel player;


    ImageIcon playerIconL = new ImageIcon("images/playerL.png");

    ImageIcon getPlayerIconR = new ImageIcon("images/playerR.png");

    private final int MOVE_STEP = 10;
    // 이동 가능한 범위
    private final int MAX_X = 1000 - 100; // 900
    private final int MAX_Y = 600 - 100; // 500
    // Min_x
    // min_y
    private final int MIN_POS = 0;


    public MyFrame2() {
        initData();
        setInitLayout();
        addEventLiseter();
    }


    private void initData() {
        setTitle("이미지 사용 연습");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);

        //  배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 설정
        player = new JLabel(playerIconL); // 초기상태값
        player.setSize(100, 100);
        player.setLocation(200, 200);


    }


    private void setInitLayout() {
        setLayout(null); // 좌표기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventLiseter() {
        // 키보드 이벤트를 만들어서 캐릭터를 왼쪽 위아래 움지깅게
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = player.getX();
                int y = player.getY();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setIcon(playerIconL);
                        x -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += MOVE_STEP;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setIcon(getPlayerIconR);
                        x += MOVE_STEP;
                        break;
                    default:
                        return;
                }

                    // 벽 밖으로 안나가도록 범위제한
                    x = Math.max(MIN_POS, Math.min(x,MAX_X));
                    y = Math.max(MIN_POS, Math.min(y,MAX_Y));
                    player.setLocation(x, y);

                } // end of keypress


            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
        requestFocusInWindow();


    }


    // 테스트 코드 (메인 쓰레드)

    public static void main(String[] args) {
        new MyFrame2();
    }
}
