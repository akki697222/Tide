package tide.ast;

public enum UnaryOperator {
    // 前置演算子
    TILDE("~"),         // ビット反転
    BANG("!"),          // 論理否定
    PLUS("+"),          // 単項プラス
    MINUS("-"),         // 単項マイナス
    PRE_INC("++"),      // 前置インクリメント
    PRE_DEC("--"),      // 前置デクリメント

    // 後置演算子
    POST_INC("++"),     // 後置インクリメント
    POST_DEC("--");     // 後置デクリメント

    private final String symbol;

    UnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * シンボルから対応するUnaryOperatorを取得（前置として）
     */
    public static UnaryOperator fromPrefixSymbol(String symbol) {
        switch (symbol) {
            case "~":
                return TILDE;
            case "!":
                return BANG;
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "++":
                return PRE_INC;
            case "--":
                return PRE_DEC;
            default:
                throw new IllegalArgumentException("Unknown prefix unary operator: " + symbol);
        }
    }

    /**
     * シンボルから対応するUnaryOperatorを取得（後置として）
     */
    public static UnaryOperator fromPostfixSymbol(String symbol) {
        switch (symbol) {
            case "++":
                return POST_INC;
            case "--":
                return POST_DEC;
            default:
                throw new IllegalArgumentException("Unknown postfix unary operator: " + symbol);
        }
    }

    /**
     * 前置演算子かどうかを判定
     */
    public boolean isPrefix() {
        switch (this) {
            case TILDE:
            case BANG:
            case PLUS:
            case MINUS:
            case PRE_INC:
            case PRE_DEC:
                return true;
            case POST_INC:
            case POST_DEC:
                return false;
            default:
                throw new IllegalArgumentException("Unknown operator: " + this);
        }
    }

    /**
     * 後置演算子かどうかを判定
     */
    public boolean isPostfix() {
        return !isPrefix();
    }

    /**
     * 演算子の優先順位を取得（数値が大きいほど優先順位が高い）
     */
    public int getPrecedence() {
        switch (this) {
            case POST_INC:
            case POST_DEC:
                return 15; // 後置演算子は最高優先度
            case TILDE:
            case BANG:
            case PLUS:
            case MINUS:
            case PRE_INC:
            case PRE_DEC:
                return 14; // 前置演算子は高優先度
            default:
                throw new IllegalArgumentException("Unknown operator: " + this);
        }
    }

    /**
     * 右結合かどうかを判定（単項演算子は通常右結合）
     */
    public boolean isRightAssociative() {
        return isPrefix(); // 前置演算子は右結合、後置演算子は左結合
    }

    @Override
    public String toString() {
        return symbol;
    }
}