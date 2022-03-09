public class Painting {

    private int width = 0;
    private int height = 0;
    private PaintingCell[][] painting;

    public Painting(int row, int column){
        this.width = row;
        this.height = column;

        this.painting = new PaintingCell[row][column];
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < column; c++) {
                this.painting[r][c] = new PaintingCell("red", false);
            }
        }
    }

    public boolean checkBounds(int row, int column) {
        if(row < 0 || row > width) return false;
        if(column < 0 || column > height) return false;

        return true;
    }

    public void paint(int row, int column, String color) {
        this.painting[row][column].setVisibility(true);
        this.painting[row][column].changeColor(color);
    }

    public void erase(int row, int column) {
        this.painting[row][column].setVisibility(false);
    }

    public String toString() {
        String result = "";
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                result += this.painting[x][y].toString();
            }
            result += "\n";
        }
        return result;
    }

}
