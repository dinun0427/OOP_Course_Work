import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;

public class GuiPart extends Formula1ChampionshipManager implements ActionListener {

    JFrame frame = new JFrame();                            //New JFrame
    JButton button1 = new JButton("Ascending Order");     //Creating buttons
    JButton button2 = new JButton("Descending Order");        //---------
    JButton button3 = new JButton("Sort By Wins");              //--------------
    JButton button4 = new JButton("Random Races");             //-----------------
    JButton button5 = new JButton("Sort Race Dates");     //-------------------
    JButton button6 = new JButton("Search Driver");    //-------------------------
    JPanel buttonObj = new JPanel();                             //Creating a JPanel for buttons.
    JTextField jTextField = new JTextField(10);      //Creating a search bar (JTextField) limit of 10 characters.
    JLabel label1 = new JLabel();

    public GuiPart(){

        frame.setSize(1200,600);
        frame.setLayout(null);
        frame.setVisible(true);

        //Adding buttons to the panel.
        buttonObj.add(button1);
        buttonObj.add(button2);
        buttonObj.add(button3);
        buttonObj.add(button4);
        buttonObj.add(button5);
        buttonObj.add(button6);
        buttonObj.setLayout(new FlowLayout());      //setting the layout to the button panel
        buttonObj.setBounds(50, 50, 1000, 100);
        buttonObj.setVisible(true);
        buttonObj.add(jTextField);
        buttonObj.add(label1);
        frame.add(buttonObj);

//Setting layout for buttons.
        button1.setBounds(100, 160, 200, 40);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2.setBounds(100, 200,200, 40);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3.setBounds(100, 240, 200, 40);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4.setBounds(100, 280, 200, 40);
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5.setBounds(100, 320, 200, 40);
        button5.setFocusable(false);
        button5.addActionListener(this);

        button6.setBounds(100, 360, 200, 40);
        button6.setFocusable(false);
        button6.addActionListener(this);
        jTextField.setBounds(50, 250, 100, 20);
    }



    private JPanel ascendingOrder(){          //creating ascending order table
        JPanel jPanel;
        String[] col;

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(Color.black);
        JLabel label  = new JLabel("Ascending Order");

        frame.setSize(1200,600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.EAST);

        //creating table column headers
        col = new String[]{"Name", "Team", "Location", "Races Participated ", "Points", "1st Positions", "2nd Positions", "3rd Positions"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Formula1Driver formula1Driver: Formula1ChampionshipManager.ascendingOrderList){  //passing the values to the table
            System.out.println(formula1Driver.getName());
            Object[] rows = {formula1Driver.getName(), formula1Driver.getTeam(), formula1Driver.getLocation(), formula1Driver.getNumOfRaces(),
                    formula1Driver.getPoints(), formula1Driver.getP1(), formula1Driver.getP2(), formula1Driver.getP3()};
            table.addRow(rows);
        }

        jTable.setFont(new Font("Times New Roman",Font.BOLD, 16));   //changing fonts and font weight.
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        jPanel.add(scrollPane);
        return jPanel;
    }


    private JPanel descendingOrder(){            //creating descending order table
        JPanel jPanel;

        String[] col;
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(Color.blue);

        frame.setSize(1200,600);
        frame.setLayout(null);
        frame.setVisible(true);


        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.EAST);

        col = new String[]{"Name", "Team", "Location", "Races Participated ", "Points", "1st Positions", "2nd Positions", "3rd Positions"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Formula1Driver formula1Driver: Formula1ChampionshipManager.descendingOrderList){        //passing the values to the table
            Object[] rows = {formula1Driver.getName(), formula1Driver.getTeam(),formula1Driver.getLocation() , formula1Driver.getNumOfRaces(),
                    formula1Driver.getPoints(), formula1Driver.getP1(), formula1Driver.getP2(), formula1Driver.getP3()};
            table.addRow(rows);

        }
        jTable.setFont(new Font("Times New Roman",Font.BOLD, 16));
        jTable.setAlignmentY(50);
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        jPanel.add(scrollPane);
        return jPanel;
    }
