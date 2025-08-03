package tide.core;

import java.util.Set;

public record TideObjectHolder(TideObject object, Set<Modifier> modifiers) {}