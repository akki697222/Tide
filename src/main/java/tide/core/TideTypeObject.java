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
    private final Set<TideTypeObject> inheritTypes;

    public TideTypeObject(String typeName, Set<TideTypeObject> inheritTypes) {
        this.typeName = typeName;
        this.inheritTypes = inheritTypes;
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
