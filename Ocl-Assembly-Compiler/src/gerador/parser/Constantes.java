package gerador.parser;

public interface Constantes {
    final String OP_OCL_IS_NEW = "oclIsNew";
    final String OP_OCL_IS_KIND_OF = "oclIsKindOf";
    final String OP_OCL_IS_TYPE_OF = "oclIsTypeOf";
    final String OP_OCL_IS_UNDEFINED = "oclIsUndefined";
    final String OP_UNARY_MENOS = "-";
    final String OP_UNARY_NOT = "not";
    final String OP_LOGICAL_AND = "and";
    final String OP_LOGICAL_XOR = "xor";
    final String OP_LOGICAL_OR = "or";
    final String OP_IMPLIES = "implies";
    final String OP_PLUS = "+";
    final String OP_TIMES = "*";
    final String OP_DIV = "/";
    final String OP_EQUAL = "=";
    final String OP_LT = "<=";
    final String OP_L = "<";
    final String OP_B = ">";
    final String OP_BT = ">=";
    final String OP_DIFF = "<>";
    final String APRE = "@pre";
    final String SELF = "self";
    final String RESULT = "result";
    final String VOID = "void";
    final String OP_COL_ANY =  "any";
    final String OP_COL_EXISTS =  "exists";
    final String OP_COL_SUM =  "sum";
    final String OP_COL_COUNT =  "count";
    final String OP_COL_SIZE =  "size";
    final String OP_COL_NOT_EMPTY =  "notEmpty";
    final String OP_COL_FOR_ALL =  "forAll";
    final String OP_COL_UNION =  "union";
    final String OP_COL_INTERSECTION =  "intersection";
    final String OP_COL_INCLUDES_ALL =  "includesAll";
    final String OP_COL_EXCLUDES_ALL =  "excludesAll";
    final String OP_COL_COLLECT =  "collect";
    final String OP_COL_REJECT =  "reject";
    final String OP_COL_SELECT =  "select";
    final String OP_COL_EXCLUDES =  "excludes";
    final String OP_COL_EXCLUDING =  "excluding";
    final String OP_COL_IS_EMPTY =  "isEmpty";
    final String OP_COL_INCLUDES =  "includes";
    final String OP_COL_INCLUDING =  "including";
    final String OP_COL_FIRST =  "first";
    final String OP_COL_LAST =  "last";
    final String OP_COL_AT =  "at";
    final String OP_COL_IS_UNIQUE =  "isUnique";
    
    public static final String PACOTE_PADRAO = "padrao";
    public static final String UML_MODEL = "Model";
    public static final String UML_CLASS = "uml:Class";
    public static final String UML_ENUM = "uml:Enumeration";
    public static final String PACKAGED_ELEMENT = "packagedElement";
    public static final String CONTEUDO_COLLECTION_PATTERN = "<[a-zA-Z]+>";
    public static final String COLLECTION_PATTERN = "(Set|OrderedSet|Bag|Sequence)"
                    + CONTEUDO_COLLECTION_PATTERN;
    public static final String LOWER_VALUE = "lowerValue";
    public static final String LOWER_VALUE_ATTR = "value";
    public static final String UPPER_VALUE = "upperValue";
    public static final String UPPER_VALUE_ATTR = "value";
    public static final String MANY = "*";
}