//creating table for most winning order.
    private JPanel sortAsMostWins(){
        String[] col;

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(Color.blue);

        frame.setSize(1200,600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.EAST);

        col = new String[]{"Name", "Team", "Location", "Races Participated ", "Points", "1st Positions", "2nd Positions", "3rd Positions"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Formula1Driver formula1Driver: Formula1ChampionshipManager.sortedByWinsList){
            Object[] rows = {formula1Driver.getName(), formula1Driver.getTeam(), formula1Driver.getLocation(), formula1Driver.getNumOfRaces(),
                    formula1Driver.getPoints(), formula1Driver.getP1(), formula1Driver.getP2(), formula1Driver.getP3()};
            table.addRow(rows);

        }
        jTable.setFont(new Font("Times New Roman",Font.BOLD, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        jPanel.add("East", scrollPane);
        return jPanel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            addButton();
            frame.add("South", ascendingOrder());
        }

        if (e.getSource() == button2){
            addButton();
            frame.add("South", descendingOrder());
        }

        if (e.getSource() == button3){
            addButton();
            frame.add("South", sortAsMostWins());
        }

        if (e.getSource() == button4){
            //Auto creating random races for drivers.
            Random rand = new Random();
            int number = 0;
            int randomPoints = 0;
            int fPositions = 0;
            int sPositions = 0;
            int tPositions = 0;
            int racerIndex = 0;

//random number
            for (int count = 1; count <= 10; count++){
                number = 1 + rand.nextInt(10);
                randomPoints = rand.nextInt(100);
                fPositions = rand.nextInt(8);
                sPositions = rand.nextInt(12);
                tPositions = rand.nextInt(5);


            }
//Updating the array
            for (int i = 0; i < Formula1ChampionshipManager.racersList.size(); i++){
                racerIndex = rand.nextInt(Formula1ChampionshipManager.racersList.size());

                String name = Formula1ChampionshipManager.racersList.get(racerIndex).getName();
                String team = Formula1ChampionshipManager.racersList.get(racerIndex).getTeam();
                String location = Formula1ChampionshipManager.racersList.get(racerIndex).getLocation();
                boolean isTrue = true;

                for (Formula1Driver formula1Driver : Formula1ChampionshipManager.racersList) {


                    if (formula1Driver.getName().equalsIgnoreCase(name) && formula1Driver.getTeam().equalsIgnoreCase(team)) {
                        isTrue = false;

                        formula1Driver.updatePoints(fPositions);
                        formula1Driver.updateTotalRaces();
                        formula1Driver.placesAdder(fPositions);
                        formula1Driver.setNumOf2P(sPositions);
                        formula1Driver.setNumOf3P(tPositions);

                    }

                    Formula1ChampionshipManager.sortedByWinsList.sort(Formula1Driver.sortByWins);

                }


            }
            System.out.println("Random Race Created");

        }
        if (e.getSource() == button5){  //sort by dates and print
            addButton();
            frame.add("South", sortByDates());
            Collections.sort(DatesList);


        }
        if (e.getSource() == button6){              //Printing drivers details.
            addButton();
            String name = jTextField.getText();
            if (jTextField.getText().equalsIgnoreCase(name)){
                for (Formula1Driver formula1Driver : info){
                    if (formula1Driver.getName().equalsIgnoreCase(name)){
                        label1.setText("Name: "+ formula1Driver.getName() + " | Team: "+
                                formula1Driver.getTeam()+" | Location: "+ formula1Driver.getLocation() +" | Total Wins: "
                                + formula1Driver.getP1() + " | Dates: " + DatesList);
                    }
                }

            }

        }
    }
//creating table by race dates.
    private JPanel sortByDates(){
        String[] col;

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(Color.blue);

        frame.setSize(1200,600);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.EAST);

        col = new String[] {"Dates"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (int count = 0; count < DatesList.size(); count++){
            Object[] rows = {DatesList.get(count)};
            table.addRow(rows);

        }
        jTable.setFont(new Font("Times New Roman",Font.BOLD, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        jPanel.add("East", scrollPane);
        return jPanel;
    }

    public void addButton(){  //updating the values when user click another button.
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
        frame.add(buttonObj);

    }

    public void main(String[] args) {
        GuiPart p1 = new GuiPart();

    }

}