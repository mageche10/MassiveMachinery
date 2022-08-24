package mageche.massivemachinery.resources;

public enum PrimaryResource implements IResource{
    TIN("tin"),
    LEAD("lead"),
    BAUXITE("bauxite"),
    SULFUR("sulfur"),
    ZINC("zinc"),
    IRON("iron"),
    GOLD("gold");

    private final String name;

    PrimaryResource(String name) {
        this.name = name;
    }

    @Override
    public String getRegistryName() {
        return name;
    }
}
