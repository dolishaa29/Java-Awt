import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class MenuAppList implements ActionListener, ItemListener {
    Frame f1, f2, f3;
    Label l1, l2, l3, l4, l5;
    TextField t1, t2;
    Button b1, b2, b3, b4, b5, orderBtn, payBtn;
    TextArea tx;
    Choice itemList;
    String selectedCategory = "";
    String selectedItem = "";
    double totalPrice = 0.0;
    double selectedItemPrice = 0.0;

    MenuAppList() {
        f1 = new Frame("Login Page");
        f1.setLayout(null);

        l1 = new Label("Username");
        l2 = new Label("Password");
        t1 = new TextField();
        t2 = new TextField();
        t2.setEchoChar('*');

        b1 = new Button("Sign In");
        b2 = new Button("Sign Up");

        l1.setBounds(50, 60, 80, 20);
        l2.setBounds(50, 100, 80, 20);
        t1.setBounds(150, 60, 100, 20);
        t2.setBounds(150, 100, 100, 20);
        b1.setBounds(50, 150, 80, 25);
        b2.setBounds(150, 150, 80, 25);

        f1.add(l1); f1.add(l2);
        f1.add(t1); f1.add(t2);
        f1.add(b1); f1.add(b2);
        f1.setSize(400, 300);
        f1.setVisible(true);

        f2 = new Frame("Menu Categories");
        f2.setLayout(null);
        b3 = new Button("Breakfast");
        b4 = new Button("Lunch");
        b5 = new Button("Dinner");
        orderBtn = new Button("Order");
        l3 = new Label("Your Menu:");
        tx = new TextArea();
        itemList = new Choice();

        b3.setBounds(50, 60, 100, 30);
        b4.setBounds(50, 100, 100, 30);
        b5.setBounds(50, 140, 100, 30);
        orderBtn.setBounds(50, 180, 100, 30);
        l3.setBounds(180, 60, 100, 20);
        itemList.setBounds(180, 90, 120, 100);
        tx.setBounds(180, 200, 120, 150);

        f2.add(b3); 
        f2.add(b4); 
        f2.add(b5);
        f2.add(orderBtn);
        f2.add(l3); 
        f2.add(itemList); 
        f2.add(tx);
        f2.setSize(400, 500);
        f2.setVisible(false);

        f3 = new Frame("Order Summary");
        f3.setLayout(null);
        l4 = new Label("Order Details:");
        l5 = new Label("Total Price:");
        payBtn = new Button("Pay");

        l4.setBounds(50, 50, 100, 20);
        l5.setBounds(50, 100, 100, 20);
        payBtn.setBounds(150, 150, 80, 30);

        f3.add(l4); 
        f3.add(l5); 
        f3.add(payBtn);
        f3.setSize(400, 300);
        f3.setVisible(false);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        itemList.addItemListener(this);
        orderBtn.addActionListener(this);
        payBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (t1.getText().equals("user") && t2.getText().equals("123")) {
                f1.setVisible(false);
                f2.setVisible(true);
            } else {
                t1.setText("");
                t2.setText("");
            }
        }

        else if (e.getSource() == b3) {
            selectedCategory = "Breakfast";
            showItems();
        }
        else if (e.getSource() == b4) {
            selectedCategory = "Lunch";
            showItems();
        }
        else if (e.getSource() == b5) {
            selectedCategory = "Dinner";
            showItems();
        }
        else if (e.getSource() == orderBtn) {
            if (selectedItem.isEmpty()) {
                tx.append("Please select an item first.\n");
            } else {
                showOrderSummary();
                f2.setVisible(false);
                f3.setVisible(true);
            }
        }
        else if (e.getSource() == payBtn) {
            System.exit(0);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        selectedItem = itemList.getSelectedItem();
        if (selectedItem != null && !selectedItem.equals("")) {
            tx.append(selectedCategory + ": " + selectedItem + "\n");
            calculatePrice();
        }
    }

    void showItems() {
        itemList.removeAll();

        if (selectedCategory.equals("Breakfast")) {
            itemList.add("Tea");
            itemList.add("Coffee");
            itemList.add("Poha");
            itemList.add("Sandwich");
        } else if (selectedCategory.equals("Lunch")) {
            itemList.add("Thali");
            itemList.add("Rice");
            itemList.add("Dal");
            itemList.add("Chapati");
        } else if (selectedCategory.equals("Dinner")) {
            itemList.add("Paneer");
            itemList.add("Noodles");
            itemList.add("Soup");
            itemList.add("Roti");
        }
    }

    void calculatePrice() {
        if (selectedCategory.equals("Breakfast")) {
            if (selectedItem.equals("Tea")) selectedItemPrice = 30.0;
            else if (selectedItem.equals("Coffee")) 
            selectedItemPrice = 40.0;
            else if (selectedItem.equals("Poha")) 
            selectedItemPrice = 50.0;
            else if (selectedItem.equals("Sandwich")) 
            selectedItemPrice = 60.0;
        } else if (selectedCategory.equals("Lunch")) {
            if (selectedItem.equals("Thali")) 
            selectedItemPrice = 100.0;
            else if (selectedItem.equals("Rice")) 
            selectedItemPrice = 80.0;
            else if (selectedItem.equals("Dal")) 
            selectedItemPrice = 60.0;
            else if (selectedItem.equals("Chapati")) 
            selectedItemPrice = 40.0;
        } else if (selectedCategory.equals("Dinner")) {
            if (selectedItem.equals("Paneer")) 
            selectedItemPrice = 120.0;
            else if (selectedItem.equals("Noodles")) 
            selectedItemPrice = 90.0;
            else if (selectedItem.equals("Soup")) 
            selectedItemPrice = 70.0;
            else if (selectedItem.equals("Roti")) 
            selectedItemPrice = 50.0;
        }
        totalPrice = selectedItemPrice;
    }

    void showOrderSummary() {
        double gst = 0.18 * totalPrice;
        double finalPrice = totalPrice + gst;
        l5.setText("Total Price: $" + new DecimalFormat("##.##").format(finalPrice));
    }

    public static void main(String[] args) {
        new MenuAppList();
    }
}
