package tide.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author akki697222
 * @since V1
 */
public class TideTypeObject extends TideObject {
    private final String typeName;
    private final TideTypeObject superType;
    private final Set<TideTypeObject> inheritTypes;
    private final Map<String, TideTypeObject> fieldTypes = new HashMap<>();

    public TideTypeObject(String typeName, TideTypeObject superType, Set<TideTypeObject> inheritTypes) {
        this.typeName = typeName;
        this.superType = superType;
        this.inheritTypes = inheritTypes;
    }

    public void addFieldType(String fieldName, TideTypeObject fieldType) {
        fieldTypes.put(fieldName, fieldType);
    }

    public TideTypeObject getFieldType(String fieldName) {
        TideTypeObject t = fieldTypes.get(fieldName);
        if (t == null && superType != null) {
            return superType.getFieldType(fieldName);
        }
        return t;
    }

    public String getTypeName() {
        return typeName;
    }

    public Set<TideTypeObject> getInheritTypes() {
        return inheritTypes;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
