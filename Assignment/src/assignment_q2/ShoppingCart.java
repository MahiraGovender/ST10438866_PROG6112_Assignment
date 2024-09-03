package assignment_q2;

import javax.swing.JOptionPane;

public class ShoppingCart {
    //Simplified version of an online shopping cart
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Products to choose from
        Items[] menuItems = new Items[] {
            new Items("Apple iPhone", 1, 999.99),
            new Items("Samsung TV", 1, 1299.99),
            new DiscountedItems("Nike Shoes", 1, 79.99, 10.0),
            new Items("Sony Headphones", 1, 49.99),
            new Items("Canon Camera", 1, 499.99)
        };
        //Referrancing object arrays
        /************************************************************
        *********************************************************
        Title: Create ArrayList from array
        Author: Christoffer Hammarström, StackOverflow
        Date: 2022
        Code version: 2.0
        Availability: https://stackoverflow.com/questions/157944/create-arraylist-from-array
        *********************************************************
        *************************************************************/

        while (true) {
            String option = JOptionPane.showInputDialog("Welcome!!!\n" //Welcome message
                    + "1. Add item to cart\n"
                    + "2. Remove item from cart\n"
                    + "3. Display cart\n"
                    + "4. Exit");

            if (option == null) { //.equals isnt working but == is...ask about that later
                JOptionPane.showMessageDialog(null, "No shopping today. Bye!");
                System.exit(0);
                return;
            }

            try {
                int chosenOption = Integer.parseInt(option);

                switch (chosenOption) {
                    case 1:
                        // Display menu
                        String menuString = "Menu:\n";
                        for (int i = 0; i < menuItems.length; i++) {
                            menuString += (i + 1) + ". " + menuItems[i].getName() + " - $" + menuItems[i].getPrice() + "\n";
                        }
                        String menuItemNumberString = JOptionPane.showInputDialog(menuString);
                        if (menuItemNumberString.equals(null)) {
                            JOptionPane.showMessageDialog(null, "Please enter a value");
                            return;
                        }
                        int menuItemNumber = Integer.parseInt(menuItemNumberString);
                        if (menuItemNumber > 0 && menuItemNumber <= menuItems.length) {
                            Items selectedItem = menuItems[menuItemNumber - 1];
                            String quantityString = JOptionPane.showInputDialog("Enter quantity:");
                            if (quantityString.equals(null)) {
                                JOptionPane.showMessageDialog(null, "Please enter a value");
                                return;
                            }
                            int quantity = Integer.parseInt(quantityString);
                            if (selectedItem instanceof DiscountedItems) { /*For discount items e.g. Nike shoes*/
                                cart.addItem(new DiscountedItems(selectedItem.getName(), quantity, selectedItem.getPrice(), ((DiscountedItems) selectedItem).getDiscountPercentage()));
                            } else {
                                cart.addItem(new Items(selectedItem.getName(), quantity, selectedItem.getPrice()));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid menu item number. Please try again.");
                        }
                        break;
                    case 2: //deleting items from shopper's cart
                        String removeName = JOptionPane.showInputDialog("Enter item name to remove:");
                        if (removeName.equals(null)) {
                            JOptionPane.showMessageDialog(null, "Please enter a value");
                            return;
                        }
                        cart.removeItem(removeName);
                        break;
                    case 3: //shows what the shopper is buying and the total price it will come to
                        cart.displayCart();
                        break;
                    case 4:
                        //Goodbye message to user
                        JOptionPane.showMessageDialog(null, "BYE SHOPPER!!! SEE YOU AGAIN NEXT TIME!!!");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }
}
