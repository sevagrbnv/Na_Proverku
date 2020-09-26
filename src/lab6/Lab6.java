package lab6;

interface Movable{
    public void draw();
    public void move(int a, int b);
}

class MovableRectangle implements Movable{
    private int a, b, x0, y0, x1, y1;

    public MovableRectangle(int a, int b){
        this.a = a;
        this.b = b;
        this.x0 = 0;
        this.y0 = 0;
        this.x1 = a;
        this.y1 = b;
    }

    public MovableRectangle(int x0, int y0, int x1, int y1){
        this.a = x1 - x0;
        this.b = y1 - y0;
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void draw() {
        for (int i = 0; i < y0; i++) {
            for (int j = 0; j < x1; j++)
                System.out.print(". ");
            if (i + 1 != y0) System.out.println();
        }
        if (y0 > 0) System.out.println();

        for (int j = 0; j < b; j++){
            for (int i = 0; i < x0; i++)
                System.out.print(". ");
            for (int i = 0; i < a; i++)
                System.out.print("* ");
            System.out.println();
        }
    }

    @Override
    public void move(int a, int b) {
        this.x0 += a;
        this.y0 += b;
        this.x1 += a;
        this.y1 += b;
    }

    public boolean isEqualSpeed(){
        if (x1 - x0 == a && y1 - y0 == b)
            return true;
        return false;
    }
}
public class Lab6 {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(6, 5);
        rect.draw();
        System.out.println();

        rect.move(3, 4);
        rect.draw();

        System.out.println("Проверка скорости точек: " + rect.isEqualSpeed());
    }

}
