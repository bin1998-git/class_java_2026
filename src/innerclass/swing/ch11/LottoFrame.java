package innerclass.swing.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 클래스의 역할 - 로또 게임 UI 전담 클래스
 * 담당 역할:
 * - 화면 구성(버튼. 번호출력 패녈)
 * - 버튼 클릭시 이벤트 처리
 * - LottoRandomNumber 클래스에게 번호 생성을 요청하고 응답 받아 결과물 화면에 표시
 *
 *
 */
public class LottoFrame extends JFrame implements ActionListener {

    // 상수모음
    private static final String INITIAL_MESSAGE = "Game Start 버튼을 눌러주세요";
    private static final String FONT_NAME = "고딕";
    private static final int FONT_SIZE = 20;
    private static final int CIRCLE_SIZE = 50;

    private JButton button;
    private LottoPanel lottoPanel;
    private LottoRandomNumber lottoRandomNumber;
    private int[] createNumbers; // 현재 화면에 표시할 번호 배열 선언

    private boolean isInitialState = true;

    public LottoFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("Lotto Game");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Game Start");
        lottoRandomNumber = new LottoRandomNumber();
        lottoPanel = new LottoPanel();
        createNumbers = new int[LottoRandomNumber.LOTTO_NUMBER_COUNT];
    }

    private void setInitLayout() {
        setLayout(new BorderLayout()); // 주소값 쓸일이 없어서 바로 NEW
        add(button, BorderLayout.NORTH);
        add(lottoPanel, BorderLayout.CENTER);
        setVisible(true);

    }

    private void addEventListener() {
        button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        isInitialState = false;
        lottoRandomNumber.createNumber();
        lottoPanel.repaint(); // lottoPanel 의 paintComponent() 를 다시 호출
    }

    private class LottoPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // 이전 그림을 지우는 것

            g.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));

            if(isInitialState) {
                // 버튼을 아직 누르지 않은 초기 상태
                g.setColor(Color.GRAY);
                g.drawString(INITIAL_MESSAGE, 160,150);

            } else {
                // 번호 6개를 원 안에 표시
                for (int i = 0; i < createNumbers.length; i++) {

                    int x = 60 + (i * 80); // 최초 x값 60부터 그림
                    int y = 80;



                    // 번호 값에 따라 공 색상 구분
                    g.setColor(getBallColor(createNumbers[i]));
                    g.fillOval(x,y, CIRCLE_SIZE, CIRCLE_SIZE); // 색채우기

                    // 원테두리 설정
                    g.setColor(Color.darkGray);
                    g.drawOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE); // 테두리 설정

                    // 원 안에 숫자 출력
                    g.setColor(Color.white);
                    String numStr = String.valueOf(createNumbers[i]);
                    g.drawString(numStr, x + 17, y + 33);

                }
            }

        }
    }

    private Color getBallColor(int number) {
        if(number <= 10) return new Color(255,200,0); // 노
        if(number <= 20) return new Color(0,120,50);// 파
        if(number <= 30) return new Color(220,50,50);// 빨
        if(number <= 40) return new Color(130,130,130);// 회
        return new Color(50,180,80); //초록
    }

    // 메인함수
    public static void main(String[] args) {
        new LottoFrame();
    }
}
