import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650; // 50 Pix für den Text Panel on Top
      JFrame frame = new JFrame("Tic-Tac-Toe");
      JLabel textlabel = new JLabel();
      JPanel textPanel = new JPanel();
      JPanel boardPanel = new JPanel();
        JButton[][] board = new JButton[3][3];
        String playerx = "X";
        String playerO = "O";
        String currentPlayer = playerx;

        boolean gameover=false;
        int turns= 0;

        TicTacToe(){
          frame.setVisible(true);
          frame.setSize(boardWidth,boardHeight);
          frame.setLocationRelativeTo(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLayout(new BorderLayout());
          textlabel.setBackground(Color.darkGray);
          textlabel.setForeground(Color.WHITE);
          textlabel.setFont(new Font("Arial",Font.BOLD,50));
          textlabel.setHorizontalAlignment(JLabel.CENTER);
          textlabel.setText("Tic-Tac-Toe ");
          textlabel.setOpaque(true);

          textPanel.setLayout(new BorderLayout());
          textPanel.add(textlabel);
          frame.add(textPanel,BorderLayout.NORTH);

          boardPanel.setLayout(new GridLayout(3,3));
          boardPanel.setBackground(Color.darkGray);
          frame.add(boardPanel);
            for (int i = 0 ;i<3 ; i++)
            {
                for (int j = 0;j<3;j++)
                {
                    JButton tile = new JButton();
                    board[i][j] = tile;
                    boardPanel.add(tile);
                    tile.setBackground(Color.WHITE);
                    tile.setForeground(Color.darkGray);
                    tile.setFont(new Font("Arial",Font.BOLD,120));
                    tile.setFocusable(false);

                    tile.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            if (gameover) return;

                            JButton tile =(JButton) e.getSource();
                            if (tile.getText()=="") {
                                tile.setText(currentPlayer);
                                turns++;
                                checkwinner();
                                if (!gameover)
                                {
                                    currentPlayer = currentPlayer == playerx ? playerO : playerx;
                                    textlabel.setText(currentPlayer + "'s turn.");
                                }

                            }
                        }
                    });
                }
            }
      }
      void checkwinner()
      {
          for (int r=0;r<3;r++)
          {
              if (board[r][0].getText()=="")continue;
              if (board[r][0].getText()==board[r][1].getText()
              && board[r][1].getText()==board[r][2].getText()){
                  for (int i =0;i<3;i++)
                  {
                      setWinner(board[r][i]);
                  }
                  gameover=true;
              }
          }
          for (int c=0;c<3;c++)
          {
              if (board[0][c].getText()=="")continue;
              if (board[0][c].getText()==board[1][c].getText()
                      && board[1][c].getText()==board[2][c].getText()){
                  for (int i =0;i<3;i++)
                  {
                      setWinner(board[i][c]);
                  }
                  gameover=true;
                  return;
              }
          }

          if (board[0][0].getText()==board[1][1].getText()&&
          board[1][1].getText()==board[2][2].getText()&&
          board[0][0].getText()!=""){
              for (int i =0;i<3;i++)
              {
                  setWinner(board[i][i]);
              }
              gameover=true;
              return;
          }
          if (board[0][2].getText()==board[1][1].getText()&&
                  board[1][1].getText()==board[2][0].getText()&&
                  board[0][2].getText()!=""){
                  setWinner(board[0][2]);
                  setWinner(board[1][1]);
                  setWinner(board[2][0]);
              gameover=true;
              return;
          }

          if (turns==9)
          {
              for (int r =0;r<3;r++)
              {
                  for (int c=0;c<3;c++)
                  {
                      setTie(board[r][c]);
                  }
                  gameover=true;
              }
          }
      }

     void setTie(JButton tile) {
            tile.setForeground(Color.orange);
            textlabel.setText("Tie!");
    }

    void  setWinner(JButton tile )
      {
          tile.setForeground(Color.green);
          textlabel.setText(currentPlayer+ " is the winner!");
      }
      {

      }
}
