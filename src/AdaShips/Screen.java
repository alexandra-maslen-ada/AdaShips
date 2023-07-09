package AdaShips;

public abstract class Screen {
    public static void printSingleBoard(Player player1) {
        // Print column letters
        System.out.print("  ");
        for(int i = 0; i < player1.board.cells[0].length; i++) {
            System.out.print((char)('A'+ i) + "  ");
        }
        System.out.println();

        // Print board rows
        for(int i = 0; i < player1.board.cells.length; i++) {
            StringBuilder row = new StringBuilder();
            // Print row number
            row.append(i).append(" ");
            // Print board columns
            for (int j = 0; j < player1.board.cells[i].length; j++) {
                row.append(player1.board.cells[i][j] + "  ");
            }
            System.out.println(row);
        }
    }

    // Change user coords (e.g. B3) to coord object (e.g. x=1,y=3)
    public static Coords parseCoordinates(String coordString) {
        char letter = Character.toUpperCase(coordString.charAt(0));
        int x = letter - 'A'; // Convert char to int
        int y = Integer.parseInt(coordString.substring(1));
        return new Coords(x, y);
    }

    public static void printListOfShips(Ship[] ships) {
        System.out.println("Ships to place: ");
        for(Ship ship : ships) {
            if(!ship.isPlaced()) { // Only print the ships that are not placed so far by user
                System.out.println(" * " + ship.name + " " + ship.length);
            }
        }
    }

    public static void printPlayerBoards(Player player1, Player player2) { // Construct a formatted representation of boards
        // with the status of each cell in a visually aligned manner
        System.out.println("\t");
        System.out.println("      Your fleet             Enemy's fleet");
        System.out.print("  A B C D E F G H I J     A B C D E F G H I J\n");

        for (int i = 0; i < player1.board.cells.length; i++) {
            StringBuilder row = new StringBuilder();
            // Print row number
            row.append(i).append(" ");

            for (int j = 0; j < player1.board.cells[i].length; j++) {
                row.append(player1.board.cells[i][j] + " ");
            }
            row.append("\t" + (i)).append(" ");

            for (int j = 0; j < player2.board.cells[i].length; j++) {
                if (player2.board.cells[i][j].equals("M") || player2.board.cells[i][j].equals("H") || player2.board.cells[i][j].equals(" ") ) {
                    row.append(player2.board.cells[i][j] + " "); // Increased spacing for better visual representation
                } else {
                    row.append("  ");
                }
            }
            System.out.println(row);
        }
    }
}
