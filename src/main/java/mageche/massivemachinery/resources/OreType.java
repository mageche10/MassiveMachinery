package mageche.massivemachinery.resources;

import mageche.massivemachinery.block.OreBlock;

public enum OreType {
    TIN(PrimaryResource.TIN),
    LEAD(PrimaryResource.LEAD),
    ZINC(PrimaryResource.ZINC),
    BAUXITE(PrimaryResource.BAUXITE),
    SULFUR(PrimaryResource.SULFUR, 1, 3);

    private final int minExp;
    private final int maxExp;
    private final IResource resource;

    OreType(IResource resource){
        this(resource, 0);
    }

    OreType(IResource resource, int exp){
        this(resource, exp, exp);
    }

    OreType(IResource resource, int minExp, int maxExp) {
        this.minExp = minExp;
        this.maxExp = maxExp;
        this.resource = resource;
    }

    public int getMinExp() {
        return minExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public IResource getResource() {
        return resource;
    }

    public OreType[] getOres(){
        return values();
    }
}
