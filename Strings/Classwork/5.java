public class CustomerIdentity {
    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);
        
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }

    public static String reverseCustomerName(String customerName) {
        char[] nameArray = customerName.toCharArray();
        StringBuilder reversedName = new StringBuilder();
        
        for (int i = nameArray.length - 1; i >= 0; i--) {
            reversedName.append(nameArray[i]);
        }
        
        return reversedName.toString();
    }
}
