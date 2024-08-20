package joelf.tech.rinha.enums;

public enum TransactionType {
    CREDIT('c'),
    DEBIT('d');

    private Character code;

    TransactionType(Character code) {
        this.code = code;
    }

    public TransactionType valueOfCode(Character code) {
        for (var type : TransactionType.values()) {
            if (type.equals(code)) {
                return type;
            }
        }
        throw new RuntimeException("Transaction's type doesn't exists.");
    }
}
