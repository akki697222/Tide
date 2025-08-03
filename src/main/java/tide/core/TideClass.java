package tide.core;

import tide.runtime.error.ReferenceError;

import java.util.*;

public class TideClass extends TideObject {
    protected final TideTypeObject type;
    protected final String name;
    protected final TideProgram body;
    protected final Set<Modifier> modifiers;
    protected final List<String> inherits;
    protected final Map<String, TideObjectHolder> instanceFields;
    protected final boolean isInstance;

    public TideClass(String name, TideProgram body, Set<Modifier> modifiers, List<String> inherits) {
        this.type = new TideTypeObject(name, collectInheritedClassesTypeInfo(inherits));
        this.name = name;
        this.body = body;
        this.modifiers = modifiers;
        this.inherits = inherits;
        this.instanceFields = new HashMap<>();
        this.isInstance = false;
    }

    private TideClass(TideClass parent) {
        this.type = parent.type;
        this.name = parent.name;
        this.body = parent.body;
        this.modifiers = parent.modifiers;
        this.inherits = parent.inherits;
        this.instanceFields = parent.instanceFields;
        this.fields.putAll(parent.fields);
        this.isInstance = true;
    }

    public TideClass instantiate() {
        return new TideClass(this);
    }

    public TideObject getInstanceField(String name) {
        return instanceFields.getOrDefault(name, NULL_HOLDER).object();
    }

    @Override
    public TideObject getField(String name) {
        return instanceFields.getOrDefault(name, fields.getOrDefault(name, NULL_HOLDER)).object();
    }

    public void setInstanceField(String name, TideObject object) {
        if (instanceFields.containsKey(name)) {
            instanceFields.replace(name, new TideObjectHolder(object, Set.of(Modifier.PUBLIC)));
        } else {
            instanceFields.put(name, new TideObjectHolder(object, Set.of(Modifier.PUBLIC)));
        }
    }

    public void setInstanceField(String name, TideObjectHolder object) {
        if (instanceFields.containsKey(name)) {
            instanceFields.replace(name, object);
        } else {
            instanceFields.put(name, object);
        }
    }

    @Override
    public TideTypeObject getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public TideProgram getBody() {
        return body;
    }

    public List<String> getInherits() {
        return inherits;
    }

    public Set<Modifier> getModifiers() {
        return modifiers;
    }

    private Set<TideTypeObject> collectInheritedClassesTypeInfo(List<String> inherits) {
        Set<TideTypeObject> newInherits = new HashSet<>();
        for (String inherit : inherits) {
            TideObject object = runtime.env().get(inherit);
            if (object instanceof TideClass tideClass) {
                newInherits.add(new TideTypeObject(tideClass.name, tideClass.type.getInheritTypes()));
            }
        }
        return newInherits;
    }
}
