public class main {
    static String[] HEART_MASK = new String[] {
        ".......*****.....*****.......",
        ".....*********.**********.....",
        "...***********************...",
        "..*************************..",
        ".***************************.",
        ".***************************.",
        ".***************************.",
        "..*************************..",
        "...***********************...",
        "....*********************....",
        ".....*******************.....",
        "......*****************......",
        ".......***************.......",
        "........*************........",
        ".........***********.........",
        "..........*********..........",
        "...........*******...........",
        "............*****............",
        ".............***.............",
        "..............*.............."
    };

    public static void main(String[] args) throws InterruptedException {
        int rows = HEART_MASK.length;
        int cols = HEART_MASK[0].length();
       
        int maxWave = rows + cols;
        int wavePos = 0;
        boolean forward = true;

        while (true) {
            clearScreen();
            for (int i = 0; i < rows; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < cols; j++) {
                    char ch = HEART_MASK[i].charAt(j);
                    if (ch == '*') {
                        
                        line.append((i + j) <= wavePos ? '*' : '.');
                    } else {
                        line.append(' ');
                    }
                }
                System.out.println(line);
            }

           
            if (forward) {
                if (++wavePos >= maxWave) forward = false;
            } else {
                if (--wavePos <= 0) forward = true;
            }

            Thread.sleep(100);
        }
    }

    private static void clearScreen() {
        
        System.out.print("\u001b[2J\u001b[H");
        System.out.flush();
    }
}
