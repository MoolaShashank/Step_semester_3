import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GardenPlotReport {
    abstract static class Plot {
        protected String owner;
        public Plot(String owner) { this.owner = owner; }
        public String getOwner() { return owner; }
        public abstract double calculateArea();
    }

    static class Circle extends Plot {
        private double radius;
        public Circle(String owner, double radius) { 
            super(owner); 
            this.radius = radius; 
        }
        @Override
        public double calculateArea() { return Math.PI * radius * radius; }
    }

    static class Rectangle extends Plot {
        private double length, width;
        public Rectangle(String owner, double length, double width) { 
            super(owner); 
            this.length = length; 
            this.width = width; 
        }
        @Override
        public double calculateArea() { return length * width; }
    }

    static class Triangle extends Plot {
        private double base, height;
        public Triangle(String owner, double base, double height) { 
            super(owner); 
            this.base = base; 
            this.height = height; 
        }
        @Override
        public double calculateArea() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Plot> plots = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            String owner = sc.next();
            
            switch (type) {
                case "CIRCLE": plots.add(new Circle(owner, sc.nextDouble())); break;
                case "RECTANGLE": plots.add(new Rectangle(owner, sc.nextDouble(), sc.nextDouble())); break;
                case "TRIANGLE": plots.add(new Triangle(owner, sc.nextDouble(), sc.nextDouble())); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < plots.size(); i++) {
            double area = plots.get(i).calculateArea();
            total += area;
            System.out.printf("%s (%s): %.2f\n", plots.get(i).getOwner(), types.get(i), area);
        }
        System.out.printf("Total Area: %.2f\n", total);
        sc.close();
    }
}
