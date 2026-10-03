import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ParcelShipping {
    interface Insurable {
        double calculateInsurance(double declaredValue);
    }
    
    abstract static class Parcel {
        protected double weight;
        protected double declaredValue;
        
        public Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }
        
        public abstract double calculateCharge();
        
        public double getDeclaredValue() { 
            return declaredValue; 
        }
    }
    
    static class StandardParcel extends Parcel {
        public StandardParcel(double weight, double declaredValue) { 
            super(weight, declaredValue); 
        }
        @Override
        public double calculateCharge() { 
            return 40.0 + (10.0 * weight); 
        }
    }
    
    static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weight, double declaredValue) { 
            super(weight, declaredValue); 
        }
        @Override
        public double calculateCharge() { 
            return 80.0 + (15.0 * weight); 
        }
        @Override
        public double calculateInsurance(double declaredValue) { 
            return declaredValue * 0.02; 
        }
    }
    
    static class FragileParcel extends StandardParcel implements Insurable {
        public FragileParcel(double weight, double declaredValue) { 
            super(weight, declaredValue); 
        }
        @Override
        public double calculateCharge() { 
            return super.calculateCharge() + 50.0; 
        }
        @Override
        public double calculateInsurance(double declaredValue) { 
            return declaredValue * 0.02; 
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Parcel> parcels = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            double w = sc.nextDouble();
            double val = sc.nextDouble();
            
            switch (type) {
                case "STANDARD": parcels.add(new StandardParcel(w, val)); break;
                case "EXPRESS": parcels.add(new ExpressParcel(w, val)); break;
                case "FRAGILE": parcels.add(new FragileParcel(w, val)); break;
            }
        }
        
        double grandTotal = 0;
        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            double charge = p.calculateCharge();
            double insurance = 0.00;
            
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance(p.getDeclaredValue());
            }
            
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", types.get(i), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}
