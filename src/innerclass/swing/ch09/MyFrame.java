package innerclass.swing.ch09;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {


    private JLabel backgroundMap;
    private JLabel player;

    private final int MOVE_STEP = 10;
    private ImageIcon playerIconL;
    private ImageIcon playerIconR;
    private final int INIT_X = 500;
    private final int INIT_Y = 500;



    public MyFrame() {
        initData();
        setInitLayout();
        addEventLiseter();
    }


    private void initData() {
        setTitle("이미지 사용 연습");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(INIT_X, INIT_Y);

        //  배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(1000,600);
        backgroundMap.setLocation(0,0);

        // 플레이어 설정
        playerIconL = new ImageIcon("images/playerL.png");
        playerIconR = new ImageIcon("images/playerR.png");
        player = new JLabel(playerIconR);
        player.setSize(100,100);
        player.setLocation(200,200);


    }


    private void setInitLayout() {
        setLayout(null); // 좌표기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventLiseter() {
        // 키보드 이벤트를 만들어서 캐릭터를 왼쪽 위아래 움지깅게
        this.addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode =e.getKeyCode();
        int playerx = player.getX();
        int playery = player.getY();


        if (keyCode == KeyEvent.VK_LEFT) {
            player.setIcon(playerIconL);
            player.setLocation(playerx - MOVE_STEP , playery);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.setIcon(playerIconR);
            player.setLocation(playerx + MOVE_STEP, playery);
        } else if (keyCode == KeyEvent.VK_UP) {
            player.setLocation(playerx , playery - MOVE_STEP);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.setLocation(playerx , playery + MOVE_STEP);
        } else if (keyCode == KeyEvent.VK_ESCAPE) {
            player.setLocation(INIT_X, INIT_Y);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    // 테스트 코드 (메인 쓰레드)

    public static void main(String[] args) {
        new MyFrame();
    }
}
