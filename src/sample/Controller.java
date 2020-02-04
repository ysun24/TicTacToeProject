package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller extends Button implements EventHandler {
        @FXML
        private Button btn00,btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;
        private Button[] buttons; // Array of the buttons
        private final int MAX = 9;
        private int value;

        public Controller(){
                this.setState(0);
                value = 0;
        }

        public void initialize(){
                initializeButtonArray();
        }

        public void initializeButtonArray(){
                buttons = new Button[9]; // init array of buttons
                buttons[0] = btn00;
                buttons[1] = btn01;
                buttons[2] = btn02;
                buttons[3] = btn10;
                buttons[4] = btn11;
                buttons[5] = btn12;
                buttons[6] = btn20;
                buttons[7] = btn21;
                buttons[8] = btn22;
        }

        @Override
        public void handle(Event event) {
                for(int i = 0; i < MAX; ++i){
                        if(buttons[i] == event.getSource()){
                                try {

                                        buttons[i].setText("X");
                                        //buttons[i].changeState();
                                        System.out.println(buttons[i] );


                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }

        }

        public void setState(int state){ // Was trying to set values for each symbol easyer to
                                        // to figure out a winner 3 would be winner or -3
                if(state == 0){
                        this.setText("-");
                        this.value = 0;
                }else if(state == 1){
                        this.setText("X");
                        this.value = 1;
                }else if(state == -1){
                        this.setText("O");
                        this.value = -1;
                } else {
                        System.out.println("Set state called with incorrect state");
                }

        }

        public int getValue(Button button) {
                return value;
        }

        public void changeState() throws Exception{ // was trying to make the buttons rotate though each
                // symbol one click would be X two clicks would be O three clicks would be "-"
                // i was later going to figure out a board refresh button
                if(this.value == -1)
                        this.setState(0);
                else if(this.value == 0)
                        this.setState(1);
                else if (this.value == 1)
                        this.setState(-1);
        }

}




