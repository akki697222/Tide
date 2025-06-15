package tide.ast;

public enum BinaryOperator {
    // 論理演算子
    OR("||"),           // 論理和
    AND("&&"),          // 論理積

    // ビット演算子
    BOR("|"),           // ビット和
    BXOR("^"),          // ビット排他的論理和
    BAND("&"),          // ビット積

    // 等価演算子
    EQ("=="),           // 等価
    NE("!="),           // 非等価

    // 関係演算子
    LT("<"),            // 未満
    LE("<="),           // 以下
    GT(">"),            // 超過
    GE(">="),           // 以上

    // シフト演算子
    LSH("<<"),          // 左シフト
    RSH(">>"),          // 右シフト

    // 算術演算子
    ADD("+"),           // 加算
    SUB("-"),           // 減算
    MUL("*"),           // 乗算
    DIV("/"),           // 除算
    MOD("%"),           // 剰余

    // 代入演算子
    ASSIGN("="),        // 単純代入
    ADD_ASSIGN("+="),   // 加算代入
    SUB_ASSIGN("-="),   // 減算代入
    MUL_ASSIGN("*="),   // 乗算代入
    DIV_ASSIGN("/="),   // 除算代入
    MOD_ASSIGN("%="),   // 剰余代入
    LSH_ASSIGN("<<="),  // 左シフト代入
    RSH_ASSIGN(">>="),  // 右シフト代入
    BAND_ASSIGN("&="),  // ビット積代入
    BOR_ASSIGN("|="),   // ビット和代入
    BXOR_ASSIGN("^=");  // ビット排他的論理和代入

    private final String symbol;

    BinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * シンボルから対応するBinaryOperatorを取得
     */
    public static BinaryOperator fromSymbol(String symbol) {
        for (BinaryOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown binary operator: " + symbol);
    }

    /**
     * 演算子の優先順位を取得（数値が小さいほど優先順位が低い）
     */
    public int getPrecedence() {
        switch (this) {
            // 代入演算子（最低優先度）
            case ASSIGN:
            case ADD_ASSIGN:
            case SUB_ASSIGN:
            case MUL_ASSIGN:
            case DIV_ASSIGN:
            case MOD_ASSIGN:
            case LSH_ASSIGN:
            case RSH_ASSIGN:
            case BAND_ASSIGN:
            case BOR_ASSIGN:
            case BXOR_ASSIGN:
                return 0;
            case OR:
                return 1;
            case AND:
                return 2;
            case BOR:
                return 3;
            case BXOR:
                return 4;
            case BAND:
                return 5;
            case EQ:
            case NE:
                return 6;
            case LT:
            case LE:
            case GT:
            case GE:
                return 7;
            case LSH:
            case RSH:
                return 8;
            case ADD:
            case SUB:
                return 9;
            case MUL:
            case DIV:
            case MOD:
                return 10;
            default:
                throw new IllegalArgumentException("Unknown operator: " + this);
        }
    }

    /**
     * 左結合かどうかを判定
     */
    public boolean isLeftAssociative() {
        switch (this) {
            // 代入演算子は右結合
            case ASSIGN:
            case ADD_ASSIGN:
            case SUB_ASSIGN:
            case MUL_ASSIGN:
            case DIV_ASSIGN:
            case MOD_ASSIGN:
            case LSH_ASSIGN:
            case RSH_ASSIGN:
            case BAND_ASSIGN:
            case BOR_ASSIGN:
            case BXOR_ASSIGN:
                return false;
            // その他の二項演算子は左結合
            default:
                return true;
        }
    }

    /**
     * 代入演算子かどうかを判定
     */
    public boolean isAssignment() {
        switch (this) {
            case ASSIGN:
            case ADD_ASSIGN:
            case SUB_ASSIGN:
            case MUL_ASSIGN:
            case DIV_ASSIGN:
            case MOD_ASSIGN:
            case LSH_ASSIGN:
            case RSH_ASSIGN:
            case BAND_ASSIGN:
            case BOR_ASSIGN:
            case BXOR_ASSIGN:
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return symbol;
    }
}