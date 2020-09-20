public class Lab5 {
    public static void main(String[] args) {
        Quadrat quad = new Quadrat();
        quad.setAB(5);
        quad.draw();
        System.out.println();

        Square sqr = new Square();
        sqr.setLengthA(4);
        sqr.setLengthB(8);
        sqr.draw();
        System.out.println();

        Circle circle = new Circle();
        circle.setRadius(8);
        System.out.println("Радиус: " + circle.getRadius());
        System.out.println();

        Rectangle rect = new Rectangle();
        rect.setCenterX(2);
        rect.setCenterY(5);
        System.out.println("Координаты центра треугольника: X = " + rect.getCenterX() + " Y = " + rect.getCenterY());
    }
}

abstract class Shape{
    abstract void draw();
}

class Rectangle extends Shape{
    protected int centerX;
    protected int centerY;
    protected int lengthA;
    protected int lengthB;
    protected int lengthC;

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setLengthABC(int lengthA, int lengthB, int lengthC) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getLengthA() {
        return lengthA;
    }

    public int getLengthB() {
        return lengthB;
    }

    public int getLengthC() {
        return lengthC;
    }

    @Override
    void draw() {
//реализация есть пока только в классе Square
    }
}

class EquallateralRect extends Rectangle{

    public void setLengthABC(int lengthA) {
        this.lengthA = lengthA;
        this.lengthB = lengthA;
        this.lengthC = lengthC;

    }

    public int getLengthA() {
        return super.getLengthA();
    }
}

class Circle extends Shape{
    @Override
    void draw() {

    }

    private int radius;
    private int centerX;
    private int centerY;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getRadius() {
        return radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
}

class Square{
    protected int centerX;
    protected int centerY;
    protected int lengthA;
    protected int lengthB;

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setLengthA(int lengthA) {
        this.lengthA = lengthA;
    }

    public void setLengthB(int lengthB) {
        this.lengthB = lengthB;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getLengthA() {
        return lengthA;
    }

    public int getLengthB() {
        return lengthB;
    }

    void draw(){
        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++)
                System.out.print(".  ");
            System.out.println();
        }
    }
}

class Quadrat extends Square{
    void setAB(int lengthA){
        this.lengthA = lengthA;
        this.lengthB = lengthA;
    }

    @Override
    public int getLengthA() {
        return super.getLengthA();
    }
}