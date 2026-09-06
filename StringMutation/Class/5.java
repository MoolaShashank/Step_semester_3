public class BankTransaction {
    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference("  hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: length must be exactly 14 characters";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: sequence must contain only digits after the bank code";
            }
        }
        
        String bankCode = reference.substring(0, 3);
        String dateStr = reference.substring(3, 5) + "/" + 
                         reference.substring(5, 7) + "/" + 
                         reference.substring(7, 9);
        String seqStr = reference.substring(9, 14);
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ")
                 .append("DATE: ").append(dateStr).append(" | ")
                 .append("SEQ: ").append(seqStr);
                 
        return formatted.toString();
    }
}
